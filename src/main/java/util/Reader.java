package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {

    public static List<String> dataSearch(String fileName) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        List<String> data = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)
                    .length() == 0) {
                list.remove(i);
            }
        }
        for (String e : list) {
            data.addAll(Arrays.asList(
                    e.trim()
                            .replace("\"", "")
                            .split("[\\.,]+")));
        }
        System.out.println("Number of line is: " + data.size());
        return data;
    }
}
