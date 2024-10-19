package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    private static final CalculatorView calculatorView = new CalculatorView();
    private static List<Integer> nums = new ArrayList<>();
    private static final List<Character> delimiters = new ArrayList<>(List.of(',', ':'));

    public static void run() {
        startCalculator();
    }

    private static void startCalculator() {
        String inputString = calculatorView.readString();

        if (inputString.startsWith("//")) {
            inputString = checkCustomDelimiter(inputString);
        }

        checkString(inputString);
    }

    private static void checkString(String inputString) {
        if (delimiters.stream().anyMatch(d -> inputString.startsWith(String.valueOf(d))) ||
                delimiters.stream().anyMatch(d -> inputString.endsWith(String.valueOf(d)))) {
            throw new IllegalArgumentException("문자열을 잘못 입력하였습니다.");
        }
    }

    private static String checkCustomDelimiter(String inputString) {
        String prefix = inputString.substring(0, 2);
        String suffix = inputString.substring(3, 5);
        int len = inputString.length();

        if (prefix.equals("//") && suffix.equals("\\n")) {
            delimiters.add(inputString.charAt(2));
            return inputString.substring(5);
        }

        throw new IllegalArgumentException("커스텀 문자열을 잘못 입력하였습니다.");
    }

}
