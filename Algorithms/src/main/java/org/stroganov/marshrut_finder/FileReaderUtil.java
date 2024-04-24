package org.stroganov.marshrut_finder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderUtil {
    public static String readFile(String path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
