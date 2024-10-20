package calculator.service;

import calculator.exception.ExceptionMessage;
import calculator.model.Calculator;

public class CalculatorService {
    public int calculate(String input) {
        validateInput(input);
        input = input.replace("\\n", "\n");
        Calculator calculator = new Calculator();
        if (input.isEmpty()) {
            calculator.setNumbers(new int[]{0});
        } else {
            String delimiters = "[,|:]";
            if (input.startsWith("//") && input.contains("\n")) {
                String[] split = input.split("\n", 2);
                delimiters = addCustomDelimiter(split, delimiters);
                input = split[1];
            }

            String[] splitInput = input.split(delimiters);
            int[] splitNum = new int[splitInput.length];

            for (int i = 0; i < splitInput.length; i++) {
                validateSplitString(splitInput, i);
                splitNum[i] = Integer.parseInt(splitInput[i]);
            }
            calculator.setNumbers(splitNum);
        }
        calculator.doSum();
        return calculator.getSum();
    }

    private static void validateInput(String input) {
        //공백 입력되면 예외발생
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT.getMessage());
        }
        //'0' 입력되면 예외발생
        if (input.contains("0")) {
            throw new IllegalArgumentException(ExceptionMessage.MINUS_OR_ZERO_INPUT.getMessage());
        }
    }

    private static String addCustomDelimiter(String[] split, String delimiters) {
        String customDelimiter = split[0].substring(2);
        // 커스텀 구분자에 숫자 or '-' 포함된 경우 예외 발생
        if (customDelimiter.matches(".*[\\d-].*")) {
            throw new IllegalArgumentException(ExceptionMessage.FORBIDDEN_WORDS_IN_DELIMITER.getMessage());
        }

        delimiters = "[" + delimiters.substring(1, 4) + "|" + customDelimiter + "]";
        return delimiters;
    }

    private static void validateSplitString(String[] splitInput, int i) {
        // 경계에 구분자가 있는지, 중복된 구분자인지 판단해서 예외 발생
        // 공백이 존재한다는 것은 구분자가 중복되어 split 할 때 ""값이 들어왔다는 뜻
        if (splitInput[i].isEmpty()) {
            if (i == 0 || i == splitInput.length - 1) {
                throw new IllegalArgumentException(ExceptionMessage.BOUNDARY_DELIMITER.getMessage());
            } else {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_DELIMITER.getMessage());
            }
        }

        // 숫자가 아닌 문자 들어왔을 때 예외 발생
        if (!splitInput[i].matches("-?\\d+")) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DELIMITER_OR_NUMBER.getMessage());
        }

        // 음수일 때 예외 발생
        if (Integer.parseInt(splitInput[i]) < 0) {
            throw new IllegalArgumentException(ExceptionMessage.MINUS_OR_ZERO_INPUT.getMessage());
        }
    }
}
