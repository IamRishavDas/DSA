package DSA.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    // implement Binary Search using recursive method
    public static int BinarySearchRecursive(int[] arr, long low, long high, long search) {
        if (low > high)
            return -1;
        else {
            long mid = (low + high) >> 1;
            if (arr[(int) mid] == search)
                return (int) mid;
            else if (arr[(int) mid] > search)
                return BinarySearchRecursive(arr, low, mid - 1, search);
            else
                return BinarySearchRecursive(arr, mid + 1, high, search);
        }
    }

    // implement BinarySearch using iterative method
    public static int BinarySearchIterative(int[] arr, long low, long high, long search) {
        while (low <= high) {
            long mid = (low + high) >> 1;
            if (arr[(int) mid] == search)
                return (int) mid;
            else if (arr[(int) mid] > search)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    // Lower Bound: smallest index such that, (arr[index] >= x)

    // find lower bound in an array using iterative method (O(n))
    public static int getLowerBound(int[] arr, int x) {
        int n = arr.length;
        int lowerBound = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= x) {
                lowerBound = i;
                break;
            }
        }
        return lowerBound;
    }

    // implementing the Binary Search for solving the lowerBound problem recursive
    // way
    public static int BSlowerBoundRecursive(int[] arr, int low, int high, int lowerBound, int x) {
        if (low > high)
            return lowerBound;
        int mid = (low + high) >> 1;
        if (arr[mid] >= x) {
            lowerBound = mid;
            return BSlowerBoundRecursive(arr, low, mid - 1, lowerBound, x);
        } else {
            return BSlowerBoundRecursive(arr, mid + 1, high, lowerBound, x);
        }
    }

    // implementing the Binary Search for solving the lowerBound problem iterative
    // way
    public static int BSlowerBoundIterative(int[] arr, int low, int high, int x) {
        int n = arr.length;
        int lowerBound = n;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] >= x) {
                lowerBound = mid;
                high = mid - 1; // search for more smaller index at left
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }

    // Upper Bound: smallest index such that, (arr[index] > x)

    // find the upperBound in an array using Iterative Method
    public static int getUpperBound(int[] arr, int x) {
        int n = arr.length;
        int upperBound = n;
        if (x < arr[0])
            return 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                upperBound = i;
                break;
            }
        }
        return upperBound;
    }

    // implementing Binary Search recursive for getting the UpperBound
    public static int BSupperBoundRecursive(int[] arr, int low, int high, int upperBound, int x) {
        if (low > high)
            return upperBound;
        if (x < arr[0])
            return 0;
        int mid = (low + high) >> 1;
        if (arr[mid] > x) {
            upperBound = mid;
            return BSupperBoundRecursive(arr, low, mid - 1, upperBound, x);
        } else {
            return BSupperBoundRecursive(arr, mid + 1, high, upperBound, x);
        }
    }

    // implementing Binary Search iterative for getting the UpperBound
    public static int BSupperBoundIterative(int[] arr, int low, int high, int x) {
        int upperBound = arr.length;
        if (x < arr[0])
            return 0;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] > x) {
                upperBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return upperBound;
    }

    // find the upper bound using Binary Search (O(logn))
    public static int getUpperBound(int[] arr, int n, int x) {
        // return BSupperBoundIterative(arr, 0, arr.length - 1, x);
        int upperBound = arr.length;
        return BSupperBoundRecursive(arr, 0, arr.length - 1, upperBound, x);
    }

    // implementing lower bound using BinarySearch
    public static int getLowerBound(int[] arr, int n, int x) {
        n = arr.length;
        // int lowerBound = n;
        // return BSlowerBoundRecursive(arr, 0, n-1, lowerBound, x);
        return BSlowerBoundIterative(arr, 0, n - 1, x);
    }

    // Ceil value: smallest element such that, (arr[index] >= x)

    // find the ceil value
    public static int ceilinArray(int[] arr, int x) {
        // may return -1 if such value not found in the array
        return arr[getLowerBound(arr, arr.length, x)];
    }

    // Floor value: largest element such that, (arr[index] <= x)

    // find the floor value
    public static int floorinArray(int[] arr, int x) {
        int n = arr.length;
        int ans = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] <= x) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // find the first and last occurance of an element inside an array
    public static int[] searchRange(int[] arr, int target) { // linear search
        int firstOccurance, lastOccurance;
        firstOccurance = lastOccurance = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (firstOccurance == -1)
                    firstOccurance = i;
                lastOccurance = i;
            }
        }
        return new int[] { firstOccurance, lastOccurance };
    }

    // using the lowerBound and upperBound method
    public static int[] searchRange(int[] arr, int target, int n) {
        int lowerBound = Main.getLowerBound(arr, target);
        int upperBound = Main.getUpperBound(arr, target);

        if (lowerBound == n || arr[lowerBound] != target)
            return new int[] { -1, -1 };
        return new int[] { lowerBound, upperBound - 1 };
    }

    // using binary search
    public static int findFirstIndexUsingBS(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int first = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return first;
    }

    public static int findSecondIndexUsingBS(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int last = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return last;
    }

    // search the range
    public static int[] searchBound(int[] arr, int x) {
        return new int[] { findFirstIndexUsingBS(arr, x), findSecondIndexUsingBS(arr, x) };
    }

    // find the number of occurance of an element in an array
    public static int countOccurance(int[] arr, int x) {
        if (findFirstIndexUsingBS(arr, x) < 0)
            return 0;
        else
            return findFirstIndexUsingBS(arr, x) - findFirstIndexUsingBS(arr, x) + 1;
    }

    // search in rotated sorted array (the elements present in the array is unique)
    public static int searchInRotatedSortedArray(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[low] > arr[mid]) { // if true: right side is sorted
                if (x <= arr[high] && x >= arr[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {// left side is sorted
                if (x <= arr[mid] && x >= arr[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    // search in rotated sorted array where the elements present in the array may or
    // may not unique
    public static boolean searchInRotatedSortedArrayII(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return true;
            else if (arr[low] == arr[mid] && arr[mid] == arr[high]) { // when the sorted half is not figured out
                low++;
                high--;
                continue;
            } else if (arr[low] > arr[mid]) { // if true: right side is sorted
                if (x <= arr[high] && x >= arr[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {// left side is sorted
                if (x <= arr[mid] && x >= arr[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return false;
    }

    // find the minimum element is rotated sorted array
    public static int findMinInRotatedSortedArray(int[] arr) {
        int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if the both left and right half is sorted (i.e. the mid is on the rotating
            // point and one sorted half is eleminated)
            if (arr[low] <= arr[mid] && arr[mid] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
            }
            if (arr[mid] >= arr[low]) { // left half is sorted
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    // find how many times the array has been rotated
    public static int findHowManyRotationHasDone(int[] arr) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[high]) {// if at any point the low high is point at a boundary of an sorted array
                if (arr[low] < min) {
                    min = arr[low];
                    minIndex = low;
                }
                break;
            } else if (arr[low] <= arr[mid]) {// left side is sorted
                low = mid + 1;
                if (arr[low] < min) {
                    min = arr[low];
                    minIndex = low;
                }
            } else { // right side is sorted
                high = mid - 1;
                if (arr[mid] < min) {
                    min = arr[mid];
                    minIndex = mid;
                }
            }
        }
        return minIndex;
    }

    // find the single element in a sorted array
    public static int getSingleNonDuplicate(int[] arr) {
        int n = arr.length;
        // handeled all the edge cases
        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
                return arr[mid];
            // (if the mid is at odd index and pair left is even ) (if the mid is at even
            // index and the right pair is odd)
            if (((mid % 2 == 1) && arr[mid] == arr[mid - 1]) || ((mid % 2 == 0) && arr[mid] == arr[mid + 1]))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1; // just for dummy purpose
    }

    // find the peak element in an rotated sorted array
    public static int[] findPeak(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return new int[] { 0, arr[0] };
        if (arr[0] > arr[1])
            return new int[] { 0, arr[0] };
        if (arr[n - 1] > arr[n - 2])
            return new int[] { n - 1, arr[n - 1] };

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return new int[] { mid, arr[mid] };
            else if (arr[mid] > arr[mid - 1])
                low = mid + 1;
            else if (arr[mid] > arr[mid + 1])
                high = mid - 1;
            else
                low = mid + 1; // condition if the mid lies on a reverse peak position
        }
        return new int[] { -1, -1 };
    }

    // find the sqrt of a number using binary search
    public static int floorFindSqrt(int n) {
        int ans = 1;
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid <= n) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // find the nth root of a number using the binary search
    public static int findNthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            double p = Math.pow(mid, n);
            if (p == m)
                return mid;
            else if (p > m)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    // koko eating bananas
    public static int minEatingSpeed(int[] piles, int h) {
        int max = arrayMax(piles);
        for (int i = 1; i < max; i++) {
            int rqTime = timeRq(piles, i);
            if (rqTime <= h)
                return i;
        }
        return -1;
    }

    public static int arrayMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i : piles) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static int timeRq(int[] piles, int i) {
        int time = 0;
        for (int pile : piles) {
            time += Math.ceil((double) pile / (double) i);
        }
        return time;
    }

    public static int[] range(int[] weights) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i : weights) {
            max = Math.max(max, i);
            sum += i;
        }
        return new int[] { max, sum };
    }

    public static boolean possibleShipping(int[] weights, int days, int capacity) {
        int load = 0, dayCount = 1;
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] <= capacity) {
                load += weights[i];
            } else {
                dayCount++;
                load = 0;
                i--;
            }
        }
        return dayCount <= days;
    }

    public static int shipWithInDays(int[] weights, int days) {
        int[] range = range(weights);
        int low = range[0], high = range[1], ans = range[1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possibleShipping(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Given an
    // array arr
    // of positive
    // integers sorted
    // in a
    // strictly increasing order,
    // and an
    // integer k.

    // Return the
    // kth positive
    // integer that
    // is missing from this array.

    public static int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k) low = mid +1;
            else high = mid-1;
        }
        return high + 1 + k;
    }

    public static int[] max_min(int[] arr){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i: arr){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return new int[] {min, max};
    }
    // aggressive cows problem - place the cows in such way the min distance between cows is the max
    public static int aggressiveCows(int[] stalls, int cows){
        Arrays.sort(stalls);
        var range = max_min(stalls);

        // using linear search
        // for(int i=1; i<=(range[1] - range[0]); i++){
        //     if(weCanPlace(stalls, cows, i)) continue;
        //     else return i-1;
        // }
        // return -1;

        // using binary search
        int low = 1, high = range[1] - range[0], ans = low;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(weCanPlace(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }

    public static boolean weCanPlace(int[] stalls, int cows, int minDist){
        int lastCow = stalls[0], countCows = 1;
        for(int i=1; i<stalls.length; i++){
            if((stalls[i] - lastCow) >= minDist){
                countCows++;
                lastCow = stalls[i];
            }
        }
        return countCows >= cows;
    }

    // place k individual new gas stations such that the max distance is minimized
    public static double minimizeMaxGasStationDistance(int[] arr, int k){
        int n = arr.length;
        int[] howMany = new int[n-1];
        for(int i=0; i<n-1; i++) howMany[i] = 0;

        for(int gasStation=1; gasStation<=k; gasStation++){
            double maxSection = -1;
            int maxIndex = -1;

            for(int i=0; i<n-1; i++){
                double diff = arr[i+1] - arr[i];
                double sectionLength = diff/(double)(howMany[i] + 1);
                if(sectionLength > maxSection){
                    maxSection = sectionLength;
                    maxIndex = i;
                }
            }
            howMany[maxIndex]++;
        }

        double maxAns = 1;
        for(int i=0; i<n-1; i++){
            double diff = arr[i+1] - arr[i];
            double sectionLength = diff/(double)(howMany[i]+1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }
    
    // place k individual new gas stations such that the max distance is minimized using max heap data structure

    static class Pair{
        double first; 
        int second;
        public Pair(double first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static double minimizeMaxGasStationDistanceBetterSolution(int[] arr, int k){
        int n = arr.length;
        int[] howMany = new int[n-1];
        for(int i=0; i<n-1; i++) howMany[i] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        // inserting n-1 elements in pq with the distance values
        for(int i=0; i<n-1; i++){
            pq.add(new Pair(arr[i+1]-arr[i], i));
        }

        for(int gasStation=1; gasStation<=k; gasStation++){
            // finding the max section and inserting into the new gas station
            Pair tp = pq.poll();
            int secIndex = tp.second;

            // insert the current gas station
            howMany[secIndex]++;

            double initDiff = arr[secIndex + 1] - arr[secIndex];
            double newSectionLength = initDiff/(double)(howMany[secIndex] + 1);
            pq.add(new Pair(newSectionLength, secIndex));
        }

        double maxAns = -1;
        for(int i=0; i<n-1; i++){
            double diff = arr[i+1] - arr[i];
            double sectionLength = diff/(double)(howMany[i]+1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return pq.peek().first;
    }

    // two pointer approach without using extra space
    // find median of two sorted arrays
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;

        int index1 = (int)(n/2)-1, index2 = (int)(n/2), elem1 = -1, elem2 = -1;
        int p1 = 0, p2 = 0, count = 0;
        while(p1 < n1 && p2 < n2){
            if(nums1[p1] <= nums2[p2]){
                if(index1 == count) elem1 = nums1[p1];
                if(index2 == count) elem2 = nums1[p1];
                count++;
                p1++;
            } else {
                if(index1 == count) elem1 = nums2[p2];
                if(index2 == count) elem2 = nums2[p2];
                count++;
                p2++;
            }
        }

        while(p1 < n1){
            if(index1 == count) elem1 = nums1[p1];
            if(index2 == count) elem2 = nums1[p1];
            count++;
            p1++;
        }

        while(p2 < n2){
            if(index1 == count) elem1 = nums2[p2];
            if(index2 == count) elem2 = nums2[p2];
            count++;
            p2++;
        }

        if(n % 2 == 0) {
            return (double)((double)(elem1 + elem2)/(double)2);
        } else {
            return (double)elem2;
        }
    }

    // find the row with max no of 1s from the matrix with zero and one in sorted order in every row

    // brute force solution
    public static int[] findRowAndMaxOnes(int[][] mat){
        int noOfOnes = -1;
        int rowWithMaxOne = -1;
        for(int i=0; i<mat.length; i++){
            int count = 0;
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j] ==  1) count++;
            }
            if(noOfOnes < count){
                noOfOnes = count;
                rowWithMaxOne = i;
            }
        }
        return new int[] {rowWithMaxOne, noOfOnes};
    }

    // binary search approach
    public static int countOneInRow(int[] arr){
        int low = 0, high = arr.length - 1;
        if(arr[high] == 0) return 0;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(arr[mid] == 1){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return arr.length-low;
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int rowWithMinOne = -1, noOfOne = -1;
        for(int i=0; i<mat.length; i++){
            Arrays.sort(mat[i]);
            int count = countOneInRow(mat[i]);
            if(noOfOne < count){
                rowWithMinOne = i;
                noOfOne = count;
            }
        }
        return new int[] {rowWithMinOne, noOfOne};
    }

    // binary search in 2D array using log(m*n) time [converting 1D coordinate to 2d coordinate]
    public static boolean search2DMatrix(ArrayList<ArrayList<Integer>> mat, int target){
        int m = mat.size(), n = mat.get(0).size();
        int low = 0, high = (m * n) -1;
        while(low <= high){
            int mid = (low + high) >> 1; // low + (high - low)/2;
            int i = mid/m, j = mid%m;
            if(mat.get(i).get(j) == target) return true;
            else if(mat.get(i).get(j) > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    // binary search in the 2D array where the matrix is sorted in row wise and as well as column wise (not entirely sorted)
    public static boolean search2DMatrix_II(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n-1;

        while(row < m && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }



    public static void main(String[] args) {
        // implement Binary Search
        // int[] arr = {1,3,5,6,6};
        // System.out.println("Binary Search Iterative: " + BinarySearchIterative(arr,
        // 0, arr.length-1, 5));
        // System.out.println("Binary Search Recursive: " + BinarySearchRecursive(arr,
        // 0, arr.length-1, 5));

        // find lowerbound in an array
        // int[] arr = {1, 2, 3, 3, 7, 8, 9, 9, 9, 11};
        // int x = 1;
        // System.out.println(getLowerBound(arr, arr.length, x));

        // find the upper bound in an array
        // int[] arr = {2, 3, 6, 7, 8, 8, 11, 11, 11, 12};
        // int x = 11;
        // System.out.println(getUpperBound(arr, x));
        // System.out.println(getUpperBound(arr, arr.length-1, x));

        // find the ceil and floor value in an sorted array
        // int[] arr = {10, 20, 30, 40, 50};
        // System.out.println("Ceil: " + ceilinArray(arr, 25));
        // System.out.println("Floor: " + floorinArray(arr, 25));

        // int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        // System.out.println("The search in rotated sorted array is: " +
        // searchInRotatedSortedArray(arr, 1));

        // int[] arr = {1,5,1,2,1};
        // System.out.println("The index of the peak element is: " + findPeak(arr)[0] +
        // " value: " + findPeak(arr)[1]);

        // System.out.println("the nth root is: " + findNthRoot(3, 27));
        // System.out.println(minEatingSpeed(new int[] {3, 6, 7, 11}, 8));

        // capacity to ship packages withing D days
        // System.out.println(possibleShipping(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5, 15));

        // System.out.println(aggressiveCows(new int[] {0, 9, 7, 3, 4, 10}, 4));

        // System.out.println(minimizeMaxGasStationDistanceBetterSolution(new int[] {1, 13, 17, 23}, 5));

        // System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));

        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // list.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        // list.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
        // list.add(new ArrayList<>(Arrays.asList(9,10,11,12)));
        // System.out.println(search2DMatrix(list,100));
    }
}
