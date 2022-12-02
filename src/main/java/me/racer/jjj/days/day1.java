package me.racer.jjj.days;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static me.racer.jjj.Main.datafolder;

public class day1 {
    public static void day1() throws IOException {
        try (LineIterator it = FileUtils.lineIterator(new File(datafolder, "data.txt"), "UTF-8")) {
            int currentone = 0;
            int currentelf = 0;
            HashMap<String, Integer> alllist = new HashMap<>();
            while (it.hasNext()) {
                String line = it.nextLine();
                if (!line.isEmpty()) {
                    currentone = currentone + Integer.parseInt(line);
                    System.out.println((currentone - Integer.parseInt(line)) + " + " + line + " = " + currentone);
                } else {
                    alllist.put("elf" + currentelf, currentone);
                    System.out.println("elf" + currentelf + " | " + currentone);
                    currentelf++;
                    currentone = 0;
                }
            }
            System.out.println(alllist.entrySet());
            int highest = 0;
            int highest2 = 0;
            int highest3 = 0;
            String richestelf = null;
            String richestelf2 = null;
            String richestelf3 = null;
            for (Map.Entry<String, Integer> value : alllist.entrySet()) {
                if (value.getValue() > highest) {
                    highest = value.getValue();
                    richestelf = value.getKey();
                } else if (value.getValue() > highest2) {
                    highest2 = value.getValue();
                    richestelf2 = value.getKey();
                } else if (value.getValue() > highest3) {
                    highest3 = value.getValue();
                    richestelf3 = value.getKey();
                }
            }
            System.out.println(" ");
            System.out.println("1. " + richestelf + " " + highest);
            System.out.println("2. " + richestelf2 + " " + highest2);
            System.out.println("3. " + richestelf3 + " " + highest3);
            System.out.println("Total Top 3: " + (highest3 + highest2 + highest));
        }
    }
}
