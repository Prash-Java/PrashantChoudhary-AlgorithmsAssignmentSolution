package com.greatlearning.stockersservicesversionone;

//Class Service For Binary Search Operation
public class BinarySearchImplementation {
	//Method to perform binary search in an array which is already sorted
	public void performBinarySearch(double[] stockPrices, int first, int last, double key) {
		int mid = (first+last)/2;
		while(first<=last) {
			//Exact Element Match Condition
			if(stockPrices[mid]==key) {
				System.out.println("Stock of value " +key+ " is present");
				break;
			}
			//If Searched Element Value or key is more than mid of array at any point
			else if(stockPrices[mid]<key) {
				first = first + 1;
			}
			//If Searched Element Value or key is less than mid of array at any point
			else {
				last = last - 1;
			}
			mid = (first + last)/2;
		}
		//Criteria In Case Element Is Not Available
		if(first>last) {
			System.out.println("Value not found");
		}

	}
}
