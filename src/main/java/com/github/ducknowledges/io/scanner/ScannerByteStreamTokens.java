package com.github.ducknowledges.io.scanner;

import java.io.*;
import java.util.Scanner;

public class ScannerByteStreamTokens {
    public static void main(String[] args) throws IOException {
        scanByteStream();
        scanByteStreamAutocloseable();
    }

    private static void scanByteStream(){
        Scanner scanner = null;
        BufferedWriter outputStream = null;
        try {
            scanner = new Scanner(new BufferedInputStream(new FileInputStream("input/input")));
            outputStream = new BufferedWriter(new FileWriter("output/scannedByteStreamTokens"));
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

    private static void scanByteStreamAutocloseable() {
        try (Scanner scanner = new Scanner(
                new BufferedInputStream(
                        new FileInputStream("input/input")));
             BufferedWriter outputStream = new BufferedWriter(
                     new FileWriter("output/scannedByteOutput"))
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
