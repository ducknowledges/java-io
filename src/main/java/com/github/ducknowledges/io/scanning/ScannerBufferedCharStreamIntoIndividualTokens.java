package com.github.ducknowledges.io.scanning;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class ScannerBufferedCharStreamIntoIndividualTokens {
    public static void main(String[] args) throws IOException {
        scanCharStream();
        scanCharStreamAutocloseable();
    }

    private static void scanCharStream() throws IOException {
        Scanner scanner = null;
        BufferedWriter outputStream = null;
        double sum = 0;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("src/main/resources/numbersInput")));
            scanner.useLocale(Locale.US);
            outputStream = new BufferedWriter(new FileWriter(
                    "src/main/resources/scannedBufferedCharIntoTokensOutput")
            );
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    sum += scanner.nextDouble();
                } else {
                    scanner.next();
                }
            }
            outputStream.write(Double.toString(sum));
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
        double sum = 0;
        try (Scanner scanner = new Scanner(
                new BufferedReader(
                        new FileReader("src/main/resources/numbersInput"))
            );
             BufferedWriter outputStream = new BufferedWriter(
                     new FileWriter(
                             "src/main/resources/scannedBufferedCharIntoTokensOutput")
             )
        ) {
            scanner.useLocale(Locale.US);
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) {
                    sum += scanner.nextDouble();
                } else {
                    scanner.next();
                }
            }
            outputStream.write(Double.toString(sum));
        }
    }
}
