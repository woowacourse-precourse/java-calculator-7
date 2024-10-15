package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
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
            if (!isStringEmpty(number)) {
                sum += Integer.parseInt(number);
            }
        }

        System.out.println("결과 : " + sum);

    }

    private static boolean isStringEmpty(String number) {
        return number.isEmpty() || number.equals("\"\"");
    }

    private static String updateCustomDelimiter(String delimiter, String customDelimiter) {
        return delimiter.substring(0, delimiter.length() - 1) + customDelimiter + "]";
    }

    private static String findNumber(String input, int delimiterEndIndex) {
        return input.substring(delimiterEndIndex + 2);
    }

    private static String findCustomDelimiter(String input, int delimiterEndIndex) {
        return input.substring(2, delimiterEndIndex);
    }

    private static int findDelimiterEndIndex(String input) {
        return input.indexOf("\\n");
    }

    private static boolean isCustom(String input) {
        return input.startsWith("//");
    }
}
