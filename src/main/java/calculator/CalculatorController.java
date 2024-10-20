package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorController {
    private static final CalculatorView calculatorView = new CalculatorView();
    private static final List<Integer> nums = new ArrayList<>();
    private final Delimiters delimiters;
    private final StringChecker stringChecker;
    private String inputString;

    public CalculatorController(String inputString) {
        this.inputString = inputString;
        this.delimiters = new Delimiters();
        this.stringChecker = new StringChecker(inputString, delimiters);
        startCalculator();
    }

    private void startCalculator() {
        if (stringChecker.checkEmpty()) {
            calculatorView.printResult(0);
            return;
        }

        stringChecker.checkBoundary();
        inputString = stringChecker.checkCustomDelimiter();
        splitString(inputString);
        calculate();
    }

    private void splitString(String inputString) {
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

    private void calculate() {
        int sumResult = 0;
        for (int i : nums) {
            sumResult += i;
        }

        calculatorView.printResult(sumResult);
    }
}
