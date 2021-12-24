package com.greatlearning.stockersservicesversiontwo;

public class BinarySearchImplementation {
    public void performBinarySearch(double[] stockPrices, int first, int last, double key) {
        int mid = (first+last)/2;
            while(first<=last) {
                if(stockPrices[mid]==key) {
                    System.out.println("Stock of value " +key+ " is present");
                    break;
                }
                else if(stockPrices[mid]<key) {
                    first = first + 1;
                }
                else {
                    last = last - 1;
                }
                mid = (first + last)/2;
            }
        if(first>last) {
            System.out.println("Value not found");
        }

    }
}
