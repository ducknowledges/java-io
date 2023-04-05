package com.github.ducknowledges.io.bufferedstreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBufferedBytes {
    public static void main(String[] args) {
        copyBufferedBytes();
        copyBufferedBytesAutocloseable();
    }

    private static void copyBufferedBytes() {
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream("input/input"));
            outputStream = new BufferedOutputStream(
                new FileOutputStream("output/bufferedByteOutput"));
            int readByte;
            while ((readByte = inputStream.read()) != -1) {
                outputStream.write(readByte);
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

    private static void copyBufferedBytesAutocloseable() {
        try (
                BufferedInputStream inputStream = new BufferedInputStream(
                        new FileInputStream("input/input"));
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream("output/bufferedByteOutput"))) {
            int readedByte;
            while ((readedByte = inputStream.read()) != -1) {
                outputStream.write(readedByte);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
