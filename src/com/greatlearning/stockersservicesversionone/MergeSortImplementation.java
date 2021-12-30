package com.greatlearning.stockersservicesversionone;

import com.greatlearning.stockersdriverversionone.StockersDriver;
public class MergeSortImplementation {
	StockersDriver stockersDriver = new StockersDriver();
	/*This method is belonging to service package and helps to sort an array using Merge Sort With Worst Case Time Complexity Of O(nlogn),
	 * and in this case in any specified order using choice flag,
    This Uses Divide & Conquer Approach Of Merge Sort */
	public void performMergeSort(double[] stockPrices, int left, int mid, int right) {
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temporary arrays */
		double leftArray[] = new double[n1];
		double rightArray[] = new double[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = stockPrices[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = stockPrices[mid + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		/*As per problem statement, only for choice==2, we perform merge sort in descending order, so handling both ascending or descending 
		order sorting using same Merge Sort Method, to avoid duplicacy of Code, for that we use Class Instance to access its 
		static method getChoice()*/
		//Performing for Ascending Order Using Flag Value
		if(StockersDriver.getChoice()!=2) {
			while (i < n1 && j < n2) {
				if (leftArray[i] <= rightArray[j]) {
					stockPrices[k] = leftArray[i];
					i++;
				} else {
					stockPrices[k] = rightArray[j];
					j++;
				}
				k++;
			}
		}
		//Performing For Descending Order Using Same Flag Value
		else {
			while (i < n1 && j < n2) {
				if (leftArray[i] >= rightArray[j]) {
					stockPrices[k] = leftArray[i];
					i++;
				} else {
					stockPrices[k] = rightArray[j];
					j++;
				}
				k++;
			}
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			stockPrices[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			stockPrices[k] = rightArray[j];
			j++;
			k++;
		}
	}


	/* Main function that sorts array[left...right] using merge() in Specified Order, Merge Sort is Divide & Conquer Algorithm, so irrespective
	 * of Ascending or Descending Order, This Divide Approach of Algorithm will first make sure that every single element is segregated in
	 * array in sorted order, and only after this method below, merge & conquer process will take place, so performMergeSort() method is caled */
	public void performSorting(double[] stockPrices, int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			performSorting(stockPrices, left, mid);
			performSorting(stockPrices, mid + 1, right);

			// Merge the sorted halves based on ascending order
			performMergeSort(stockPrices, left, mid, right);
		}
	}

	//Basic method to display the array elements
	public void displayCompanyStockPrices(double[] stockPrices){
		for(int i=0;i<stockPrices.length;i++){
			System.out.print(stockPrices[i] + " ");
		}
		System.out.println();
	}


	/*AS WE CAN SEE BELOW COMMENTED CODE, WHICH IS FOR MERGE SORT IN DESCENDING ORDER,so to avoid this much almost redundant code, we controlled
	using Flag value and incorporated Merge Sort in Ascending Order or Descending Order With Same Single Code Snippet as our PROBLEM STATEMENT
	requires only one case mandatorily for Descending Order*/

	//In case if we want to keep Merge Sort Methods as separate, we can very well use below code snippet and can classify these on sorting order

	/*This method is belonging to service package and helps to sort an array, and in this case in descending order,
    This Uses Divide & Conquer Approach Of Merge Sort */

	/*	public void mergeForDescendingOrder(double[] stockPrices, int left, int mid, int right) {
			// Find sizes of two sub arrays to be merged
			int n1 = mid - left + 1;
			int n2 = right - mid;

			// Create temporary arrays
			double leftArray[] = new double[n1];
			double rightArray[] = new double[n2];

			// Copy data to temporary arrays
			for (int i = 0; i < n1; ++i)
				leftArray[i] = stockPrices[left + i];
			for (int j = 0; j < n2; ++j)
				rightArray[j] = stockPrices[mid + 1 + j];

			// Merge the temporary arrays

			// Initial indexes of first and second sub-arrays
			int i = 0, j = 0;

			// Initial index of merged sub-array array
			int k = left;
			while (i < n1 && j < n2) {
				if (leftArray[i] >= rightArray[j]) {
					stockPrices[k] = leftArray[i];
					i++;
				} else {
					stockPrices[k] = rightArray[j];
					j++;
				}
				k++;
			}

			// Copy remaining elements of L[] if any
			while (i < n1) {
				stockPrices[k] = leftArray[i];
				i++;
				k++;
			}

			// Copy remaining elements of R[] if any
			while (j < n2) {
				stockPrices[k] = rightArray[j];
				j++;
				k++;
			}
		}

//	 Main function that sorts array[left...right] using merge() in Descending Order
		public void sortInDescendingOrder(double[] stockPrices, int left, int right) {
			if (left < right) {
				// Find the middle point
				int mid = (left + right) / 2;

				// Sort first and second halves
				sortInDescendingOrder(stockPrices, left, mid);
				sortInDescendingOrder(stockPrices, mid + 1, right);

				// Merge the sorted halves based on descending order
				mergeForDescendingOrder(stockPrices, left, mid, right);
			}
		}
	 */

}

