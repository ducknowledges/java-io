package com.github.ducknowledges.io.bufferedstreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyBufferedCharacters {
    public static void main(String[] args) {
        copyBufferedCharacters();
        copyBufferedCharactersAutocloseable();
    }

    private static void copyBufferedCharacters() {
        BufferedReader inputStream = null;
        BufferedWriter outputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader("input/input"));
            outputStream = new BufferedWriter(new FileWriter("output/bufferedCharOutput"));
            int readedChar;
            while ((readedChar = inputStream.read()) != -1) {
                outputStream.write(readedChar);
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
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    private static void copyBufferedCharactersAutocloseable() {
        try (
            BufferedInputStream inputStream = new BufferedInputStream(
                        new FileInputStream("input/input"));
            BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream("output/bufferedCharOutput"))) {
            int readedChar;
            while ((readedChar = inputStream.read()) != -1) {
                outputStream.write(readedChar);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
