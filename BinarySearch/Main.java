package DSA.BinarySearch;

public class Main {

    // implement Binary Search using recursive method
    public static int BinarySearchRecursive(int[] arr, long low, long high, long search) {
        if (low > high) return -1;
        else {
            long mid = (low + high) >> 1;
            if(arr[(int)mid] == search) return (int)mid;
            else if(arr[(int)mid] > search) return BinarySearchRecursive(arr, low, mid -1, search);
            else return BinarySearchRecursive(arr, mid + 1, high, search);
        }
    }

    // implement BinarySearch using iterative method
    public static int BinarySearchIterative(int[] arr, long low, long high, long search) {
        while (low <= high) {
            long mid = (low + high) >> 1;
            if(arr[(int)mid] == search) return (int)mid;
            else if(arr[(int)mid] > search) high = mid-1;
            else low = mid + 1;
        }
        return -1;
    }

    // Lower Bound: smallest index such that, (arr[index] >= x)

    // find lower bound in an array using iterative method (O(n))
    public static int getLowerBound(int[] arr, int x){
        int n = arr.length;
        int lowerBound = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i] >= x){
                lowerBound = i;
                break;
            }
        }
        return lowerBound;
    }

    // implementing the Binary Search for solving the lowerBound problem recursive way
    public static int BSlowerBoundRecursive(int[] arr, int low, int high, int lowerBound, int x){
        if(low > high) return lowerBound;
        int mid = (low + high) >> 1;
        if(arr[mid] >= x){
            lowerBound = mid;
            return BSlowerBoundRecursive(arr, low, mid - 1, lowerBound, x);
        } else {
            return BSlowerBoundRecursive(arr, mid + 1, high, lowerBound, x);
        }
    }

    // implementing the Binary Search for solving the lowerBound problem iterative way
    public static int BSlowerBoundIterative(int[] arr, int low, int high, int x){
        int n = arr.length;
        int lowerBound = n;
        while(low <= high) {
            int mid = (low + high) >> 1;
            if(arr[mid] >= x){
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }

    // Upper Bound: smallest index such that, (arr[index] > x)

    // find the upperBound in an array using Iterative Method
    public static int getUpperBound(int[] arr, int x){
        int n = arr.length;
        int upperBound = n;
        if(x < arr[0]) return 0;
        for(int i=0; i<n; i++){
            if(arr[i] > x){
                upperBound = i;
                break;
            }
        }
        return upperBound;
    }

    // implementing Binary Search recursive for getting the UpperBound
    public static int BSupperBoundRecursive(int[] arr, int low, int high, int upperBound, int x){
        if(low > high) return upperBound;
        if(x < arr[0]) return 0;
        int mid = (low + high) >> 1;
        if(arr[mid] > x){
            upperBound = mid;
            return BSupperBoundRecursive(arr, low, mid - 1, upperBound, x);
        } else {
            return BSupperBoundRecursive(arr, mid + 1, high, upperBound, x);
        }
    }

    // implementing Binary Search iterative for getting the UpperBound
    public static int BSupperBoundIterative(int[] arr, int low, int high, int x){
        int upperBound = arr.length;
        if(x < arr[0]) return 0;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(arr[mid] > x){
                upperBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return upperBound;
    }

    // find the upper bound using Binary Search (O(logn))
    public static int getUpperBound(int[] arr, int n, int x){
        // return BSupperBoundIterative(arr, 0, arr.length - 1, x);
        int upperBound = arr.length;
        return BSupperBoundRecursive(arr, 0, arr.length - 1, upperBound, x);
    }

    // implementing lower bound using BinarySearch
    public static int getLowerBound(int[] arr, int n, int x){
        n = arr.length;
        // int lowerBound = n;
        // return BSlowerBoundRecursive(arr, 0, n-1, lowerBound, x);
        return BSlowerBoundIterative(arr, 0, n-1, x);
    }

    // Ceil value: smallest element such that, (arr[index] >= x) 

    // find the ceil value
    public static int ceilinArray(int[] arr, int x){
        // may return -1 if such value not found in the array
        return arr[getLowerBound(arr, arr.length, x)];
    }

    // Floor value: largest element such that, (arr[index] <= x)

    // find the floor value
    public static int floorinArray(int[] arr, int x){
        int n = arr.length;
        int ans = -1;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(arr[mid] <= x) {
                ans  = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        } 
        return ans;
    }


    public static void main(String[] args) {
        // implement Binary Search
        // int[] arr = {1,3,5,6,6};
        // System.out.println("Binary Search Iterative: " + BinarySearchIterative(arr, 0, arr.length-1, 5));
        // System.out.println("Binary Search Recursive: " + BinarySearchRecursive(arr, 0, arr.length-1, 5));

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
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Ceil: " + ceilinArray(arr, 25));
        System.out.println("Floor: " + floorinArray(arr, 25));
    }
}
