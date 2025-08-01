package com.github.asayyid.rle;

public class Main {

    public static void main(String[] args) {
        RunLengthEncoder encoder = new RunLengthEncoder();
        // Check if the string array is empty or null the print encode with default value
        if (args == null || args.length == 0) {
            String input = "wwwwaaadexxxxxx";
            String encoded = encoder.encode(input);

            System.out.println("Original: " + input);
            System.out.println("Encoded:  " + encoded);
        } else {
            // If strings are provided, loop through the array, decode and print each one.
            for (String str : args) {
                System.out.println("Original: " + str);
                System.out.println("Encoded:  " + encoder.encode(str));
            }
        }
    }
}