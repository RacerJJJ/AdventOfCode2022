package me.racer.jjj;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        day2();
    }
    
    
    public static void day2() throws IOException {
        LineIterator it = FileUtils.lineIterator(new File("data2.txt"), "UTF-8");
        Boolean win = true;
        Integer points = 0;
        Integer lines = 0;
        HashMap<String,Integer> alllist = new HashMap<>();
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] split = line.split(" ");
                lines += 1;
                if (split[0].equals("A")) {
                    switch (split[1]) {
                        case "X":
                            points += 3 + 1;
                            break;
                        case "Y":
                            points += 6 + 2;
                            break;
                        case "Z":
                            points += 3;
                            break;
                    }
                } else if (split[0].equals("B")) {
                    switch (split[1]) {
                        case "X":
                            points += 1;
                            break;
                        case "Y":
                            points += 3 + 2;
                            break;
                        case "Z":
                            points += 6 + 3;
                            break;
                    }
                } else if (split[0].equals("C")) {
                    switch (split[1]) {
                        case "X":
                            points += 6 + 1;
                            break;
                        case "Y":
                            points += 2;
                            break;
                        case "Z":
                            points += 3+3;
                            break;
                    }

                }
            }
        } finally {
            it.close();
            System.out.println(points);
            System.out.println(lines);
        }
    }



    public static void day1() throws IOException {
        LineIterator it = FileUtils.lineIterator(new File("data.txt"), "UTF-8");
        Integer currentone = 0;
        Integer currentelf = 0;
        HashMap<String,Integer> alllist = new HashMap<>();
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                if (!line.isEmpty()) {
                    currentone = currentone +Integer.parseInt(line);
                    System.out.println((currentone - Integer.parseInt(line)) + " + " + line + " = " + currentone);
                } else {
                    alllist.put("elf" + currentelf.toString(), currentone);
                    System.out.println("elf" + currentelf.toString() + " | " +  currentone);
                    currentelf++;
                    currentone = 0;
                }
            }
            System.out.println(alllist.entrySet());
            Integer highest = 0;
            Integer highest2 = 0;
            Integer highest3 = 0;
            String richestelf = "none";
            String richestelf2 = "none";
            String richestelf3 = "none";
            for (Map.Entry<String, Integer> value: alllist.entrySet()) {
                if (value.getValue() > highest) {
                    highest = value.getValue();
                    richestelf = value.getKey();
                } else if (value.getValue() > highest2 ) {
                    highest2 = value.getValue();
                    richestelf2 = value.getKey();
                } else if (value.getValue() > highest3) {
                    highest3 = value.getValue();
                    richestelf3 = value.getKey();
                }
            }
            System.out.println(" ");
            System.out.println("---");
            System.out.println(" ");
            System.out.println("1 " + richestelf + " " + highest);
            System.out.println("2 " + richestelf2 + " " + highest2);
            System.out.println("3 " + richestelf3 + " " + highest3);
            System.out.println("total top 3 = " + (highest3 + highest2 + highest));
        } finally {
            it.close();
        }
    }
}