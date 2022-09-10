package com.github.ducknowledges.io.characterstreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        copyCharacters();
        copyCharactersAutocloseable();
    }

    private static void copyCharacters() {
        FileReader inputStream = null;
        FileWriter outputStream = null;
        try {
            inputStream = new FileReader("input/input");
            outputStream = new FileWriter("output/charOutput");
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

    private static void copyCharactersAutocloseable() {
        try (FileReader inputStream = new FileReader("input/input");
             FileWriter outputStream = new FileWriter("output/charOutput")) {
            int readedChar;
            while ((readedChar = inputStream.read()) != -1) {
                outputStream.write(readedChar);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
