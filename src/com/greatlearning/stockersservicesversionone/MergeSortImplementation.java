package com.greatlearning.stockersservicesversionone;

public class MergeSortImplementation {
    /*This method is belonging to service package and helps to sort an array, and in this case in descending order,
    This Uses Divide & Conquer Approach Of Merge Sort */
    public void mergeForDescendingOrder(double[] stockPrices, int left, int mid, int right) {
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

    /*This method is belonging to service package and helps to sort an array, and in this case in ascending order,
    This Uses Divide & Conquer Approach Of Merge Sort */
    public void mergeForAscendingOrder(double[] stockPrices, int left, int mid, int right) {
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

    // Main function that sorts array[left...right] using merge() in Descending Order
    public void sortInDescendingOrder(double[] stockPrices, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort first and second halves
            sortInDescendingOrder(stockPrices, left, mid);
            sortInDescendingOrder(stockPrices, mid + 1, right);

            // Merge the sorted halves based on ascending or descending order
            mergeForDescendingOrder(stockPrices, left, mid, right);
        }
    }

    // Main function that sorts array[left...right] using merge() in Ascending Order
    public void sortInAscendingOrder(double[] stockPrices, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort first and second halves
            sortInAscendingOrder(stockPrices, left, mid);
            sortInAscendingOrder(stockPrices, mid + 1, right);

            // Merge the sorted halves based on ascending or descending order
            mergeForAscendingOrder(stockPrices, left, mid, right);
        }
    }

    //Basic method to display the array
    public void displayCompanyStockPrices(double[] stockPrices){
        for(int i=0;i<stockPrices.length;i++){
            System.out.print(stockPrices[i] + " ");
        }
        System.out.println();
    }
}

