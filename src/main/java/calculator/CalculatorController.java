package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorController {
    private static final CalculatorView calculatorView = new CalculatorView();
    private static final List<Integer> nums = new ArrayList<>();
    private static final Delimiters delimiters = new Delimiters();

    public static void run() {
        startCalculator();
    }

    private static void startCalculator() {
        String inputString = calculatorView.readString();

        if (inputString.startsWith("//")) {
            inputString = checkCustomDelimiter(inputString);
        }

        checkString(inputString);
        calculate();
    }

    private static void checkString(String inputString) {
        if (inputString.isEmpty()) {
            calculatorView.printResult(0);
            return;
        }

        if (delimiters.getDelimiters().stream().anyMatch(d -> inputString.startsWith(String.valueOf(d))) ||
                delimiters.getDelimiters().stream().anyMatch(d -> inputString.endsWith(String.valueOf(d)))) {
            throw new IllegalArgumentException("문자열을 잘못 입력하였습니다.");
        }

        splitString(inputString);
    }

    private static String checkCustomDelimiter(String inputString) {
        String prefix = inputString.substring(0, 2);
        String suffix = inputString.substring(3, 5);

        if (prefix.equals("//") && suffix.equals("\\n")) {
            delimiters.addDelimiter(inputString.substring(2, 3));
            return inputString.substring(5);
        }

        throw new IllegalArgumentException("커스텀 문자열을 잘못 입력하였습니다.");
    }

    private static void splitString(String inputString) {
        String regex = "[" + delimiters.getDelimiters().stream()
                .map(String::valueOf)
                .collect(Collectors.joining()) + "]";

        String[] splitString = inputString.split(regex);

        for (String part : splitString) {
            if (!part.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException("구분자를 잘못 입력하였습니다.");
            }
            nums.add(Integer.parseInt(part));
        }
    }

    private static void calculate() {
        int sumResult = 0;
        for (int i : nums) {
            sumResult += i;
        }

        calculatorView.printResult(sumResult);
    }
}
