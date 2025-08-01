package com.github.asayyid.rle;

/**
 * RunLengthEncoder class provides functionality to encode strings using run-length encoding.
 * Run-length encoding compresses strings by replacing consecutive repeated characters
 * with the character followed by its count.
 */

public class RunLengthEncoder {

    /**
     * Encodes a string using run-length encoding algorithm.
     *
     * @param input The string to be encoded
     * @return The run-length encoded string
     * @throws IllegalArgumentException if input is null
     */
    public String encode(String input) {


        // Null value validation
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        // Handle empty string case
        if (input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;

        // Loop through the string from the second character onward
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                // Increment the tally for repeated consecutive characters
                count++;
            } else {
                // Append the current character and count to result
                result.append(currentChar).append(count);
                // Reset count and update current char value
                currentChar = input.charAt(i);
                count = 1;
            }
        }

      //Append the last character and its count
      result.append(currentChar).append(count);

        return result.toString();
    }
}