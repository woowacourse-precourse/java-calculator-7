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

        String regex = updateCustomDelimiter(delimiter, customDelimiter);
        String[] inputs = input.split(regex);

        int sum = 0;
        for (String number : inputs) {
            number = number.trim();
            if (isStringEmpty(number)) {
                sum += 0;
            }
            if(!isStringEmpty(number)){
                sum += Integer.parseInt(number);
            }
        }

        System.out.println(sum);

    }

    private static boolean isStringEmpty(String number) {
        return number.isEmpty() || number.equals("\"\"");
    }

    private static String updateCustomDelimiter(String delimiter, String customDelimiter) {
        return delimiter.substring(0, delimiter.length() - 1) + customDelimiter + "]";
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
