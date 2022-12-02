package me.racer.jjj;

import java.io.File;
import java.io.IOException;

import static me.racer.jjj.days.day2.day2;

public class Main {

    public static File datafolder = new File("src/main/java/me/racer/jjj/input");

    public static void main(String[] args) throws IOException {
        dayprompt();
    }

    public static void dayprompt() throws IOException {
        /**BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Enter an Integer between 1 and 24, based on which day you're interested in.");
         String input = reader.readLine();
         switch (input) {
         case "1" -> day1();
         case "2" -> day2();
         case "3" -> day3();
         default -> {
         System.out.println("\033[1;31mEnter a valid Input!\u001B[0m");
         dayprompt();
         }
         }**/
        day2();
    }
}