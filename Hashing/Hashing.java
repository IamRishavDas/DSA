import java.util.HashMap;

public class Hashing {
    // number hashing
    private static final int N = 13;
    public static int[] numberHash(int[] arr){
        int[] hashArr = new int[N];
        for(int i : arr){
            hashArr[i]++;
        }
        return hashArr;
    }

    // number hashing using hash map in java
    public static HashMap<Integer, Integer> numberHashUsingHashMap(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>(N);
        for(int i: arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            } else {
                map.put(i,1);
            }
        }
        return map;
    }

    // character hashing
    private static final int M = 26;
    public static int[] characterHash(String s){
        int[] hashArr = new int[M];
        for(char i: s.toCharArray()){
            hashArr[i-97]++;
        }
        // print(hashArr);
        return hashArr;
    }

    // character hashing using hashMap
    public static HashMap<Character, Integer> characterHashMap(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char i: s.toCharArray()){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }

    // finding the highest freqency element
    public static int highestFrequency(HashMap<Integer, Integer> map){
        int max = Integer.MIN_VALUE;
        int key = 0;
        for(var e: map.entrySet()){
            if(e.getValue() > max){
                max = e.getValue();
                key = e.getKey();
            }
        }
        return key;
    }

    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        // number hashing using array
        // int[] arr = {1,2,3,1,2,5,6,5,5};
        // int[] hash = numberHash(arr);
        // System.out.println(hash[5]);
        
        // character hashing using array
        // String s = "abcedaeczz";
        // int[] hashArr = characterHash(s);
        // System.out.println( "The frequency of a is: "+ hashArr['a'-97]);
        
        // number hashing using hashMap in java
        // int[] arr = {1,2,3,1,2,5,6,5,5};
        // var map = numberHashUsingHashMap(arr);
        // System.out.println("the highest frequency element is: " + highestFrequency(map));
        // System.out.println("the occurance of 5 in the array is: " + map.get(5));
        
        // character hashing in java using hashMap
        // String s = "abcedaeczz";
        // var map = characterHashMap(s);
        // System.out.println(map);
    }
}
