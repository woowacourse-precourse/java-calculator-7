package calculator.service;

import static calculator.exception.ErrorMessages.INCLUDES_NON_NUMERIC;
import static calculator.exception.ErrorMessages.NON_POSITIVE_NUMBER;

import calculator.domain.adder.NumberAdder;
import calculator.domain.parser.InputParser;
import calculator.domain.parser.InputParser.ParsedInput;
import calculator.domain.validator.InputValidator;

public class CalculatorService {

    private final InputParser inputParser;
    private final NumberAdder numberAdder;
    private final InputValidator inputValidator;

    public CalculatorService() {
        this.inputParser = new InputParser();
        this.numberAdder = new NumberAdder();
        this.inputValidator = new InputValidator();
    }

    /**
     * 입력 문자열을 계산합니다. 입력이 비어 있으면 "0"을 반환하고, 입력 값이 유효하지 않으면 예외를 발생시킵니다.
     *
     * @param input 사용자로부터 입력받은 문자열
     * @return 계산 결과를 문자열로 반환
     * @throws IllegalArgumentException 잘못된 입력 값이 포함된 경우 발생 (비숫자나 음수 포함)
     */
    public String calculate(String input) {
        if (inputValidator.checkInputEmpty(input)) {
            return "0";
        }

        final ParsedInput parsedInput = inputParser.parse(input);

        for (String numberToken : parsedInput.numbersToken()) {
            if (!inputValidator.isValidNumber(numberToken)) {
                throw new IllegalArgumentException(INCLUDES_NON_NUMERIC.getMessage());
            }
            if (inputValidator.isNonPositiveNumber(numberToken)) {
                throw new IllegalArgumentException(NON_POSITIVE_NUMBER.getMessage());
            }
        }

        return numberAdder.adder(parsedInput);
    }

}
