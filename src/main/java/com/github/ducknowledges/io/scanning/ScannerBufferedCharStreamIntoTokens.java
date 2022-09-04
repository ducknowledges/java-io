package com.github.ducknowledges.io.scanning;

import java.io.*;
import java.util.Scanner;

public class ScannerBufferedCharStreamIntoTokens {
    public static void main(String[] args) throws IOException {
        scanCharStream();
        scanCharStreamAutocloseable();
    }

    private static void scanCharStream() throws IOException {
        Scanner scanner = null;
        BufferedWriter outputStream = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("src/main/resources/input")));
            scanner.useDelimiter(" ");
            outputStream = new BufferedWriter(new FileWriter(
                    "src/main/resources/scannedBufferedCharOutput"));
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

    private static void scanCharStreamAutocloseable() throws IOException {

        try (Scanner scanner = new Scanner(
                new BufferedReader(
                        new FileReader("src/main/resources/input")));
             BufferedWriter outputStream = new BufferedWriter(
                     new FileWriter(
                             "src/main/resources/scannedBufferedCharOutput"))
        ) {
            scanner.useDelimiter(" ");
            while (scanner.hasNext()) {
                outputStream.write(scanner.next());
                outputStream.write(" ");
            }
        }
    }
}
