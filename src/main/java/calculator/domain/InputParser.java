package calculator.domain;

import static calculator.global.exception.ErrorMessage.EMPTY_INPUT;

import calculator.global.exception.CalculatorException;

public class InputParser {
    private String delimiterString;
    private String inputString;

    /*"\\n"을 기준으로 구분자 설정 입력과 문자열 입력을 나눠주는 메서드
     * 빈 값이 들어오는 경우 예외 처리
     * "\\n"이 포함되지 않는 경우 구분자 빈 값으로 저장*/
    public void parse(String input) {
        validateInput(input);
        String[] parts = input.split("\\\\n", 2);
        if (parts.length == 2) {
            delimiterString = parts[0];
            inputString = parts[1];
        } else {
            delimiterString = "";
            inputString = input;
        }
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw CalculatorException.of(EMPTY_INPUT);
        }
    }

    public String getDelimiterString() {
        return delimiterString;
    }

    public String getInputString() {
        return inputString;
    }
}
