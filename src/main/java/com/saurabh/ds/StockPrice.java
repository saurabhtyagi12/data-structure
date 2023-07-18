package com.saurabh.ds;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/stock-price-fluctuation/description/

public class StockPrice {
	
	private int currentPrice;
	private int currentTimestamp;
	private int maxPrice;
	private int minPrice;
	Map<Integer, Price> prices;
	List<Price> sortedPrices;
	
	public StockPrice() {
		prices = new HashMap<Integer, Price>();
		sortedPrices = new ArrayList<Price>();
	}
	
	public void updatePrice(int timestamp, int price) {
		if(currentTimestamp <= timestamp){
			currentPrice = price;
			currentTimestamp = timestamp;
		}
		
		System.out.println(sortedPrices);
		Price priceOb = prices.get(timestamp);
		updateSortedPrice(timestamp, price, priceOb);
		System.out.println(sortedPrices);
		
		maxPrice = sortedPrices.get(sortedPrices.size() -1).getPrice();
		minPrice = sortedPrices.get(0).getPrice();
	}
	
	private void updateSortedPrice(int timestamp, int price, Price priceOld){
		if(priceOld != null)
			sortedPrices.remove(priceOld);

		Price priceOb = new Price(timestamp, price);
		prices.put(timestamp, priceOb);

		int length = sortedPrices.size();
		if(length == 0){
			sortedPrices.add(priceOb);
			return;
		}
		
		if(length == 1){
			if(sortedPrices.get(0).getPrice() < priceOb.getPrice()){
				sortedPrices.add(priceOb);
			} else {
				sortedPrices.add(0, priceOb);				
			}
			return;
		}
		
		int positionToInsert = getPositionToInsert(0, length - 1, priceOb.getPrice());
		sortedPrices.add(positionToInsert, priceOb);				
	}
	
	private int getPositionToInsert(int startPos, int endPos, int price) {
		if(sortedPrices.get(startPos).getPrice() >= price){
			return startPos;				
		} else if(sortedPrices.get(endPos).getPrice() <= price){
			return endPos + 1;				
		} 
		
		int mid = (startPos + endPos) / 2;
		if(sortedPrices.get(startPos).getPrice() <= price && sortedPrices.get(mid).getPrice() >= price){
			return getPositionToInsert(startPos, mid, price);
		} else {
			return getPositionToInsert(mid + 1, endPos, price);
		}
	}
	
	public int current() {
		return currentPrice;
	}
	
	public int maximum() {
		return maxPrice;
	}
	
	public int minimum() {
		return minPrice;
	}
	
	class Price {
		int timestamp;
		int price;
		
		Price(int timestamp, int price) {
			this.timestamp = timestamp;
			this.price = price;
		}
		
		public int getPrice() {
			return price;
		}
	
		public void setPrice(int price) {
			this.price = price;
		}
	
		public int getTimestamp() {
			return timestamp;
		}
	
		public String toString() {
			return "[" + timestamp + "," + price + "]";
		}
	}
	
	public static void main(String[] args) {
		StockPrice sp = new StockPrice();
		sp.updatePrice(1, 10);
		sp.updatePrice(2, 5);
		System.out.println(sp.current());
		System.out.println(sp.maximum());
		sp.updatePrice(1, 3);
		System.out.println(sp.maximum());
		sp.updatePrice(4, 2);
		System.out.println(sp.minimum());
	}
}