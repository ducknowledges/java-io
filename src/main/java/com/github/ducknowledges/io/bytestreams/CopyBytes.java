package com.github.ducknowledges.io.bytestreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        copyBytes();
        copyBytesAutocloseable();
    }

    private static void copyBytes() throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream("src/main/resources/input");
            outputStream = new FileOutputStream("src/main/resources/byteOutput");
            int readedByte;
            while ((readedByte = inputStream.read()) != -1) {
                outputStream.write(readedByte);
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

    private static void copyBytesAutocloseable() throws IOException {
        try (
                FileInputStream inputStream = new FileInputStream("src/main/resources/input");
                FileOutputStream outputStream = new FileOutputStream("src/main/resources/byteOutput")) {
            int readedByte;
            while ((readedByte = inputStream.read()) != -1) {
                outputStream.write(readedByte);
            }
        }
    }
}
