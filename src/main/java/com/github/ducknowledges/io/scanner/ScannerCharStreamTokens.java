package com.github.ducknowledges.io.scanner;

import java.io.*;
import java.util.Scanner;

public class ScannerCharStreamTokens {
    public static void main(String[] args) {
        scanCharStream();
        scanCharStreamAutocloseable();
    }

    private static void scanCharStream() {
        Scanner scanner = null;
        BufferedWriter outputStream = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("input/input")));
            outputStream = new BufferedWriter(new FileWriter("output/scannedCharStreamTokens"));
            scanner.useDelimiter(" ");
            while (scanner.hasNext()) {
                outputStream.write(scanner.next());
                outputStream.write(" ");
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        finally {
            if (scanner != null) {
                scanner.close();
                IOException ioException = scanner.ioException();
                if((new IOException()).equals(ioException)) {
                    System.err.println(ioException.getMessage());
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException exception) {
                    System.err.println(exception.getMessage());
                }
            }
        }
    }

    private static void scanCharStreamAutocloseable() {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("input/input")));
             BufferedWriter outputStream = new BufferedWriter(new FileWriter("output/scannedCharStreamTokens"))
        ) {
            scanner.useDelimiter(" ");
            while (scanner.hasNext()) {
                outputStream.write(scanner.next());
                outputStream.write(" ");
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
