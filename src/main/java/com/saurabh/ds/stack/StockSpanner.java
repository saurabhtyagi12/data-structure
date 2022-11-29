package com.saurabh.ds.stack;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {

	private List<Integer> stockPrices = new ArrayList<Integer>();
	private List<Integer> stockPriceSpan = new ArrayList<Integer>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
    	stockPrices.add(price);
    	return getSpan(price, stockPrices.size() - 1);        
    }
    
	private int getSpan(int price, int itemIndex) {
		if(itemIndex == 0) {
			stockPriceSpan.add(1);
			return stockPriceSpan.get(itemIndex);
		}
		
		for(int i = itemIndex -1; i <= itemIndex; i++) {
			if(stockPrices.get(itemIndex) < stockPrices.get(i)) {
				stockPriceSpan.add(1);
				break;
			} else {
				int backIndex = i;
				int span = 1;
				while(backIndex >= 0 && (stockPrices.get(itemIndex) >= stockPrices.get(backIndex))) {
					span = span + stockPriceSpan.get(backIndex);
					backIndex = backIndex - stockPriceSpan.get(backIndex);
				}
				stockPriceSpan.add(span);
				break;
			}
		}
		
		return stockPriceSpan.get(itemIndex);
	}

	void printStockPriceAndSpan(){
		System.out.println(stockPrices);
		System.out.println(stockPriceSpan);
	}
	
	public static void main(String[] args) {
		// [[], [100], [80], [60], [70], [60], [75], [85]]
		// [null, 1, 1, 1, 2, 1, 4, 6]
		
		StockSpanner stockSpanner = new StockSpanner();
		stockSpanner.next(100); // return 1
		stockSpanner.next(80);  // return 1
		stockSpanner.next(60);  // return 1
		stockSpanner.next(70);  // return 2
		stockSpanner.next(60);  // return 1
		stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
		stockSpanner.next(85);  // return 6
		
		stockSpanner.printStockPriceAndSpan();
	}
}
