package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static String cutomDelimStart = "//";
    static String cutomDelimEnd = "\\n";
    static String regexDelim = "|";

    public static void main(String[] args) {
        StringBuilder regex = new StringBuilder(",|:");
        String input = Console.readLine();

        if (input.substring(0, 2).equals(cutomDelimStart)) {
            if (input.contains(cutomDelimEnd)) {
                String customDelim = input.substring(2, input.indexOf(cutomDelimEnd));

                regex.append(regexDelim + customDelim);
            } else {
                // error
            }
            input = input.substring(input.indexOf(cutomDelimEnd) + cutomDelimEnd.length());
        }

        List<String> strs = Arrays.stream(input.split(regex.toString()))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(strs);
    }
}
