package DSA.BinarySearch;

public class Main {

    public static int BinarySearchRecursive(int[] arr, long low, long high, long search) {
        if (low > high) return -1;
        else {
            long mid = (low + high) >> 1;
            if(arr[(int)mid] == search) return (int)mid;
            else if(arr[(int)mid] > search) return BinarySearchRecursive(arr, low, mid -1, search);
            else return BinarySearchRecursive(arr, mid + 1, high, search);
        }
    }

    public static int BinarySearchIterative(int[] arr, long low, long high, long search) {
        while (low <= high) {
            long mid = (low + high) >> 1;
            if(arr[(int)mid] == search) return (int)mid;
            else if(arr[(int)mid] > search) high = mid-1;
            else low = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,6};
        System.out.println("Binary Search Iterative: " + BinarySearchIterative(arr, 0, arr.length-1, 5));
        System.out.println("Binary Search Recursive: " + BinarySearchRecursive(arr, 0, arr.length-1, 5));
    }
}
