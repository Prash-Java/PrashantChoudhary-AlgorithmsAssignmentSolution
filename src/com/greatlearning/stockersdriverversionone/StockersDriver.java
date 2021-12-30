package com.greatlearning.stockersdriverversionone;
//Imported Pre-built Libraries Jar Files
import java.util.Scanner;
import com.greatlearning.stockersservicesversionone.BinarySearchImplementation;
import com.greatlearning.stockersservicesversionone.MergeSortImplementation;
import com.greatlearning.stockersservicesversionone.StockStatusCount;

//This Is Driver Class That Controls The Application Logic
public class StockersDriver {
	//Scanner Class, its object will be required to take input from users on console
	//Not created any modal class because we have only two arrays in this requirement, and i have gone with private data members
	/*Not used Getter & Setters here or in service package classes, because even though data members are private, i use it within same class
	for data access*/
	/*Have used Service package to classify different classes based on distinct functionalities of problem statement like sorting and then
	  searching, one service class can also serve the purpose, but that might not look like clean code and all methods at same place might be
	  complicated in appearance*/

	//	public static Scanner sc = new Scanner(System.in);
	//Data Members, Arrays of types double and boolean to hold stock prices and stock status of company, scope is global within this class, so its data members at class level
	private static double[] stockPrices;
	private static boolean[] stockStatus;
	//boolean variable with scope global within this class and another int variable to hold user input which scope will be global but within this class
	private static boolean flag = true;
	public static int choice;
	//Service Package Classes are instantiated and referenced with their created object, using default constructors
	private static MergeSortImplementation mergeSortImplementation = new MergeSortImplementation();
	private static BinarySearchImplementation binarySearchImplementation = new BinarySearchImplementation();
	private static StockStatusCount stockStatusCount = new StockStatusCount();

	//Execution starting point from this main method
	public static void main(String[] args){
		//User would be asked to enter details like number of companies as integer, their current stock prices as double and their stock status as boolean
		//Try With Resource Block Where We Have Initialized Scanner Resource and created an object for dealing with Runtime Exceptions
		//We might Expect Exception Can Happen Due To Arithmetic Exceptions Or Array Index Out Of Bounds Exception
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("enter the no of companies");
			int numberOfCompanies = sc.nextInt();
			if(numberOfCompanies>0){
				stockPrices = new double[numberOfCompanies];
				stockStatus = new boolean[numberOfCompanies];
				//The User Values Will Be Captured In Arrays
				for(int i=0;i<numberOfCompanies;i++){
					System.out.println("Enter current stock price of the company " + (i+1));
					stockPrices[i] = sc.nextDouble();
					System.out.println("Whether company's stock price rose today compare to yesterday?");
					stockStatus[i] = sc.nextBoolean();
				}
				//This Logic Will Prompt User To Enter a set of functionalities available, if it selects 0, it will exit this application 
				while(flag){
					System.out.println("Enter the operation that you want to perform");
					System.out.println("1. Display the companies stock prices in ascending order");
					System.out.println("2. Display the companies stock prices in descending order");
					System.out.println("3. Display the total no of companies for which stock prices rose today");
					System.out.println("4. Display the total no of companies for which stock prices declined today");
					System.out.println("5. Search a specific stock price");
					System.out.println("6. press 0 to exit");
					//User will be prompt to select the functionality
					choice = sc.nextInt();
					switch(choice){
					case 1:
						//It will arrange Stock Prices In Ascending Order For User Using Merge Sort
						System.out.println("Stock prices in ascending order are :");
						mergeSortImplementation.sortInAscendingOrder(stockPrices,0,stockPrices.length-1);
						mergeSortImplementation.displayCompanyStockPrices(stockPrices);
						break;
					case 2:
						/*It will arrange Stock Prices In Descending Order For User Using Merge Sort, if array is sorted in ascending order once,
					in that case we can reverse this array and achieve descending order without using Merge Sort, but using Merge Sort here as 
					User can directly select option2 without selecting option1, in which case array may or may not be sorted in ascending order*/
						System.out.println("Stock prices in descending order are :");
						mergeSortImplementation.sortInDescendingOrder(stockPrices,0,stockPrices.length-1);
						/*As per problem requirement, display method is used in Merge Sort Service Class as we are using display to print sorted
					 Arrays and so have placed in that service class and have not created separate service class*/
						mergeSortImplementation.displayCompanyStockPrices(stockPrices);
						break;
					case 3:
						//It will show total companies whose stock status rise today compared to yesterday
						System.out.println("Total no of companies whose stock price rose today : " + stockStatusCount.countCompanyWithRisingStockStatus(stockStatus));
						break;
					case 4:
						//It will show total companies whose stock status declined today compared to yesterday
						System.out.println("Total no of companies whose stock price declined today : " + stockStatusCount.countCompanyWithDecliningStockStatus(stockStatus));
						break;
					case 5:
						//It will prompt user to search a specific stock prices value if exists, it will sort Stock Prices Array in ascending order and then perform Binary Search for key
						System.out.println("enter the key value");
						double key = sc.nextDouble();
						mergeSortImplementation.sortInAscendingOrder(stockPrices,0,stockPrices.length-1);
						binarySearchImplementation.performBinarySearch(stockPrices,0,stockPrices.length-1,key);
						break;
						//If user selects 6 or 0, in either case, it will exit the application
					case 6:
					case 0:
						System.out.println("Exited successfully");
						flag = false;
						break;
					default:
						//default case added in case if user selects any incorrect choice
						System.out.println("Enter Integral Values Between 0 and 6");
						break;
					}
				}
			}
			//This is added just to make sure that user enters at least 1 company
			else{
				System.out.println("Enter number of companies greater than or equal to 1");
			}
		}
		catch(ArithmeticException | ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		//finally block to close scanner resource is not provided explicitly as Try with Resource is used and it will take care of closing resource
	}
}

