package be.lycoops.vincent.iv.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BaseStatsProvider {

    List<Integer> values = new ArrayList<>();

    private static String fileName = "stats.txt";

    private static final Pattern pattern = Pattern.compile("^(\\d+)");

    public BaseStatsProvider() {
        File file = new File(fileName);
        if (!file.exists() || !file.canRead()) {
            return;
        }

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> {
                Matcher m = pattern.matcher(line);
                if (m.find()){
                    values.add(Integer.parseInt(m.group(1)));
                }
            });
            return;
        } catch (IOException e) {
            return;
        }
    }

    public int getLvl() {
        return values.get(0);
    }

    public int getHp1() {
        return values.get(1);
    }

    public int getAtk1() {
        return values.get(2);
    }

    public int getDef1() {
        return values.get(3);
    }

    public int getSpa1() {
        return values.get(4);
    }

    public int getSpd1() {
        return values.get(5);
    }

    public int getSpe1() {
        return values.get(6);
    }

    public int getHp2() {
        return values.get(7);
    }

    public int getAtk2() {
        return values.get(8);
    }

    public int getDef2() {
        return values.get(9);
    }

    public int getSpa2() {
        return values.get(10);
    }

    public int getSpd2() {
        return values.get(11);
    }

    public int getSpe2() {
        return values.get(12);
    }
}
