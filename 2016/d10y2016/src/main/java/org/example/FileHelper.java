package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    public static List<String> readFileAsList(String filePath){
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            while(reader.ready()){
                strings.add( reader.readLine());
            }
            // 110346 correct result part1
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return strings;
    }
}
