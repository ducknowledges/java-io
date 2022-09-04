package com.github.ducknowledges.io.bufferedstreams;

import java.io.*;

public class CopyBufferedCharacters {
    public static void main(String[] args) throws IOException {
        copyBufferedCharacters();
        copyBufferedCharactersAutocloseable();
    }

    private static void copyBufferedCharacters() throws IOException {
        BufferedReader inputStream = null;
        BufferedWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("src/main/resources/input"));
            outputStream = new BufferedWriter(new FileWriter("src/main/resources/bufferedCharOutput"));
            int readedChar;
            while ((readedChar = inputStream.read()) != -1) {
                outputStream.write(readedChar);
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

    private static void copyBufferedCharactersAutocloseable() throws IOException {
        try (
                BufferedInputStream inputStream = new BufferedInputStream(
                        new FileInputStream("src/main/resources/input"));
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream("src/main/resources/bufferedCharOutput"))) {
            int readedChar;
            while ((readedChar = inputStream.read()) != -1) {
                outputStream.write(readedChar);
            }
        }
    }
}
