package calculator.service;

import calculator.exception.ExceptionMessage;
import calculator.model.Calculator;
import java.util.regex.Pattern;

public class CalculatorService {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String NEW_LINE = "\n";

    public int calculate(String input) {
        validateInput(input);
        input = input.replace("\\n", NEW_LINE);
        Calculator calculator = new Calculator();
        
        if (input.isEmpty()) {
            calculator.setNumbers(new int[]{0});
        } else {
            String delimiters = DEFAULT_DELIMITERS;

            if (input.startsWith("//") && input.contains(NEW_LINE)) {
                String[] split = input.split(NEW_LINE, 2);
                delimiters = addCustomDelimiter(split, DEFAULT_DELIMITERS);
                input = split[1];
            }

            //빈 문자열 포함해서 배열 반환
            String[] splitInput = input.split(delimiters, -1);
            //split한 문자열 검증
            validateSplitString(splitInput);

            int[] splitNum = new int[splitInput.length];

            for (int i = 0; i < splitInput.length; i++) {
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
    }

    private static String addCustomDelimiter(String[] split, String delimiters) {
        String customDelimiter = split[0].substring(2);

        // 커스텀 구분자에 숫자 or '-' 포함된 경우 예외 발생
        if (customDelimiter.matches(".*[\\d-].*")) {
            throw new IllegalArgumentException(ExceptionMessage.FORBIDDEN_WORDS_IN_DELIMITER.getMessage());
        }

        delimiters = delimiters + "|" + Pattern.quote(customDelimiter);
        return delimiters;
    }

    private static void validateSplitString(String[] splitInput) {
        // 빈 문자열이 있는지 확인
        for (int i = 0; i < splitInput.length; i++) {
            if (splitInput[i].isEmpty()) {

                // 첫 번째나 마지막에 구분자가 있을 때 예외 발생
                if (i == 0 || i == splitInput.length - 1) {
                    throw new IllegalArgumentException(ExceptionMessage.BOUNDARY_DELIMITER.getMessage());
                } else {
                    throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_DELIMITER.getMessage());
                }
            }

            // 숫자가 아닌 값이 있을 때 예외 발생
            if (!splitInput[i].matches("-?\\d+")) {
                throw new IllegalArgumentException(ExceptionMessage.NO_DELIMITER_OR_NUMBER.getMessage());
            }

            // 앞에 0이 붙은 유효하지 않은 숫자 예외 발생 (단일 0은 허용)
            if (splitInput[i].matches("0\\d+")) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT.getMessage());
            }

            // 음수나 0일 때 예외 발생
            if (Integer.parseInt(splitInput[i]) <= 0) {
                throw new IllegalArgumentException(ExceptionMessage.MINUS_OR_ZERO_INPUT.getMessage());
            }
        }
    }
}
