package me.racer.jjj.days;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static me.racer.jjj.Main.datafolder;

public class day3 {

    public static void day3(File input) throws IOException {
        Integer priority = 0;
        Integer priority2 = 0;
        try (LineIterator it = FileUtils.lineIterator(input, "UTF-8")) {
            while (it.hasNext()) {
                String line1 = it.nextLine();
                String line2 = it.nextLine();
                String line3 = it.nextLine();
                String[] grouplines = {line1, line2, line3};
                for (String line: grouplines) {
                    String firstcompartment = line.substring(0, (line.length()/2));
                    String secondcomparment = line.substring(line.length()/2);
                    ArrayList<String> preventduplicates = new ArrayList<>();
                    for (String character: firstcompartment.split("")) {
                        if (secondcomparment.contains(character) && !preventduplicates.contains(character)) {
                            preventduplicates.add(character);
                            priority += (Character.getNumericValue(character.charAt(0)) - 9);
                            if (character.toUpperCase().equals(character)) {
                                priority += 26;
                            }
                        }
                    }
                    preventduplicates.clear();
                }
                for (String character: line1.split("")) {
                    if (line2.contains(character) && line3.contains(character)) {
                        priority2 += (Character.getNumericValue(character.charAt(0)) - 9);
                        if (character.toUpperCase().equals(character)) {
                            priority2 += 26;
                        }
                        break;
                    }
                }

            }
        } finally {
            System.out.println("Part 1: " + priority);
            System.out.println("Part 2: " + priority2);
        }
    }
}
