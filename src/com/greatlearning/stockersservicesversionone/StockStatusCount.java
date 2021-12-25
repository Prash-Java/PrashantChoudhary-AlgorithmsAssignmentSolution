package com.greatlearning.stockersservicesversionone;
//Class for keeping stock of companies for their rising or declining stock values as compared to yesterday
public class StockStatusCount {
	//Basic counters to store count for rising/declining stock values
	private int trueCount = 0;
	private int falseCount = 0;
	//Method for taking count on rising stock values of Companies and taking their count
	public int countCompanyWithRisingStockStatus(boolean[] stockStatus){
		for(int i=0;i<stockStatus.length;i++) {
			if (stockStatus[i]) {
				trueCount++;
			}
		}
		return trueCount;
	}
	//Method for taking count on declining stock values of Companies and taking their count
	public int countCompanyWithDecliningStockStatus(boolean[] stockStatus){
		for(int i=0;i<stockStatus.length;i++) {
			if (!stockStatus[i]) {
				++falseCount;
			}
		}
		return falseCount;
	}
}
