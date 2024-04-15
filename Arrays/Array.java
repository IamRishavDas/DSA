package DSA.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Collections;

public class Array {

    // finding the maximum value
    public static int max(int[] arr) {
        if (arr.length == 0)
            return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    // finding the second max
    public static int secMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sec_max = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i > max) {
                sec_max = max;
                max = i;
            } else if (i < max && i > sec_max) {
                sec_max = i;
            }
        }

        return sec_max;
    }

    // print array in the format of (max, max, sec max, sec max, ....)
    public static void print(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            System.out.print(arr[j] + " ");
            j--;
            System.out.print(arr[i] + " ");
            i++;
            if (j == i) {
                System.out.print(arr[i]);
            }
        }
    }

    // check if sorted
    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    // remove Duplicates
    public static int removeDuplicates(int[] arr) {
        int i = 0;
        int n = arr.length;
        for (int j = i + 1; j < n; j++) {
            if (arr[i] != arr[j] && i < n - 1) {
                arr[i + 1] = arr[j];
                i = i + 1;
            }
        }
        return i + 1;
    }

    // left leftRotate the array by one place
    public static void leftRotateByOne(int[] arr) {
        int temp = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }

    // reverse an array using while loop
    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // left Rotate an array by d places using array reversal technique
    public static void leftRotate(int[] arr, int d) {
        d = d % arr.length;
        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    // right leftRotate an array by d places optimal solution
    public static void rightRotate(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        reverse(arr, 0, n - d - 1);
        reverse(arr, n - d, n - 1);
        reverse(arr, 0, n - 1);
    }

    // find the majority element in the array using hashmap in java
    public static int majority(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int max = Collections.max(map.values());
        int key = 0;
        for (var i : map.entrySet()) {
            if (max == i.getValue()) {
                key = i.getKey();
            }
        }
        return key;
    }

    // move all zeros to the end of an array brute force solution
    public static void moveAllZerosEnd(int[] arr) {
        var list = new ArrayList<Integer>();
        int count = 0;
        for (int i : arr) {
            if (i != 0)
                list.add(i);
            else
                count++;
        }
        for (int i = 0, j = 0; i < arr.length && j < list.size(); i++, j++) {
            arr[i] = list.get(i);
        }

        for (int i = arr.length - 1; i >= arr.length - count; i--) {
            arr[i] = 0;
        }
    }

    // move all zerso to the end optimal solution
    public static void moveAllZerosEnd(int[] arr, int n) {
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    // linear search
    public static int linearSearch(int[] arr, int search) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                return i;
            }
        }
        return -1;
    }

    // find the union of two arrays using hashset
    public static int[] union(int[] arr1, int[] arr2) {
        var set = new HashSet<Integer>();
        for (int i = 0; i < arr1.length; i++)
            set.add(arr1[i]);
        for (int i = 0; i < arr2.length; i++)
            set.add(arr2[i]);
        Iterator<Integer> it = set.iterator();
        int i = 0;
        var arr = new int[set.size()];
        while (it.hasNext()) {
            arr[i++] = it.next();
        }
        return arr;
    }

    // union of two sorted arrays optimal
    public static ArrayList<Integer> union(int[] arr1, int[] arr2, int n) {
        var list = new ArrayList<Integer>();

        int n1 = arr1.length;
        int n2 = arr2.length;

        int i, j;
        i = j = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (list.size() == 0 || list.getLast() != arr1[i]) {
                    list.add(arr1[i]);
                }
                i++;
            } else {
                if (list.size() == 0 || list.getLast() != arr2[j]) {
                    list.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (list.size() == 0 || list.getLast() != arr1[i]) {
                list.add(arr1[i]);
            }
            i++;
        }

        while (j < n2) {
            if (list.size() == 0 || list.getLast() != arr2[j]) {
                list.add(arr2[j]);
            }
            j++;
        }

        return list;
    }

    // intersection of two arrays
    public static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
        var list = new ArrayList<Integer>();

        var visited = new int[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j] && visited[j] != 1) {
                    list.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }
                if (arr2[j] > arr1[i])
                    break; // if it exceds the length then break the loop and go for new index
            }
        }

        return list;
    }

    // intersection of two sorted arrays optimal way
    // time complexity - o(max (arr1.length, arr2.length))
    public static ArrayList<Integer> intersection(int[] arr1, int[] arr2, int a) {
        var list = new ArrayList<Integer>();
        int j = 0, i = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr1[i] > arr2[j])
                j++;
            else if (arr1[i] == arr2[j]) {
                list.add(arr1[i]);
                i++;
                j++;
            }
        }

        return list;
    }

    // finding a missing number brute
    public static int missing(int[] arr, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return arr.length + 1;
    }

    // finding a missing number optimal
    public static int missing(int[] arr, int n, String c) {

        return switch (c) {
            case "series" -> {
                int actualSum = 0;
                int sum = (n * (n + 1)) / 2;
                for (int i : arr) {
                    actualSum += i;
                }
                int res = sum - actualSum;
                yield res;
            }

            case "xor" -> {
                int xor1 = 0;
                int xor2 = 0;
                for (int i : arr)
                    xor1 ^= i;
                for (int i = 1; i <= n; i++)
                    xor2 ^= i;
                yield xor1 ^ xor2;
            }

            default -> {
                yield -1;
            }
        };

    }

    // maximum consiqutives ones
    public static int maxConsiquitiveOnes(int[] arr) {
        int max = 0;
        int count = 0;
        for (int i : arr) {
            if (i == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    // find the number that appers once (where the other numbers are appers twice)
    public static int appersOnce(int[] arr) {
        int ans = 0;
        for (int i : arr)
            ans ^= i;
        return ans;
    }

    // longest possible subarray with given sum (time - O(n^2))
    public static void longestSubArrayWithGivenSum(int[] arr, int k) {
        int n = arr.length;
        int len = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    len = Math.max(j - i + 1, len);
                }
            }
        }
        System.out.println("The max lenght of the subarry is: " + len);
    }

    // longest possible subarray usning hashing ( but it is correct for only
    // positive numbers and negative numbers except zero )
    public static int longestSubArrayWithGivenSum(int[] arr, int k, String hasing) {
        var map = new HashMap<Integer, Integer>();
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - k;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return maxLen;
    }

    // longest possible subarray optimal if the array is only containing only
    // positive numbers (using greedy and two poiuntter approach)
    public static int longestSubArrayWithGivenSum(int k, int[] arr) {
        int n = arr.length;
        int i = 0, j = 0;
        int sum = arr[0];
        int maxLen = 0;
        while (j < n) {
            while (sum > k && i <= j) {
                sum -= arr[i];
                i++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            j++;
            if (j < n) {
                sum += arr[j];
            }
        }
        return maxLen;
    }

    // two sum problem
    public static int[] sum2(int[] arr, int target) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        var res = new int[2];
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else if (sum == target) {
                res[0] = arr[i];
                res[1] = arr[j];
                break;
            }
        }
        return res;
    }

    // sort an array of 0, 1 and 2s (dutch national flag algorithm)
    public static void sortAnArrayOfzerosonesandtwos(int[] arr) {
        int low, mid, high;
        int n = arr.length;
        low = mid = 0;
        high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    // find out the majority element inside an array (moores voting algorithm)
    public static int majority(int[] arr, int n) {
        int element = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = arr[i];
            } else if (arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i : arr) {
            if (i == element) {
                count++;
            }
        }
        if (count > n / 2) {
            return element;
        }
        return -1;
    }

    // max profit can be gained to maximize the profit while selling the stock after
    // buying it in previous
    public static int profitToBuyAndSellStock(int[] arr) {
        int maxProfit = 0;
        int n = arr.length;
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            int profit = arr[i] - min;
            maxProfit = Math.max(maxProfit, profit);
            min = Math.min(arr[i], min);
        }
        return maxProfit;
    }

    // max subarray sum (kadane's algorithm)
    public static int maxSubArray(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            sum += i;
            max = Math.max(max, sum);
            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    // rearrange the array elements by their sign where the the number of positive
    // elements is equals to then number of negavtive elements
    public static int[] rearrangeBySign(int[] arr) {
        int n = arr.length;
        var res = new int[n];
        int pos = 0;
        int neg = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                res[pos] = arr[i];
                pos += 2;
            } else {
                res[neg] = arr[i];
                neg += 2;
            }
        }
        return res;
    }

    // -2 1 4 -1 12 6
    // pos = 1 4 12 6
    // neg = -2 -1
    // 1 -2 4 -1 12 6
    // number of +ve is not necessarily equls to number of -ve s
    public static void rearrangeBySign(int[] arr, int n) {
        var pos = new ArrayList<Integer>();
        var neg = new ArrayList<Integer>();

        for (int i : arr) {
            if (i >= 0) {
                pos.add(i);
            } else {
                neg.add(i);
            }
        }

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int remIndex = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[remIndex++] = pos.get(i);
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int remIndex = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[remIndex++] = neg.get(i);
            }
        }
    }

    // swaping two elements in an array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // find out the next permutaion
    public static void nextPermutation(int[] arr) {
        int ind = -1;
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            reverse(arr, 0, n - 1);
            return;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (arr[ind] < arr[i]) {
                swap(arr, ind, i);
                break;
            }
        }
        reverse(arr, ind + 1, n - 1);
    }

    // leaders in an array
    public static List<Integer> leadersArray(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return Arrays.asList(arr[0]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean greater = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    greater = true;
                }
            }
            if (!greater) {
                list.add(arr[i]);
            }
        }

        return list;
    }

    // leaders in an array (optimal)
    public static List<Integer> leaders(int[] arr) {
        var list = new ArrayList<Integer>();
        int n = arr.length;

        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                list.add(arr[i]);
                max = Math.max(max, arr[i]);
            }
        }

        Collections.reverse(list);
        return list;
    }

    public static boolean ls(int[] arr, int target) {
        for (int i : arr) {
            if (i == target)
                return true;
        }
        return false;
    }

    // longest consiquitive sequence
    // (Time Complexity - O(n^2) using linear search)
    // (Time Complexity - O(n*logn) using binary search)
    public static int longestConsiquitiveSequence(int[] arr) {
        int longest = 1;
        int n = arr.length;
        if (n == 0)
            return n;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int count = 1;
            while (ls(arr, x + 1) == true) {
                x++;
                count++;
            }
            longest = Math.max(count, longest);
        }
        return longest;
    }

    // time complexity - > O(nlogn) + O(n)
    public static int longestConsiquitiveSequence(int[] arr, int n) {
        if (n == 0)
            return n;
        Arrays.sort(arr);
        int longest = 1;
        int currCount = 0;
        int lastSmaller = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] - 1 == lastSmaller) {
                currCount++;
                lastSmaller = arr[i];
            } else if (arr[i] != lastSmaller) {
                currCount = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest, currCount);
        }
        return longest;
    }

    // optimal solution is using set data structure
    public static int longestConsiquitiveSequence(int[] arr, String code) {
        int n = arr.length;
        if (n == 0)
            return n;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int longest = 1;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int count = 1;
                int x = i;
                while (set.contains(x + 1)) {
                    x++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    // set matrix to zeros
    // brute force solution
    public static void setMatrixToZeros(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    markRow(arr, i);
                    markCol(arr, j);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }

        // System.out.println(Arrays.deepToString(arr));

    }

    public static void markRow(int[][] arr, int row) {
        for (int j = 0; j < arr[row].length; j++) {
            if (arr[row][j] != 0)
                arr[row][j] = -1;
        }
    }

    public static void markCol(int[][] arr, int col) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col] != 0)
                arr[i][col] = -1;
        }
    }

    // rotate90 an image by 90 degree
    public static int[][] rotate90(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        var res = new int[col][row];
        int newCol = row;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[j][newCol - i - 1] = mat[i][j];
            }
        }
        // mat = null;
        return res;
    }

    // optimal solution for rotate an image by 90 degree
    public static void swap(int[][] mat, int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    public static void transpose(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i != j && i > j) {
                    swap(mat, i, j);
                }
            }
        }
    }

    public static void reverseEveryRow(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            reverse(mat[i], 0, mat[i].length - 1);
        }
    }

    public static void rotate90(int[][] mat, String s) {
        transpose(mat);
        reverseEveryRow(mat);
    }

    // print matrix in spiral order
    public static void printSpital(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int left = 0;
        int top = 0;
        int right = col - 1;
        int bottom = row - 1;

        var list = new ArrayList<Integer>();

        while (left <= right && top <= bottom) {
            // right
            for (int i = left; i <= right; i++) {
                list.add(mat[top][i]);
            }
            top++;
            // bottom
            for (int i = top; i <= bottom; i++) {
                list.add(mat[i][right]);
            }
            right--;
            // left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(mat[bottom][i]);
                }
                bottom--;
            }
            // top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(mat[i][left]);
                }
                left++;
            }
        }

        System.out.println(list);

    }

    // find the number of subarrays with the given sum k
    public static int subArrayWithSum(int[] arr, int k) {
        int count = 0;
        int prefixSum = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int remaining = prefixSum - k;
            count += map.getOrDefault(remaining, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    // calculating the nCr function
    public static int nCr(int n, int r) {
        int result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    // pascals triangle
    public static List<List<Integer>> pascalsTriangle(int rows) {
        List<Integer> list;
        List<List<Integer>> listOfList = new ArrayList<>();
        for (int row = 1; row <= rows; row++) {
            list = new ArrayList<>();
            for (int col = 1; col <= row; col++) {
                list.add(nCr(row - 1, col - 1));
            }
            listOfList.add(list);
        }
        return listOfList;
    }

    // majority elemenet appearing more than [n/3] three times (brute force
    // solution)
    public static List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>(2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() > (n / 3)) {
                res.add(i.getKey());
                if (res.size() == 2)
                    break;
            }
        }
        return res;
    }

    // majority elemenet appearing more than [n/3] three times (brute force
    // solution)
    public static List<Integer> majorityElementMorethanNdividedBy3(int[] arr) {
        int n = arr.length;

        if(n==1){
            return Arrays.asList(arr[0]);
        }

        int count1 = 0, count2 = 0;
        int elemenet1 = 1, elemenet2 = 1;

        List<Integer> list = new ArrayList<>(2);

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && elemenet2 != arr[i]) {
                count1 = 1;
                elemenet1 = arr[i];
            } else if (count2 == 0 && elemenet1 != arr[i]) {
                count2 = 1;
                elemenet2 = arr[i];
            }

            else if (arr[i] == elemenet1)
                count1++;

            else if (arr[i] == elemenet2)
                count2++;
            else {
                count1--;
                count2--;
            }
        }

        // checking if the elemenets has the count of greater than [n/3]
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == elemenet1) {
                count1++;
            }
            if (arr[i] == elemenet2) {
                count2++;
            }
        }

        if (count1 > n / 3)
            list.add(elemenet1);
        if (count2 > n / 3)
            list.add(elemenet2);

        return list;
    }

    // 3 sum problem finding the triplet sum = 0 (brute force solution)
    public static List<List<Integer>> threeSum(int[] arr){
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(arr[i] + arr[j] + arr[k] == 0){
                        List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(list);
                        if(!res.contains(list))
                            res.add(list);
                    }
                }
            }
        }
        return res;
    } 

    // 3 sum problem finding the triplet with sum = 0 (better solution)
    public static List<List<Integer>> threeSum(int[] arr, int n){
        var res = new ArrayList<List<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int required = -(arr[i] + arr[j]);
                if(map.containsKey(required) && map.get(required) != i && map.get(required) != j){
                    List<Integer> list = Arrays.asList(arr[i], arr[j], required);
                    Collections.sort(list);
                    if(!res.contains(list)) res.add(list);
                }
                map.put(arr[j], j);
            }
        }
        return res;
    }

    // three sum problem optimal solution using three pointer approach
    public static List<List<Integer>> threeSum(int[] arr, int n, String optimal){
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum < 0){
                    j++;
                } else if(sum > 0){
                    k--;
                } else if(sum == 0){
                    list.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while(j<k && arr[j] == arr[j-1]) j++;
                    while(j<k && arr[k] == arr[k+1]) k--;
                }
            }
        }
        return list;
    }

    // four sum problem: finding the unique quarts sum equals to target (Brute force solution)
    public static List<List<Integer>> fourSum(int[] arr, int target){
        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    for(int l=k+1; l<n; l++){
                        if(arr[i] + arr[j] + arr[k] + arr[l] == target){
                            var temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(temp);
                            if(!list.contains(temp)){
                                list.add(temp);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    // four sum problem: better solution (O(n^3))
    public static List<List<Integer>> fourSum(int[] arr, int target, int n){
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    int req = target - (arr[i] + arr[j] + arr[k]);
                    if(map.containsKey(req) && map.get(req) != i && map.get(req) != j && map.get(req) != k){
                        var temp = Arrays.asList(arr[i], arr[j], arr[k], req);
                        Collections.sort(temp);
                        if(!list.contains(temp)){
                            list.add(temp);
                        }
                    }
                    map.put(arr[k], k);
                }
            }
        }
        return list;
    }

    // four sum: optimal solution
    public static List<List<Integer>> fourSum(int[] arr, int target, String optimal){
        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            for(int j=(i+1); j<n; j++){
                if(j != (i+1) && arr[j] == arr[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l){
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum < target){
                        k++;
                    } else if(sum > target){
                        l--;
                    } else if(sum == target){
                        list.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                        while(k<l && arr[k] == arr[k-1]) k++;
                        while(k<l && arr[l] == arr[l+1]) l--;
                    }
                }
            }
        }
        return list;
    }

    // finding the number of subarrays with xor k (better)
    public static int subArrayWithXorK(int[] arr, int xor){
        int n = arr.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int result_xor = 0;
            for(int j=i; j<n; j++){
                result_xor ^= arr[j];
                if(result_xor == xor){
                    // print(arr, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    // finding the number of subarray with xor k (optimal)
    public static int subArrayWithXorK(int[] arr, int xor, String optimal){
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result_xor = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            result_xor ^= arr[i];
            count += map.getOrDefault((result_xor ^ xor), 0);
            map.put(result_xor, map.getOrDefault(result_xor, 0)+1);
        } 
        return count;
    }

    // merge overlapping sequence (brute force solution) time -> O(nlogn) + O(2n)
    public static int[][] mergeOverlappingSubIntervals(int[][] intervals){
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i=0; i<n; i++){
            int start = intervals[i][0];
            int end   = intervals[i][1];
            if(!ans.isEmpty() && end <= ans.getLast()[1]){
                continue;
            }

            for(int j=i+1; j<n; j++){
                if(intervals[j][0] <= end){
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            ans.add(new int[]{start, end});
        }
        return ans.toArray(new int[ans.size()][]);
    }

    // merge overlapping subintervals (optimal approach)
    public static int[][] mergeOverlappingSubIntervals(int[][] intervals, int n){
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        n = intervals.length;
        List<int[]> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(list.isEmpty() || intervals[i][0] > list.getLast()[1]){
                list.add(intervals[i]);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }


    // merge two sorted array
    public static void merge(int[] arr1, int m, int[] arr2, int n){
        for(int i=m; i<(m+n); i++) arr1[i] = arr2[i-m];
        Arrays.sort(arr1);
    }


    // merge two sorted array with using extra temp space 
    public static void merge(int[] arr1, int m, int[] arr2){
        int i = 0; 
        int j = 0; 
        int k = 0;
        var temp = new int[arr1.length + arr2.length];
        while(i< arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]) temp[k++] = arr1[i++];
            else temp[k++] = arr2[j++];
        } 

        while(i<arr1.length){
            temp[k++] = arr1[i++];
        }

        while(j<arr2.length){
            temp[k++] = arr2[j++];
        }

        for(int index = 0; index<temp.length; index++){
            arr1[index] = temp[index];
        }
        return;
    }

    // mergee two sorted array optimal approach
    public static void merge(int[] arr1, int[] arr2, String optimal_1){
        if(arr2.length == 0) return;
        int i = arr1.length - 1;
        int j = 0;
        
        while(i>=0 && j<arr2.length){
            if(arr1[i] > arr2[j]){
                swap(arr1, arr2, i, j);
                i--;
                j++;
            } else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.copyOf(arr1, arr1.length + arr2.length);
        for(int index=arr2.length; index<arr1.length; index++){
            arr1[index] = arr2[index - arr2.length];
        }
    }

    private static void swap(int[] arr1, int[] arr2, int i, int j){
        int temp = arr1[i];
        arr1[i]  = arr2[j];
        arr2[j]  = temp;
    }


    // print an array form start to end index as given
    public static void print(int[] arr, int start, int end){
        for(int i=start; i<=end; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }

    // print a matrix
    public static void print(int[][] mat, int n) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // print the array
    public static void print(int[] arr, int n) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // converting a lower case string to the capital case string without usning any
    // inbuild function

    // A - Z = 65 - 90
    // a - z = 97 - 122
    // space = 32
    // 0 - 9 = 48 - 57

    // 97 - 65 = 32
    // 98 - 66 = 32

    public static String toCapital(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr >= 'a' && curr <= 'z') {
                sb.setCharAt(i, (char) (curr - ' '));
            }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        // System.out.println(isSorted(new int[] { 1,2,23,45,9}));
        // int ans = secMax(new int[] { 4,1,2,0,3,6,-1});
        // System.out.println(ans);

        // int[] arr = {1,1,1,2,2,3,3,3};
        // System.out.println(removeDuplicates(arr));
        // print(arr, 0);

        // int[] arr = {1,2,3,4,5,6,7};
        // leftRotate(arr, 10);
        // print(arr, 0);

        // int[] arr = {1,2,3,4,5};
        // rightRotate(arr, 2);
        // print(arr, 0);

        // System.out.println("the majority element in the list is: " + majority(new
        // int[] {1,1,1,2,3,4,5,5,6,7}));

        // var arr = new int[] {1,0,2,3,2,0,0,4,5,1};
        // moveAllZerosEnd(arr, arr.length);
        // print(arr, 0);

        // var arr1 = new int[] { 1, 2, 3, 4 };
        // var arr2 = new int[] { 2, 3, 5 };
        // var list = union(arr1, arr2, 1);
        // System.out.println(list);

        // intersection of two arrays
        // var arr1 = new int[] { 1, 2, 2, 3, 3, 4, 5, 6 };
        // var arr2 = new int[] { 2, 3, 3, 5, 6, 7 };
        // var arr1 = new int[] { 1, 2, 3, 4 };
        // var arr2 = new int[] { 2, 3, 5 };
        // var list = intersection(arr1, arr2, 0);
        // System.out.println(list);

        // find the missing number
        // var arr1 = new int[] { 1, 2, 4, 5 };
        // int n = arr1.length + 1;
        // System.out.println(missing(arr1, n, "xor"));

        // find the max consiquitive ones
        // int[] arr = {1,1,0,1,1,1,0,0,1,1};
        // System.out.println(maxConsiquitiveOnes(arr));

        // find the answers that appears once
        // System.out.println(appersOnce(new int[] {1,1,2,3,3,5,5}));

        // find the longest subarray with given sum
        // int len = longestSubArrayWithGivenSum(new int[] {1,2,1,3,3,1,1,-1,2}, 3,
        // "hashing");
        // System.out.println(len);

        // longest subarray in the positive array
        // System.out.println(longestSubArrayWithGivenSum(6, new
        // int[]{1,2,3,1,1,1,1,3,3}));

        // var a = sum2(new int[] { 2,6,5,8,11}, 14);
        // print(a, 0);

        // sort the array of zero one and twos
        // var arr = new int[] {
        // 0,1,1,0,1,2,1,2,0,0,0
        // };
        // sortAnArrayOfzerosonesandtwos(arr);
        // print(arr, 0);

        // majority element
        // System.out.println("the majority element is: " + majority(new int[]
        // {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5}, 16));

        // kadanes algorithm
        // System.out.println(maxSubArray(new int[]{-2,-3,4,-1,-2,1,5,-3}));

        // best time to buy and sell stock
        // System.out.println( "the max profit is: " + profitToBuyAndSellStock(new int[]
        // {7,1,5,3,6}));

        // rearrange by sign (if number of +ve == -ve)
        // var arr = new int[] { 3, 1, -2, -5, 2, -4 };
        // var res = rearrangeBySign(arr);
        // print(res, 0);

        // rearrange by sign in general
        // var arr = new int[] { 3, 1, -2, -5, 2, -4, 112, 10};
        // rearrangeBySign(arr, arr.length);
        // print(arr,0);

        // findnig next permuation in an array
        // var arr = new int[] {3,2,1};
        // var arr = new int[] {2,1,5,4,3,0,0};
        // nextPermutation(arr);
        // print(arr,0);

        // finding leaders in an array
        // System.out.println(leaders(new int[] {10, 22, 12, 3, 0, 6}));

        // longest consiquitive sequence
        // var arr = new int[] {102, 4, 100, 1, 101, 3, 2, 1, 1};
        // System.out.println(longestConsiquitiveSequence(arr, "optimal solution"));

        // set the matrix to zeros
        // var mat = new int[][]{
        // {1,1,1,1},
        // {1,0,0,1},
        // {1,1,0,1},
        // {1,1,1,1}
        // };
        // setMatrixToZeros(mat);
        // print(mat, 0);

        // converting a lowercase string to uppercase string
        // System.out.println(toCapital("kl;j34$"));

        // rotate90 an matrix by 90 degree
        // var mat = new int[][] {
        // { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 }
        // };

        // rotate90(mat, null);
        // print(mat, 0);

        // print matrix in the spiral way
        // var mat = new int[][]{
        // {1,2,3,4,5,6},
        // {20,21,22,23,24,7},
        // {19,32,33,34,25,8},
        // {18,31,26,35,26,9},
        // {17,30,29,28,27,10},
        // {16,15,14,13,12,11}
        // };
        // printSpital(mat);

        // find the number of subarrays with the given sum k
        // int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        // int k = 3;
        // System.out.println("the number of subarrays with sum " + k + "is: " +
        // subArrayWithSum(arr, k));

        // printing the pascals triangle
        // System.out.println(pascalsTriangle(5));

        // find the majority elements appearing greater than [n/3]
        // var arr = new int[] { 1, 1, 1, 3, 3, 2, 2, 2 };
        // // System.out.println(majorityElement(arr));
        // System.out.println(majorityElementMorethanNdividedBy3(arr));

        // finding the triplet with sum 0 (three sum problem)
        // int[] arr = {-1, 0, 1, 2, -1, -4};
        // System.out.println(threeSum(arr, arr.length, "optimal"));

        // 4 sum problem: finding the quarts equals to the sum = target
        // int[] arr = {1, 0, -1, 0, -2, 2};
        // System.out.println(fourSum(arr, 0, arr.length));
        // System.out.println(fourSum(arr, 0, "optimal"));

        // count the number of sub arrays with xor k
        // int[] arr = {4, 2, 2, 6, 4};
        // System.out.println("the number of subarrays with xor k is: " + subArrayWithXorK(arr, 6, "optimal"));

        // int[][] intervals = {
        //     {1,3},
        //     {2,6},
        //     {8,9},
        //     {9,11},
        //     {8,10},
        //     {2,4},
        //     {15,18},
        //     {16,17}
        // };
        // // print(mergeOverlappingSubIntervals(intervals), 0);
        // print(mergeOverlappingSubIntervals(intervals, intervals.length), 0);

        // merge two sorted arrays
        // int[] arr1 = {1, 3, 5, 7/*, 0, 0, 0, 0, 0**/};
        // int[] arr2 = {0, 2, 6, 8, 9};
        // // merge(arr1, 4, arr2, arr2.length);
        // // merge(arr1, 4, arr2);
        // merge(arr1, arr2, "optimal-1");
        // print(arr1, 0);
    }
}