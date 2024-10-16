package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static String cutomSeparatorStart = "//";
    static String cutomSeparatorEnd = "\\n";
    static String or = "|";
    static String numberRegex = "-?\\d+";

    public static void main(String[] args) {
        StringBuilder separatorRegex = new StringBuilder(",|:");
        String input = Console.readLine();

        if (input.substring(0, 2).equals(cutomSeparatorStart)) {
            if (input.contains(cutomSeparatorEnd)) {
                String customDelim = input.substring(2, input.indexOf(cutomSeparatorEnd));

                separatorRegex.append(or + customDelim);
            } else {
                // error
            }
            input = input.substring(input.indexOf(cutomSeparatorEnd) + cutomSeparatorEnd.length());
        }

        List<String> strs = Arrays.stream(input.split(separatorRegex.toString())).toList();
        List<Integer> numbers = new ArrayList<>();

        for (String s: strs) {
            if (s.isEmpty() || !s.matches(numberRegex)) {
                // error
            } else {
                numbers.add(Integer.parseInt(s));
            }
        }
        System.out.println(strs);

        System.out.println(numbers.stream().reduce(0, Integer::sum));
    }
}
