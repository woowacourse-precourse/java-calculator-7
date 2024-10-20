package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

import java.util.List;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();

        String[] numbers;
        String inputString = view.getInput().trim();
        String customDivider = findDivider(inputString);

        if (inputString.isEmpty()) {
            view.displayResult(0); // 0을 출력
            return; // 프로그램 종료
        }

        if (customDivider != null) {
            model.addDivider(customDivider);
        }

        if (customDivider != null) {
            numbers = parseNumbers(inputString.substring(inputString.indexOf("\\n") + 2), model.getDividers());
        } else {
            numbers = parseNumbers(inputString, model.getDividers());
        }
//        System.out.println("numbers >> "+Arrays.toString(numbers));

        for (String number : numbers) {
//            System.out.println("number >> " + number);
            model.validateNumber(number);
            model.addNumber(Integer.parseInt((number.trim())));
        }
        view.displayResult(model.sum());
    }

    public static String findDivider(String input) {
        if (input.startsWith("//")) {
            int lastLineIndex = input.indexOf("\\n");

            if (lastLineIndex != -1 && lastLineIndex > 2) {
//                System.out.println("findDivider >>" + input.substring(2, lastLineIndex) );
                return input.substring(2, lastLineIndex);
            }
        }
//        System.out.println("findDivider null >>" );
        return null;
    }

    public static String[] parseNumbers(String input, List<String> dividers) {
        String combinedDividers = String.join("|", dividers);
        return input.split(combinedDividers);
    }
}
