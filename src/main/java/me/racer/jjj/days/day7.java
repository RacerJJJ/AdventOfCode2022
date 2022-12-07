package me.racer.jjj.days;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class day7 {
    public static void day7(File input) throws IOException {
        Integer part1 = 0;
        Integer part2 = 0;
        Integer totalusedspace = 0;
        String currentpath = null;
        Integer currentsize = 0;
        Integer paths = 0;
        Boolean isList = false;
        ArrayList<String> currentsubdirs = new ArrayList<>();
        HashMap<String, Integer> dirlist = new HashMap<>();
        HashMap<String, ArrayList<String>> subdirs = new HashMap<>();
        try (LineIterator it = FileUtils.lineIterator(input, "UTF-8")) {
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] substring = line.split(" ");
                if (line.startsWith("$")) {
                    if ("ls".equals(substring[1])) {
                        isList = true;
                    }
                    if ("cd".equals(substring[1])) {
                        if (currentpath != null && isList) {
                            dirlist.put(currentpath, currentsize);
                            subdirs.put(currentpath, (ArrayList<String>) currentsubdirs.clone());
                            currentsubdirs.clear();
                            currentsize = 0;
                            isList = false;
                        }
                        switch (substring[2]) {
                            case ".." -> {
                                String[] splitted = currentpath.split("/");
                                if (splitted.length != 0) {
                                    currentpath = currentpath.replace("/" + splitted[splitted.length - 1], "");
                                }

                            }
                            case "/" -> currentpath = "/";
                            default -> {
                                if (currentpath.endsWith("/")) {
                                    currentpath = currentpath + substring[2];
                                    if (currentpath.split("/").length > paths) {
                                        paths = currentpath.split("/").length;
                                    }
                                } else {
                                    currentpath = currentpath + "/" + substring[2];
                                    if (currentpath.split("/").length > paths) {
                                        paths = currentpath.split("/").length;
                                    }
                                }
                            }
                        }
                    }

                } else if (!line.isEmpty()) {
                    if (substring[0].equalsIgnoreCase("dir")) {
                        if (currentpath.endsWith("/")) {
                            currentsubdirs.add(currentpath + substring[1]);
                        } else {
                            currentsubdirs.add(currentpath + "/" + substring[1]);
                        }

                    } else {
                        currentsize += Integer.parseInt(substring[0]);
                        totalusedspace += Integer.parseInt(substring[0]);
                    }
                }
            }
            for (Integer e = 0; e <= paths; e++) {
                for (Map.Entry<String, Integer> data : dirlist.entrySet()) {
                    Integer datavalue = dirlist.get(data.getKey());
                    if (data.getKey().split("/").length == (paths - e)) {
                        for (String subdir : subdirs.get(data.getKey())) {
                            try {
                                datavalue += dirlist.get(subdir);
                            } catch (NullPointerException ignored) {
                            }
                        }
                        dirlist.replace(data.getKey(), datavalue);
                    }
                }
            }

            Integer totalsum = 0;
            for (Integer value : dirlist.values()) {
                if (value <= 100000) {
                    totalsum += value;
                }
            }


            Integer neededspace = 30000000 - (70000000 - totalusedspace);

            Integer amounttodelete = 70000000;
            for (Integer cvalue : dirlist.values()) {
                System.out.println(cvalue);
                if (cvalue >= neededspace && cvalue < amounttodelete) {
                    amounttodelete = cvalue;
                }

            }

            System.out.println("Part 1: " + totalsum);
            System.out.println("Part 2: " + amounttodelete);

        }
    }
}
