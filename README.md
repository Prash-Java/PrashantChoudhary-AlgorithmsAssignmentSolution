# PrashantChoudhary-AlgorithmsAssignmentSolution
This Problem statement consists of two solutions as per the two questions in problem assignment, the first one is MasterTheorem Assignment whose answer and solution is attached 
in word document, 
The second part is programming assignment which uses driver and services packages, driver controls the logic and services part contains Merge Sort implementation and another class
contains Binary Sort implementation. The third class contains method to countcount true/false values in boolean array representing stock status,
Display Array method is included in Merge Sort Implementation Class as it is just needed to print array in ascending or descending oder,
Divide approach will be same in either ascending or descending order Merge Sort, even actual Merge Sort algorithm is almost same in both case except(< or >) operator, when we 
compare to find smaller or larger element, so use of FLAG is seen to control this, so that using if-else clause ascending order or descending order sort can be performed and as per
our Problem statement, only case 2 requires descending order, case 1 requires ascending order sort, case 5 again ascending order sort is used as the array needs to be sorted after
which Binary Seach can be performed efficienlt.
So only case 2 FLAG will use if clause in Merge Sort Algorithm, and so i have tried to acheive this using FLAG, although we can always have dedicated methods for Ascending or 
Descending Order Merge Sort, which also I have used in Lab solution
Time Complexity was required to be O(nlogn) as per problem statement, so Merge Sort is used as even its worst case scenario Time Complexity comes out to be O(nlogn) and 
Binary Search it is O(logn), as both these sort and search algorithm are DIVIDE & CONQUER Based, so did not used quick sort as its worst case goes to O(n^2)
Thank You
