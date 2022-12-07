package me.racer.jjj.days;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static me.racer.jjj.Main.datafolder;

public class day5 {

    private static ArrayList<Character> primarystack1 = new ArrayList<>();
    private static ArrayList<Character> primarystack2 = new ArrayList<>();
    private static ArrayList<Character> primarystack3 = new ArrayList<>();
    private static ArrayList<Character> primarystack4 = new ArrayList<>();
    private static ArrayList<Character> primarystack5 = new ArrayList<>();
    private static ArrayList<Character> primarystack6 = new ArrayList<>();
    private static ArrayList<Character> primarystack7 = new ArrayList<>();
    private static ArrayList<Character> primarystack8 = new ArrayList<>();
    private static ArrayList<Character> primarystack9 = new ArrayList<>();

    private static ArrayList<Character> secondarystack1 = new ArrayList<>();
    private static ArrayList<Character> secondarystack2 = new ArrayList<>();
    private static ArrayList<Character> secondarystack3 = new ArrayList<>();
    private static ArrayList<Character> secondarystack4 = new ArrayList<>();
    private static ArrayList<Character> secondarystack5 = new ArrayList<>();
    private static ArrayList<Character> secondarystack6 = new ArrayList<>();
    private static ArrayList<Character> secondarystack7 = new ArrayList<>();
    private static ArrayList<Character> secondarystack8 = new ArrayList<>();
    private static ArrayList<Character> secondarystack9 = new ArrayList<>();

    public static void day5(File input) throws IOException {

        try (LineIterator it = FileUtils.lineIterator(input, "UTF-8")) {
            while (it.hasNext()) {
                String line = it.nextLine();
                if (line.isEmpty() || line.charAt(1) == '1') {
                    continue;
                }
                if (!line.startsWith("move")) {
                    if (line.charAt(1) != ' ') {
                        primarystack1.add(primarystack1.size(), line.charAt(1));
                        secondarystack1.add(secondarystack1.size(), line.charAt(1));
                    }
                    if (line.charAt(5) != ' ') {
                        primarystack2.add(primarystack2.size(), line.charAt(5));
                        secondarystack2.add(secondarystack2.size(), line.charAt(5));
                    }
                    if (line.charAt(9) != ' ') {
                        primarystack3.add(primarystack3.size(), line.charAt(9));
                        secondarystack3.add(secondarystack3.size(), line.charAt(9));
                    }
                    if (line.charAt(13) != ' ') {
                        primarystack4.add(primarystack4.size(), line.charAt(13));
                        secondarystack4.add(secondarystack4.size(), line.charAt(13));
                    }
                    if (line.charAt(17) != ' ') {
                        primarystack5.add(primarystack5.size(), line.charAt(17));
                        secondarystack5.add(secondarystack5.size(), line.charAt(17));
                    }
                    if (line.charAt(21) != ' ') {
                        primarystack6.add(primarystack6.size(), line.charAt(21));
                        secondarystack6.add(secondarystack6.size(), line.charAt(21));
                    }
                    if (line.charAt(25) != ' ') {
                        primarystack7.add(primarystack7.size(), line.charAt(25));
                        secondarystack7.add(secondarystack7.size(), line.charAt(25));
                    }
                    if (line.charAt(29) != ' ') {
                        primarystack8.add(primarystack8.size(), line.charAt(29));
                        secondarystack8.add(secondarystack8.size(), line.charAt(29));
                    }
                    if (line.charAt(33) != ' ') {
                        primarystack9.add(primarystack9.size(), line.charAt(33));
                        secondarystack9.add(secondarystack9.size(), line.charAt(33));
                    }
                } else {
                    String[] movement = line.split(" ");
                    ArrayList<Character> from1 = getPrimaryArray(movement[3]);
                    ArrayList<Character> to1 = getPrimaryArray(movement[5]);
                    ArrayList<Character> from2 = getSecondaryArray(movement[3]);
                    ArrayList<Character> to2 = getSecondaryArray(movement[5]);
                    for (int i = 0; i < Integer.parseInt(movement[1]); ++i) {
                        to1.add(0, from1.get(0));
                        to2.add(i, from2.get(0));
                        from1.remove(0);
                        from2.remove(0);
                    }

                }


            }
        } finally {
            String[] finals = {"1","2","3","4","5","6","7","8","9"};
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String s: finals) {
                sb1.append(getPrimaryArray(s).get(0));
                sb2.append(getSecondaryArray(s).get(0));
            }

            System.out.println("Part 1: " + sb1);
            System.out.println("Part 2: " + sb2);
        }
    }

    private static ArrayList<Character> getPrimaryArray(String row) {
        return getCharacters(row, primarystack1, primarystack2, primarystack3, primarystack4, primarystack5, primarystack6, primarystack7, primarystack8, primarystack9);
    }
    private static ArrayList<Character> getSecondaryArray(String row) {
        return getCharacters(row, secondarystack1, secondarystack2, secondarystack3, secondarystack4, secondarystack5, secondarystack6, secondarystack7, secondarystack8, secondarystack9);
    }

    private static ArrayList<Character> getCharacters(String row, ArrayList<Character> stack1, ArrayList<Character> stack2, ArrayList<Character> stack3, ArrayList<Character> stack4, ArrayList<Character> stack5, ArrayList<Character> stack6, ArrayList<Character> stack7, ArrayList<Character> stack8, ArrayList<Character> stack9) {
        switch (row) {
            case "1" -> {
                return stack1;
            }
            case "2" -> {
                return stack2;
            }
            case "3" -> {
                return stack3;
            }
            case "4" -> {
                return stack4;
            }
            case "5" -> {
                return stack5;
            }
            case "6" -> {
                return stack6;
            }
            case "7" -> {
                return stack7;
            }
            case "8" -> {
                return stack8;
            }
            case "9" -> {
                return stack9;
            }
            default -> {
                return null;
            }
        }
    }
}
