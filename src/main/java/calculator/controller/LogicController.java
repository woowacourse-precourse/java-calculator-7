package calculator.controller;

import calculator.model.Answer;
import calculator.model.Numbers;
import calculator.validation.Validator;
import calculator.view.IOView;

import java.math.BigInteger;
import java.util.Arrays;

public class LogicController {
    private final Numbers numbers;
    private final Answer answer;
    private final IOView ioView;
    private final Validator validator;

    public LogicController(Numbers numbers, Answer answer, IOView ioView, Validator validator) {
        this.numbers = numbers;
        this.answer = answer;
        this.ioView = ioView;
        this.validator = validator;
    }

    public void inputData() {
        String input = ioView.getInput();

        String refinedInput = customDelimiterCheck(input);

        String[] splitNumbers = extractNumbers(refinedInput);

        numbers.setNumbers(splitNumbers);
    }

    private String customDelimiterCheck(String input) {
        boolean isDelimiterOpened = false;

        StringBuilder customDelimiterString = new StringBuilder();
        String refinedInput = input;

        for (int i = 0; i < input.length() - 1; i++) {
            if (!isDelimiterOpened) {
                if (input.startsWith("//", i)) {
                    isDelimiterOpened = true;
                    customDelimiterString = new StringBuilder("//");
                    i += 1;
                }
            } else {
                if (input.startsWith("\\n", i)) {
                    isDelimiterOpened = false;
                    customDelimiterString.append(input, i, i + 2);
                    refinedInput = refinedInput.replace(customDelimiterString, ":");
                    i += 1;
                } else {
                    customDelimiterString.append(input.charAt(i));

                }
            }
        }

        if (isDelimiterOpened) {
            throw new IllegalArgumentException("커스텀 구분자가 닫혀 있지 않습니다.");
        }

        return refinedInput;
    }

    private String[] extractNumbers(String rest) {
        String[] numbers = separateNumbers(rest);

        validator.numberListValidation(numbers);

        return numbers;
    }

    private String[] separateNumbers(String input) {
        return Arrays.stream(input.split("[:,]")).map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }

    public void calculateNumbers() {
        String[] savedNumbers = numbers.getNumbers();

        answer.setAnswer(savedNumbers[0]);
        for (int i = 1; i < savedNumbers.length; i++) {
            String nowNumber = savedNumbers[i];

            answer.setAnswer(new BigInteger(answer.getAnswer()).add(new BigInteger(nowNumber)).toString());
        }
    }

    public void printData() {
        ioView.printOutput(answer.getAnswer());
    }
}
