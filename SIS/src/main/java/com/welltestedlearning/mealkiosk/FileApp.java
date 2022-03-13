package com.welltestedlearning.mealkiosk;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileApp {
    public static void main(String[] args) {
        String fileName = "";
        try {
            URL file = FileApp.class.getResource(fileName);
            URI uri = file.toURI();
            Path path = Paths.get(uri);
            BufferedReader reader = Files.newBufferedReader(path);

            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] items = line.split(",");
//  -- to be fixed in lab --
//        MealOrder mealOrder = new MealOrder(items[0], items[1]);
//        mealOrder.display();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
