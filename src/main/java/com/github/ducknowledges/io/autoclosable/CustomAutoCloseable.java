package com.github.ducknowledges.io.autoclosable;

import java.io.IOException;

public class CustomAutoCloseable implements AutoCloseable {
    public void doSomeStaff() throws IOException {
        System.out.println("Doing some staff...");
    }

    @Override
    public void close() throws IOException {
        System.out.println("CustomAutoCloseable is closed");
    }
}
