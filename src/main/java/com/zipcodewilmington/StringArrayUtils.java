package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0]; // Index 0
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1]; // Index 1
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1]; // Last element in array
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2]; // Second to last element in array
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (int i = 0; i < array.length; i++) { // Iterates through an array
            if (array[i].equals(value)) { // Checks to see if the array at index [i] is equal to value given using .equals for exact string
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] arr = new String[array.length]; // Instantiates the array
        for (int i = 0; i < array.length; i++){ // Iterates through the String[] array
            arr[i] = array[array.length - 1 - i]; // Sets array reverse at index i to what the last element of String[] array
            // -1 because arrays start at index 0. -i because it will gradually go through the indexes of String[] array in descending order.
        }
        return arr;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String[] reverse = new String[array.length]; // Instantiates the array

        for (int i = 0; i < array.length; i++) { // Iterates through the String[] array
            reverse[i] = array[array.length - 1 - i]; // Sets array reverse at index i to what the last element of String[] array
            // -1 because arrays start at index 0. -i because it will gradually go through the indexes of String[] array in descending order.

            if (Arrays.equals(array, reverse)) { // The built-in command Array.equals checks if two arrays are equal.
                return true; // If equal, returns true
            }
        }
        return false; // In all other cases, returns false
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String string = Arrays.toString(array).toLowerCase(); // turns array into string, saves headache of testing for capitals
        int test = 0;
        boolean pangramic = false;
        for (char c = 'a'; c <= 'z'; c++){ // loops through alphabet from 1-26
            test = string.indexOf(c); //
            if (test >= 0) {
                pangramic = true;
            }else {
                pangramic = false;
            }
        }
        return pangramic;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int counter = 0; // Initialize counter
        for (int i = 0; i < array.length; i++){ // Iterates through String[] array
            if (array[i].equals(value)){ // increment counter if string value occurs more than once
                counter++;
            }
        }
        return counter;
    }

    /**
     * @param array array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> newArray = new ArrayList<>(); // instantiates new array list
        for(String string : array){
            if (!string.equals(valueToRemove)){
                newArray.add(string);
            }
        }
        String[] rebuilt = new String[newArray.size()];
        rebuilt = newArray.toArray(rebuilt);
        return rebuilt; // condensed version of current return
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArray = new ArrayList<>(); // Initiates a new ArrayList
        newArray.add(array[0]);
        for (int i = 1; i < array.length; i++){ // Iterates through String[] array
            if(!array[i-1].equals(array[i])){ // Checks previous index and current index
                newArray.add(array[i]);
            }
        }
        return newArray.toArray(new String[0]); // superCondensed version of return above
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> test = new ArrayList<>(); // Initiates a new ArrayList
        StringBuilder chars = new StringBuilder(array[0]); // Initiates a StringBuilder that already holds the value at array[0] (Lets you keep adding to the string)

        for (int i = 1; i < array.length; i++) { // Iterates through String[] array
            if (array[i].equals(array[i - 1])) { // Checks if index[i] is equal to the previous index...
                chars.append(array[i]); // It will add the index[i] to the stringbuilder if consecutive duplicate
            } else {
                test.add(chars.toString()); // Add the string we made to our ArrayList
                chars = new StringBuilder(array[i]); // Resets the Stringbuilder for next sequence
            }
        }
        test.add(chars.toString()); // Add the last sequence after loop ends
        return test.toArray(new String[0]); // Convert ArrayList to String array
    }
}
