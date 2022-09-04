package com.github.ducknowledges.io.scanning;

import java.io.*;
import java.util.Scanner;

public class ScannerBufferedByteStreamIntoTokens {
    public static void main(String[] args) throws IOException {
        scanByteStream();
        scanByteStreamAutocloseable();
    }

    private static void scanByteStream() throws IOException {
        Scanner scanner = null;
        BufferedWriter outputStream = null;

        try {
            scanner = new Scanner(new BufferedInputStream(new FileInputStream("src/main/resources/input")));
            scanner.useDelimiter(" ");
            outputStream = new BufferedWriter(new FileWriter(
                    "src/main/resources/scannedBufferedByteOutput"));
            while (scanner.hasNext()) {
                outputStream.write(scanner.next());
                outputStream.write(" ");
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private static void scanByteStreamAutocloseable() throws IOException {

        try (Scanner scanner = new Scanner(
                new BufferedInputStream(
                        new FileInputStream("src/main/resources/input")));
             BufferedWriter outputStream = new BufferedWriter(
                     new FileWriter("src/main/resources/scannedBufferedByteOutput"))
        ) {
            scanner.useDelimiter(" ");
            while (scanner.hasNext()) {
                outputStream.write(scanner.next());
                outputStream.write(" ");
            }
        }
    }
}
