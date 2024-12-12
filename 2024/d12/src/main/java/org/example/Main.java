package org.example;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Garden garden = new Garden(loadFile("input"));
        garden.showTrial();
        PlotCrawler plotCrawler = new PlotCrawler(garden);
        plotCrawler.run();
        System.out.println(garden.regions);
        for (Region region : garden.regions) {
            System.out.println(region.getRegionId());
            System.out.println(region.perimiter);
            System.out.println(region.area);
            System.out.println("======================");
        }
        PriceCalculator calculator = new PriceCalculator(garden.regions);
        System.out.println(calculator.getPrice());

        SideCalculator sideCalculator = new SideCalculator(garden);
//        System.out.println(sideCalculator.getSidesMapping());


    }

    public static List<String> loadFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();
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