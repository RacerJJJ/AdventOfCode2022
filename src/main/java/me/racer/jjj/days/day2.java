package me.racer.jjj.days;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;

import static me.racer.jjj.Main.datafolder;

public class day2 {

    private static Integer points1 = 0;
    private static Integer points2 = 0;
    private static Integer lines = 0;

    public static void day2() throws IOException {
        try (LineIterator it = FileUtils.lineIterator(new File(datafolder, "data2.txt"), "UTF-8")) {
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] split = line.split(" ");
                lines += 1;
                switch (split[0]) {
                    case "A" -> {
                        switch (split[1]) {
                            case "X" -> {
                                points1 += 3 + 1;
                                points2 += 3;
                            }
                            case "Y" -> {
                                points1 += 6 + 2;
                                points2 += 3 + 1;
                            }
                            case "Z" -> {
                                points1 += 3;
                                points2 += 6 + 2;
                            }
                        }
                    }
                    case "B" -> {
                        switch (split[1]) {
                            case "X" -> {
                                points1 += 1;
                                points2 += 1;
                            }
                            case "Y" -> {
                                points1 += 3 + 2;
                                points2 += 3 + 2;
                            }
                            case "Z" -> {
                                points1 += 6 + 3;
                                points2 += 6 + 3;
                            }
                        }
                    }
                    case "C" -> {
                        switch (split[1]) {
                            case "X" -> {
                                points1 += 6 + 1;
                                points2 += 2;
                            }
                            case "Y" -> {
                                points1 += 2;
                                points2 += 3 + 3;
                            }
                            case "Z" -> {
                                points1 += 3 + 3;
                                points2 += 6 + 1;
                            }
                        }
                    }
                }
            }
        } finally {
            System.out.println(points1);
            System.out.println(points2);
        }
    }
}