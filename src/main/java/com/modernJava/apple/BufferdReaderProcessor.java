package com.modernJava.apple;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferdReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
