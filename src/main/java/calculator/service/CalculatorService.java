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
            if (input.startsWith("//")) {
                String[] split = input.split("\n", 2);
                String customDelimiter = split[0].substring(2);
                // 커스텀 구분자에 숫자가 포함된 경우 예외 발생
                if (customDelimiter.matches(".*\\d.*")) {
                    throw new IllegalArgumentException(ExceptionMessage.CONTAIN_NUMBER_IN_DELIMITER.getMessage());
                }
                delimiters = "[" + delimiters.substring(1, 4) + "|" + customDelimiter + "]";
                input = split[1];
            }

            String[] splitInput = input.split(delimiters);
            int[] splitNum = new int[splitInput.length];

            for (int i = 0; i < splitInput.length; i++) {
                validateDelimiter(splitInput, i);
                splitNum[i] = Integer.parseInt(splitInput[i]);
            }
            calculator.setNumbers(splitNum);
        }
        calculator.doSum();
        return calculator.getSum();
    }

    private static void validateDelimiter(String[] splitInput, int i) {
        if (splitInput[i].isEmpty()) {
            if (i == 0 || i == splitInput.length - 1) {
                throw new IllegalArgumentException(ExceptionMessage.BOUNDARY_DELIMITER.getMessage());
            } else {
                throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_DELIMITER.getMessage());
            }
        }
        //커스텀 구분자로 "-"가 들어올 수도 있기 때문에 음수는 여기서 판별함
        //int로 변환할 때 문자가 들어가 있으면 NumberFormatException 터지므로 이를 try-catch
        try {
            if (Integer.parseInt(splitInput[i]) < 0) {
                throw new IllegalArgumentException(ExceptionMessage.MINUS_OR_ZERO_INPUT.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DELIMITER.getMessage());
        }
    }

    private static void validateInput(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT.getMessage());
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException(ExceptionMessage.MINUS_OR_ZERO_INPUT.getMessage());
        }
    }
}
