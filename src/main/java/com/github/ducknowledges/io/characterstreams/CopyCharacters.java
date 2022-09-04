package com.github.ducknowledges.io.characterstreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        copyCharacters();
        copyCharactersAutocloseable();
    }

    private static void copyCharacters() throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("src/main/resources/input");
            outputStream = new FileWriter("src/main/resources/charOutput");
            int readedChar;
            while ((readedChar = inputStream.read()) != -1) {
                outputStream.write(readedChar);
            }
        } finally {
            if(inputStream != null) {
                inputStream.close();
            }
            if(outputStream != null) {
                outputStream.close();
            }
        }

    }

    private static void copyCharactersAutocloseable() throws IOException {
        try (
                FileReader inputStream = new FileReader("src/main/resources/input");
                FileWriter outputStream = new FileWriter("src/main/resources/charOutput");
                ) {
            int readedChar;
            while ((readedChar = inputStream.read()) != -1) {
                outputStream.write(readedChar);
            }
        }
    }
}
