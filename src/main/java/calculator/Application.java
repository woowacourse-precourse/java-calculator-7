package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // //;\n1,2:3;4
        String delimiter = "[,:]";
        String customDelimiter = "";
        String input = Console.readLine();

        if (isCustom(input)) {
            int delimiterEndIndex = findDelimiterEndIndex(input);
            customDelimiter = findCustomDelimiter(input, delimiterEndIndex);
            input = findNumber(input, delimiterEndIndex);
        }

        String regex = delimiter.substring(0, delimiter.length() - 1) + customDelimiter + "]";
        System.out.println(regex);
        String[] inputs = input.split(regex);

        // //;\n1,2:"";4
        int sum = 0;
        for (String number : inputs) {
            number = number.trim();
            if (number.isEmpty() || number.equals("\"\"")) {
                sum += 0;
            }
            if(!number.isEmpty() && !number.equals("\"\"")){
                sum += Integer.parseInt(number);
            }
        }

        System.out.println(sum);

    }

    private static String findNumber(String input, int delimiterEndIndex) {
        input = input.substring(delimiterEndIndex + 2);
        return input;
    }

    private static String findCustomDelimiter(String input, int delimiterEndIndex) {
        String customDelimiter;
        customDelimiter = input.substring(2, delimiterEndIndex);
        return customDelimiter;
    }

    private static int findDelimiterEndIndex(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        return delimiterEndIndex;
    }

    private static boolean isCustom(String input) {
        return input.startsWith("//");
    }
}
