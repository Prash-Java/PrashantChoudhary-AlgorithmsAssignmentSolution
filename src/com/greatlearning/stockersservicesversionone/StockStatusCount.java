package com.greatlearning.stockersservicesversionone;

import java.util.Arrays;

public class StockStatusCount {
    private int trueCount = 0;
    private int falseCount = 0;
    
    public int countCompanyWithRisingStockStatus(boolean[] stockStatus){
        for(int i=0;i<stockStatus.length;i++) {
            if (stockStatus[i] == true) {
                ++trueCount;
            }
        }
        return trueCount;
    }
    public int countCompanyWithDecliningStockStatus(boolean[] stockStatus){
        for(int i=0;i<stockStatus.length;i++) {
            if (stockStatus[i] == false) {
                ++falseCount;
            }
        }
        return falseCount;
    }
}
