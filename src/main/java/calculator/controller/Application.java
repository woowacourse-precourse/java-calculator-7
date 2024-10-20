package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

import java.util.List;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();

        String inputString = view.getInput().trim();

        processInput(inputString, model, view);
    }

    private static void addNumbersToModel(String[] numbers, CalculatorModel model) {
        for (String number : numbers) {
            model.validateNumber(number);
            model.addNumber(Integer.parseInt(number.trim()));
        }
    }

    public static String findDivider(String input) {
        if (input.startsWith("//")) {
            int lastLineIndex = input.indexOf("\\n");

            if (lastLineIndex != -1 && lastLineIndex > 2) {
                String divider = input.substring(2, lastLineIndex);
                return divider;
            }
        }
        return null;
    }

    public static String[] parseNumbers(String input, List<String> dividers) {
        // 구분자가 공백일 경우 "\\s+"로 처리
        if (dividers.contains(" ")) {
            dividers.remove(" ");
            return input.split("\\s+");
        }
        String combinedDividers = String.join("|", dividers);
        return input.split(combinedDividers);
    }

    private static void processInput(String inputString, CalculatorModel model, CalculatorView view) {
        if (inputString == null || inputString.trim().isEmpty()) {
            view.displayResult(0); // 공백 입력 시 0 출력
            return;
        }

        String customDivider = findDivider(inputString);

        if (customDivider != null) {
            model.addDivider(customDivider);
            String numberPart = inputString.substring(inputString.indexOf("\\n") + 2);
            String[] numbers = parseNumbers(numberPart, model.getDividers());
            addNumbersToModel(numbers, model);
        } else {
            String[] numbers = parseNumbers(inputString, model.getDividers());
            addNumbersToModel(numbers, model);
        }
        view.displayResult(model.sum());
    }
}
