package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static String findCustomDelimiter(String input) {
        int startIndex;
        int endIndex;

        if (input.contains("//") && input.contains("\\n")) {
            startIndex = input.indexOf("//") + 2;
            endIndex = input.indexOf("\\n");
            if (startIndex == endIndex) {
                throw new IllegalArgumentException("구분자를 입력해주세요.");
            }
            return input.substring(startIndex, endIndex);
        }
        return "";
    }

    public static int add(String[] nums) {
        int sum = 0;

        for (String num : nums) {
            sum += parseNumber(num);
        }
        return sum;
    }

    private static int parseNumber(String num) {
        int value;

        try {
            value = Integer.parseInt(num);
            checkForNonPositiveValue(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자와 양수 값만 입력 가능합니다: " + num);
        }
        return value;
    }

    private static void checkForNonPositiveValue(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("양수 값만 입력 가능합니다: " + value);
        }
    }

    public static int calculator(String input) {
        String[] nums;
        String delimiters;
        String customDelimiter;
        String numString;

        numString = input;
        customDelimiter = findCustomDelimiter(input);
        delimiters = "[,:|" + customDelimiter + "]";

        if (!customDelimiter.isEmpty()) {
            numString = input.substring(input.indexOf("\\n") + 2);
        }
        nums = numString.split(delimiters);
        return add(nums);
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input;
        int result = 0;

        input = Console.readLine();
        if (!input.isEmpty()) {
            result = calculator(input);
        }
        System.out.println("결과 : " + result);
    }
}