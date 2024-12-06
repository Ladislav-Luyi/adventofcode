package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static List<List<Character>> list = new ArrayList<>();
    static ArrayList<String> strings = loadFile("input");
    static {
        for (String string : strings) {
            ArrayList<Character> objects = new ArrayList<>();
            for (String s : string.split("")) {
                objects.add(s.charAt(0));
            }
            list.add(objects);
        }
    }
    public static void main(String[] args) {
        Guard guard = new Guard(list);
        System.out.println( guard.countSteps() );
        System.out.println(guard.countDistinctPositions());
    }

    static public ArrayList<String> loadFile(String filename) {
        ArrayList<String> lines = new ArrayList<String>();

        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classloader.getResourceAsStream(filename);
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            for (String line; (line = reader.readLine()) != null; ) {
                lines.add(line);
            }

        } catch (FileNotFoundException fnfe) {
            // process errors
        } catch (IOException ioe) {
            // process errors
        }
        return lines;
    }
}