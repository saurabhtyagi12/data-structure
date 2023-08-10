package com.saurabh.ds;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args){
		Map<String, String> map = new HashMap<String, String>();
		String requestId = "UPDATE_INTERACTION-WORKCODE-148f395d-9c58-474e-9752-5fcdd44af4d3";
		map.put(requestId, "0");
		String requestId1 = "UPDATE_INTERACTION-WORKCODE-148f395d-9c58-474e-9752-5fcdd44af4d1";
		map.put(requestId1, "1");
		String requestId2 = "UPDATE_INTERACTION-WORKCODE-148f395d-9c58-474e-9752-5fcdd44af4d2";
		map.put(requestId2, "2");
		String requestId4 = "UPDATE_INTERACTION-WORKCODE-148f395d-9c58-474e-9752-5fcdd44af4d4";
		map.put(requestId4, "1");
		System.out.println(map.containsKey("UPDATE_INTERACTION-WORKCODE-148f395d-9c58-474e-9752-5fcdd44af4d3"));
		String str = "UPDATE_INTERACTION-WORKCODE-148f395d-9c58-474e-9752-5fcdd44af4d3";
		System.out.println(map.containsKey(str));
		List<String> ls = new ArrayList<>();
		ls.add("100");
		map.values().removeAll(ls);
		System.out.println(map.containsKey(str));
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key + " :: " + map.get(key));			
		}
	}
}