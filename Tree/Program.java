package DSA.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Program {


    public static List<String> matchPattern(String pattern, String str) {
        if (pattern.isEmpty()) {
            return str.isEmpty() ? Arrays.asList("", "") : Collections.emptyList();
        }

        // Normalize pattern so that it starts with 'x'
        boolean startsWithY = pattern.charAt(0) == 'y';
        if (startsWithY) {
            pattern = pattern.replace('x', 'a').replace('y', 'x').replace('a', 'y');
        }

        int countX = countOccurrences(pattern, 'x');
        int countY = pattern.length() - countX;
        int strLength = str.length();

        // Try all possible lengths for 'x' and calculate corresponding lengths for 'y'
        for (int lenX = 1; lenX <= strLength; lenX++) {
            int totalXLength = countX * lenX;
            int remainingLength = strLength - totalXLength;

            if (countY == 0) {
                if (remainingLength == 0) {
                    String xVal = str.substring(0, lenX);
                    return startsWithY ? Arrays.asList("", xVal) : Arrays.asList(xVal, "");
                } else {
                    continue;
                }
            }

            if (remainingLength % countY != 0) {
                continue;
            }

            int lenY = remainingLength / countY;
            int yStartIdx = pattern.indexOf('y') * lenX;

            // Ensure yStartIdx + lenY doesn't go out of bounds
            if (yStartIdx + lenY > strLength) {
                continue;
            }

            String xVal = str.substring(0, lenX);
            String yVal = str.substring(yStartIdx, yStartIdx + lenY);

            if (rebuildString(pattern, xVal, yVal).equals(str)) {
                return startsWithY ? Arrays.asList(yVal, xVal) : Arrays.asList(xVal, yVal);
            }
        }

        return Collections.emptyList();
    }

    // Helper method to count occurrences of a character in a string
    private static int countOccurrences(String pattern, char charToCount) {
        int count = 0;
        for (char c : pattern.toCharArray()) {
            if (c == charToCount) {
                count++;
            }
        }
        return count;
    }

    // Helper method to rebuild string based on the pattern using xVal and yVal
    private static String rebuildString(String pattern, String xVal, String yVal) {
        StringBuilder result = new StringBuilder();
        for (char c : pattern.toCharArray()) {
            if (c == 'x') {
                result.append(xVal);
            } else {
                result.append(yVal);
            }
        }
        return result.toString();
    }
    
    public static boolean test(String words, String doc){
        if(words.equals(doc)) return true;

        words = words.toLowerCase();
        doc = doc.toLowerCase();

        String specialChars = "!,'";
        String auxilary[] = {"is", "are", "were", "was"};

        List<String> wordList = new ArrayList<>();
        List<String> docList = new ArrayList<>();

        String temp = "";
        for(char c: words.toCharArray()){
            if(c == ' ' && temp.length() != 0){
                wordList.add(temp);
                temp = "";
            } else {
                temp += c;
            }
        }
        if(!temp.isEmpty()) wordList.add(temp);
        temp = "";
        for(char c: doc.toCharArray()){
            if(c == ' ' && temp.length() != 0){
                docList.add(temp);
                temp = "";
            } else {
                if(!specialChars.contains(String.valueOf(c)))
                    temp += c;
            }
        }
        if(!temp.isEmpty()) docList.add(temp);
        System.out.println(wordList);
        System.out.println(docList);

        int flag = 0;
        for(String i: docList){
            boolean isAuxilary = false;
            for(String a: auxilary){
                if(i.equals(a)) isAuxilary = true;
            }
            if(isAuxilary) continue;
            for(String j: wordList){
                if(i.equals(j)) flag = 1;
            }
            if(flag == 0) return false;
        }
        if(flag == 1) return true;
        return false;
    }
    public static void main(String[] args) {
        // String s1 = "Today weather is sunny warm the beautiful day";
        // String s2 = "The weather is beautiful today!";
        // System.out.println(test(s1, s2));

        System.out.println(matchPattern("xxyxxy", "gogopowerrangergogopowerranger"));
    }
}
