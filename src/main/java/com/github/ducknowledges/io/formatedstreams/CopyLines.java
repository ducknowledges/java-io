package com.github.ducknowledges.io.formatedstreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {
    public static void main(String[] args) {
        copyLines();
        copyLinesAutocloseable();
    }

    private static void copyLines() {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader("input/input"));
            outputStream = new PrintWriter(new FileWriter("output/charLineOutput"));
            String line;
            while ((line = inputStream.readLine()) != null) {
                outputStream.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private static void copyLinesAutocloseable() {

        try (BufferedReader inputStream = new BufferedReader(
                        new FileReader("input/input"));
             PrintWriter outputStream = new PrintWriter(
                        new FileWriter("output/charLineOutput"))) {
            String line;
            while ((line = inputStream.readLine()) != null) {
                outputStream.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
