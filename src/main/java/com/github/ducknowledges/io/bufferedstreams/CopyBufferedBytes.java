package com.github.ducknowledges.io.bufferedstreams;

import java.io.*;

public class CopyBufferedBytes {
    public static void main(String[] args) throws IOException {
        copyBufferedBytes();
        copyBufferedBytesAutocloseable();
    }

    private static void copyBufferedBytes() throws IOException {
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;

        try {
            inputStream = new BufferedInputStream(new FileInputStream("src/main/resources/input"));
            outputStream = new BufferedOutputStream(new FileOutputStream("src/main/resources/bufferedByteOutput"));
            int readedByte;
            while ((readedByte = inputStream.read()) != -1) {
                outputStream.write(readedByte);
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

    private static void copyBufferedBytesAutocloseable() throws IOException {
        try (
                BufferedInputStream inputStream = new BufferedInputStream(
                        new FileInputStream("src/main/resources/input"));
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream("src/main/resources/bufferedByteOutput"))) {
            int readedByte;
            while ((readedByte = inputStream.read()) != -1) {
                outputStream.write(readedByte);
            }
        }
    }
}
