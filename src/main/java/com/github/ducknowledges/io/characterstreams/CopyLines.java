package com.github.ducknowledges.io.characterstreams;

import java.io.*;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        copyLines();
        copyLinesAutocloseable();
    }

    private static void copyLines() throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("src/main/resources/input"));
            outputStream = new PrintWriter(new FileWriter("src/main/resources/charLineOutput"));
            String line;
            while ((line = inputStream.readLine()) != null) {
                outputStream.println(line);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private static void copyLinesAutocloseable() throws IOException {

        try (
                BufferedReader inputStream = new BufferedReader(
                        new FileReader("src/main/resources/input"));
                PrintWriter outputStream = new PrintWriter(
                        new FileWriter("src/main/resources/charLineOutput"))
        ) {
            String line;
            while ((line = inputStream.readLine()) != null) {
                outputStream.println(line);
            }
        }
    }
}