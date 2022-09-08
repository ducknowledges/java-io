package com.github.ducknowledges.io.autoclosable;

import java.io.IOException;

public class TryCatchWithResources {
    public static void main(String[] args) {
        System.out.println("Program start manual close");
        doManualClose();
        System.out.println("Program start auto close");
        doAutoClose();
    }

    private static void doManualClose() {
        CustomAutoCloseable closeable = null;
        try {
            closeable = new CustomAutoCloseable();
            closeable.doSomeStaff();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    private static void doAutoClose() {
        try (CustomAutoCloseable closeable = new CustomAutoCloseable()) {
            closeable.doSomeStaff();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
