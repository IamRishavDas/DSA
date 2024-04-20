package DSA.Sorting;

public class Sorting {

    // selection sort
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) { // it will swap when it will see any smaller element than arr[i]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    // optimized selection sort
    public static int[] selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i])
                    min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    // bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // optimized bubble sort
    public static void bubbleSort(int[] arr, int n) {
        for (int i = n - 1; i >= 0; i--) {
            boolean didSwap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                break;
            }
        }
    }

    // insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    // print the array
    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // merge sort in java

    // recursive algorithm for merge sort
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high + 1];
        int left = low;
        int right = mid + 1;
        int index = low;

        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        while (right <= high) {
            temp[index++] = arr[right++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }

    // quick sort in java

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }

            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        return j;
    }

    public static void main(String[] args) {
        int[] arr = { 13, 46, 24, 52, 20, 9 };
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }
}
