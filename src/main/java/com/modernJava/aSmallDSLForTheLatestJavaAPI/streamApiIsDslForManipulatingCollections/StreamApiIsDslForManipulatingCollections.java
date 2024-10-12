package com.modernJava.aSmallDSLForTheLatestJavaAPI.streamApiIsDslForManipulatingCollections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiIsDslForManipulatingCollections {
    public static void main(String[] args) throws IOException {
        List<String> errors1= new ArrayList<>();
        int errorCount = 0;
        BufferedReader bufferedReader
                = new BufferedReader(new FileReader("fileName"));
        String line1 = bufferedReader.readLine();
        while (errorCount < 40 && line1 != null) {
            if (line1.startsWith("ERROR")) {
                errors1.add(line1);
                errorCount++;
            }
            line1 = bufferedReader.readLine();
        }

        List<String> errors2 = Files.lines(Paths.get("fileName"))
                .filter(line2 -> line2.startsWith("ERROR"))
                .limit(40)
                .collect(Collectors.toList());
    }
}
