package de.agiledojo.hangman.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MockStdIn extends InputStream {


    private final Queue<Byte> bytes;

    public static MockStdIn create() {
        MockStdIn mockStdIn = new MockStdIn();
        System.setIn(mockStdIn);
        return mockStdIn;
    }

    public static String lineBreak() {
        return System.getProperty("line.separator");
    }

    private MockStdIn() {
        bytes = new ConcurrentLinkedQueue<>();
    }

    @Override
    public int read() throws IOException {
        Byte b = bytes.poll();
        return b != null? b.intValue() : -1;
    }

    public void enter(String line) {
        line += "\n";
        for (byte b : line.getBytes())
            bytes.add(b);
    }
}
