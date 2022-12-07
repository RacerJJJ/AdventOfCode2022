package me.racer.jjj.days;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static me.racer.jjj.Main.datafolder;

public class day6 {
    public static void day6(File input)  throws IOException {
    Integer part1 = 0;
    Integer part2 = 0;
    try (LineIterator it = FileUtils.lineIterator(input, "UTF-8")) {
        while (it.hasNext()) {
            String line = it.nextLine();
            for (Integer markerlength: new int[]{4, 14}) {
                for (Integer firstindex = 0; firstindex + markerlength < line.length(); firstindex++) {
                    ArrayList<Character> characters = new ArrayList<>();
                    for (Integer i = 0; i < markerlength; i++) {
                        characters.add(line.charAt(firstindex + i));
                    }
                    if (!hasDuplicates(characters)) {
                        if (markerlength == 4) {
                            part1 = firstindex + markerlength;
                        }
                        if (markerlength == 14) {
                            part2 = firstindex + markerlength;
                        }
                        break;
                    }
                }

            }

        }
    } finally {
        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }
}
    public static <T> boolean hasDuplicates(final Collection<T> coltotest) {
        if (coltotest == null || coltotest.isEmpty()) {
            return false;
        }
        return new HashSet<>(coltotest).size() != coltotest.size();
    }

}
