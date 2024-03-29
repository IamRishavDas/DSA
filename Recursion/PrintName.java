package DSA.Recursion;

public class PrintName{
    // print linerly from 1 to N
    static void print(int i, int n){
        if(i > n){
            return;
        }
        System.out.println(i);
        print(i+1, n);
    }
    // print reverse linearly
    static void printReverse(int i, int n){
        if(i < 1){
            return;
        }
        System.out.println(i);
        printReverse(i-1,n);
    }
    // print linerly from 1 to N but dont use i++
    static void f(int i, int n){
        if(i < 1){
            return;
        }
        f(i-1, n);
        System.out.println(i);
    }
    // print reverse linerly using backtracking
    static void fReverse(int i, int n){
        if(i > n){
            return;
        }
        fReverse(i+1, n);
        System.out.println(i);
    }

    // print sum of n numbers recursively using parameters
    public static void printSum(int a, int sum){
        if(a < 1){
            System.out.println(sum);
            return;
        }
        printSum(a-1, sum + a);
    }

    // print the sum of n numbers from 1 using functional recursion
    public static int printSum(int n){
        if(n == 1) return 1;
        return n + printSum(n-1);
    }

    // print factorial usiing functional recursion
    public static int fact(int n){
        if(n == 0) return 1;
        return n * fact(n-1);
    }

    // reverse an array usnig two pointer approach
    public static void reverse(int[] arr, int i, int j){
        if(i == j){
            print(arr);
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverse(arr, i+1, j-1);
    }

    // reverse an array using single pointer approach
    static void reverse(int[] arr, int i){
        if(i >= arr.length/2){
            print(arr);
            return;
        }
        int j = arr.length-i-1;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        reverse(arr, i+1);
    }

    // check a string is palindrome or not using recursion
    static boolean palindrome(String s, int i){
        if(i>s.length()/2) return true;
        if(s.charAt(i) == s.charAt(s.length()-i-1)){
            return palindrome(s, i+1);
        } else {
            return false;
        }
    }

    // print the fibonacci number using recursion
    static int fibonacci(int n){
        if(n == 0 || n == 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    static void print(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
    }

    static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
    public static void main(String[] args){
        int n = 5;

        // print(1,n);
        
        // System.out.println("the reverse of pattern will be: ");
        // printReverse(n, n);

        // System.out.println("print linerly using backtracking: ");
        // f(n, n);

        // System.out.println("print reverse linerly usnig backtracking: ");
        // fReverse(1, n);

        // System.out.println(printSum(n));
        // int ans = fact(n-1);
        // System.out.println(ans);

        // reverse an array
        // int[] a = {10,12,11,11,17,16};
        // reverse(a, 0);

        // checking palindrome
        // boolean ans = palindrome("sir", 0);
        // System.out.println(ans);

        // print the nth fibonacci number
        System.out.println(fibonacci(n));
    }
}