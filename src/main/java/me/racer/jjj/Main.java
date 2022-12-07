package me.racer.jjj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static me.racer.jjj.days.day1.day1;
import static me.racer.jjj.days.day2.day2;
import static me.racer.jjj.days.day3.day3;
import static me.racer.jjj.days.day4.day4;
import static me.racer.jjj.days.day5.day5;
import static me.racer.jjj.days.day6.day6;
import static me.racer.jjj.days.day7.day7;

public class Main {

    public static File datafolder = new File("src/main/java/me/racer/jjj/input");

    public static void main(String[] args) throws IOException {
        dayprompt();
    }

    public static void dayprompt() throws IOException {
         /**BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Enter an Integer between 1 and 24, based on which day you're interested in.");
         String day = reader.readLine();
         File dataset = new File(datafolder, "data" + day + ".txt");**/


         /**ArrayList<String> validanswers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"));
         if (!(validanswers.contains(day))) {
             System.out.println("\033[1;31mEnter a valid Input!\u001B[0m");
             dayprompt();
             return;
         }
         System.out.println("Enter a dataset or answer with \"default\".");
         String data = reader.readLine();
         File dataset = null;
         if (data.equalsIgnoreCase("default")) {
             dataset = new File(datafolder, "data" + day + ".txt");
         }
         else if (data.length() != 0) {
             dataset = File.createTempFile("data",".txt");
             dataset.setWritable(true);
             BufferedWriter bw = new BufferedWriter(new FileWriter(dataset));
             bw.write(data);
             bw.flush();
         }**/


         /**switch (day) {
            case "1" -> day1(dataset);
            case "2" -> day2(dataset);
            case "3" -> day3(dataset);
            case "4" -> day4(dataset);
            case "5" -> day5(dataset);
            case "6" -> day6(dataset);
            default -> {
                System.out.println("\033[1;31mEnter a valid Input!\u001B[0m");
                dayprompt();
                return;
            }**/
        day7(new File(datafolder, "data7.txt"));
    }
}