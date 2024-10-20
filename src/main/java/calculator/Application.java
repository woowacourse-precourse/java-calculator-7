package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String delimiters = ":,";

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        String validTarget = input;

        if (isCustomDelimiterDefined(input)) {
            delimiters = getCustomDelimiter(input);
            validTarget = input.substring(input.indexOf("\\n") + 2);
        }

        if (!isValidInput(validTarget, delimiters)) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }

        int sumResult = sumNumbers(validTarget, delimiters);

        System.out.println("결과 : " + sumResult);
    }

    private static boolean isValidInput(String validTarget, String delimiters) {
        if (validTarget.isBlank()) {
            return true;
        }

        String regex = "^\\d+(" + "[" + delimiters + "]" + "\\d+)*$";

        return validTarget.matches(regex);
    }

    private static boolean isCustomDelimiterDefined(String input) {
        return input.startsWith("//") && (input.indexOf("\\n") == input.indexOf("//") + 3);
    }

    private static String getCustomDelimiter(String input) {

        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\\n");

        String customDelimiter = input.substring(startIndex, endIndex);

        return customDelimiter;
    }

    private static int sumNumbers(String input, String delimiters) {
        String regDelimiters = "[" + delimiters + "]";
        String[] extractedNums = input.split(regDelimiters);

        int sum = 0;

        for (String num : extractedNums) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
