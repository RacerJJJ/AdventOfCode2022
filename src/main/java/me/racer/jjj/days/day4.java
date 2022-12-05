package me.racer.jjj.days;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;

import static me.racer.jjj.Main.datafolder;

public class day4 {
    public static void day4()  throws IOException {
        Integer counting = 0;
        Integer overlapingpairs = 0;
        Integer lines = 0;
        try (LineIterator it = FileUtils.lineIterator(new File(datafolder, "data4.txt"), "UTF-8")) {
            while (it.hasNext()) {
                lines++;
                String line = it.nextLine();
                String[] pair = line.split(",");
                String[] firstelve = pair[0].split("-");
                String[] secondelve = pair[1].split("-");

                if ((Math.abs(Integer.parseInt(firstelve[0]) - Integer.parseInt(firstelve[1]))) > (Math.abs(Integer.parseInt(secondelve[0]) - Integer.parseInt(secondelve[1])))) {
                    if (Integer.parseInt(firstelve[0]) <= Integer.parseInt(secondelve[0]) && Integer.parseInt(firstelve[1]) >= Integer.parseInt(secondelve[1])) {
                        counting++;
                    }
                } else if (Integer.parseInt(firstelve[0]) >= Integer.parseInt(secondelve[0]) && Integer.parseInt(firstelve[1]) <= Integer.parseInt(secondelve[1])) {
                    counting++;
                }

                if ((Integer.parseInt(firstelve[1]) < Integer.parseInt(secondelve[0]) && Integer.parseInt(firstelve[0]) < Integer.parseInt(secondelve[0])) ||
                        (Integer.parseInt(secondelve[1]) < Integer.parseInt(firstelve[0]) && Integer.parseInt(secondelve[0]) < Integer.parseInt(firstelve[0]))) {
                    overlapingpairs++;
                }

            }
        } finally {
            System.out.println("Part 1: " + counting);
            System.out.println("Part 2: " + (lines - overlapingpairs));
        }
    }
}