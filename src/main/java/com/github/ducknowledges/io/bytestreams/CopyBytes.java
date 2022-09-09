package com.github.ducknowledges.io.bytestreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        copyBytes();
        copyBytesAutocloseable();
    }

    private static void copyBytes() {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("input/input");
            outputStream = new FileOutputStream("output/byteOutput");
            int readedByte;
            while ((readedByte = inputStream.read()) != -1) {
                outputStream.write(readedByte);
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
                    inputStream.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    // Using try-with-resources
    private static void copyBytesAutocloseable() {
        try (FileInputStream inputStream = new FileInputStream("input/input");
             FileOutputStream outputStream = new FileOutputStream("output/byteOutput")) {
            int readedByte;
            while ((readedByte = inputStream.read()) != -1) {
                outputStream.write(readedByte);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
