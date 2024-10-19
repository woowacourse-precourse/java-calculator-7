package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {
    private static final CalculatorView calculatorView = new CalculatorView();
    private static List<Integer> nums = new ArrayList<>();
    private static List<Character> delimiters = new ArrayList<>(List.of(',', ':'));

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

}
