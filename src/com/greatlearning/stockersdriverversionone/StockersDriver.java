package com.greatlearning.stockersdriverversionone;

import java.util.Scanner;

import com.greatlearning.stockersservicesversionone.BinarySearchImplementation;
import com.greatlearning.stockersservicesversionone.MergeSortImplementation;
import com.greatlearning.stockersservicesversionone.StockStatusCount;

public class StockersDriver {
    public static Scanner sc = new Scanner(System.in);
    private static double[] stockPrices;
    private static boolean[] stockStatus;
    private static boolean flag = true;
    private static MergeSortImplementation mergeSortImplementation = new MergeSortImplementation();
    private static BinarySearchImplementation binarySearchImplementation = new BinarySearchImplementation();
    private static StockStatusCount stockStatusCount = new StockStatusCount();
    private static int choice;
    
    public static void main(String[] args){
        System.out.println("enter the no of companies");
        int numberOfCompanies = sc.nextInt();
        if(numberOfCompanies>0){
            stockPrices = new double[numberOfCompanies];
            stockStatus = new boolean[numberOfCompanies];
            for(int i=0;i<numberOfCompanies;i++){
                System.out.println("Enter current stock price of the company " + (i+1));
                stockPrices[i] = sc.nextDouble();
                System.out.println("Whether company's stock price rose today compare to yesterday?");
                stockStatus[i] = sc.nextBoolean();
            }

            while(flag){
                System.out.println("Enter the operation that you want to perform");
                System.out.println("1. Display the companies stock prices in ascending order");
                System.out.println("2. Display the companies stock prices in descending order");
                System.out.println("3. Display the total no of companies for which stock prices rose today");
                System.out.println("4. Display the total no of companies for which stock prices declined today");
                System.out.println("5. Search a specific stock price");
                System.out.println("6. press 0 to exit");

                choice = sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("Stock prices in ascending order are :");
                        mergeSortImplementation.sortInAscendingOrder(stockPrices,0,stockPrices.length-1);
                        mergeSortImplementation.displayCompanyStockPrices(stockPrices);
                        break;
                    case 2:
                        System.out.println("Stock prices in descending order are :");
                        mergeSortImplementation.sortInDescendingOrder(stockPrices,0,stockPrices.length-1);
                        mergeSortImplementation.displayCompanyStockPrices(stockPrices);
                        break;
                    case 3:
                        System.out.println("Total no of companies whose stock price rose today : " + stockStatusCount.countCompanyWithRisingStockStatus(stockStatus));
                        break;
                    case 4:
                        System.out.println("Total no of companies whose stock price declined today : " + stockStatusCount.countCompanyWithDecliningStockStatus(stockStatus));
                        break;
                    case 5:
                        System.out.println("enter the key value");
                        double key = sc.nextDouble();
                        mergeSortImplementation.sortInAscendingOrder(stockPrices,0,stockPrices.length-1);
                        binarySearchImplementation.performBinarySearch(stockPrices,0,stockPrices.length-1,key);
                        break;
                    case 0:
                        System.out.println("Exited successfully");
                        flag = false;
                        break;
                    default:
                        System.out.println("Enter Values Between 0 and 5");
                        break;
                }
            }
        }
        else{
            System.out.println("Enter number of companies greater than or equal to 1");
        }
        sc.close();
    }
}

