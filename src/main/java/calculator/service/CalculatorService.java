package calculator.service;

import calculator.model.StringCalculator;
import calculator.model.StringParser;
import calculator.validator.InputValidator;
import java.util.List;

// 입력을 검증하고 파싱한 후 계산
public class CalculatorService {

    private final StringParser stringParser;
    private final StringCalculator stringCalculator;
    private final InputValidator inputValidator;

    public CalculatorService(StringParser stringParser, StringCalculator stringCalculator,
                             InputValidator inputValidator) {
        this.stringParser = stringParser;
        this.stringCalculator = stringCalculator;
        this.inputValidator = inputValidator;
    }

    // 계산
    public int calculate(String input) {
        validateInput(input);
        List<String> numbers = stringParser.parseInput(input);  // String[] 대신 List<String> 반환
        return stringCalculator.sumNumbers(numbers);  // 수정된 sumNumbers에 맞게 호출
    }

    // 입력 값 검증
    private void validateInput(String input) {
        inputValidator.validate(input);
    }

}