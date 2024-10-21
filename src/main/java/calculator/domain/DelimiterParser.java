package calculator.domain;

import static calculator.global.exception.ErrorMessage.EMPTY_CUSTOM_DELIMITER;
import static calculator.global.exception.ErrorMessage.INVALID_DELIMITER_START;

import calculator.global.exception.CalculatorException;

public class DelimiterParser {
    private String delimiter;

    public DelimiterParser() {
        this.delimiter = ",|:";
    }

    //   새로운 구분자 설정
    /*결과적으로 "//"로 시작하지 않는 경우 , "//"로 시작하더라도 구분자가 없는 경우*/
    public String parse(String input) {
        validateCustomDelimiterInput(input);
        String customDelimiter = extractCustomDelimiter(input);
        this.delimiter = customDelimiter;
        return customDelimiter;
    }

    //    입력된 구분자 형식 검사 ("//"로 시작 + "//" 제외 문자가 있는지 확인)
    private void validateCustomDelimiterInput(String input) {
        if (!input.startsWith("//")) {
            throw CalculatorException.of(INVALID_DELIMITER_START);
        }
        if (input.length() == 2) {
            throw CalculatorException.of(EMPTY_CUSTOM_DELIMITER);
        }
    }

    //    입력에서 구분자 추출
    private String extractCustomDelimiter(String input) {
        return input.substring(2);
    }

    public String getDelimiter() {
        return delimiter;
    }
}
