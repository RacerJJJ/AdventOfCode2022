package me.racer.jjj.days;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;

import static me.racer.jjj.Main.datafolder;

public class day3 {

    public static void day3() throws IOException {
        try (LineIterator it = FileUtils.lineIterator(new File(datafolder, "data.txt"), "UTF-8")) {
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] split = line.split(" ");
            }
        } finally {
            System.out.println();
        }
    }
}
