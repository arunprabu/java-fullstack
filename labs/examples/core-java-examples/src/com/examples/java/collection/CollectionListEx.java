package com.examples.java.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class CollectionListEx {
	
	public static void main(String[] args) {
		
		Collection countries = new Vector();
		
		
		
//		countries.add("India");  // 0
//		countries.add("USA"); // 1
//		countries.add("China"); // 2
		
		
		
		for(int i = 0; i < 500; i++)
		{
			countries.add("India"+i);
		}
		
		System.out.println(countries.size());
		//System.out.println(countries.get(1));
		
		for(Object item: countries)
		{
			System.out.println(item);
		}
		
		Object[] countryArr = countries.toArray();
		
		System.out.println("Country Array size: " + countryArr.length);
		
		List countriesFromArr = Arrays.asList(countryArr);
		
		System.out.println(countriesFromArr.size());
//		countries.remove(0);
//		
//		System.out.println(countries.size());
//		for(Object item: countries)
//		{
//			System.out.println(item);
//		}		
	}

}
;