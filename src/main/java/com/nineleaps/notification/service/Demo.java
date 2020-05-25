package com.nineleaps.notification.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

	//ip arr
	int n;
	public static void main(String[] args) {
		int[] arr = {7, 10, 4, 20, 15};
		Demo d = new Demo();
		d.n = 2;
		
		for(int i=0;i<d.n;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(arr[d.n-1]);
		
		Stream<String> names = Stream.of("aBc", "d", "ef");
		List<String> list = names.map(i -> i.toUpperCase()).collect(Collectors.toList());

		get(d);
		System.out.println(d.n);
	}
	
	public static void get(Demo x) {
		x.n=10;
	}

}
