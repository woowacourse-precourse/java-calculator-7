package calculator;

import calculator.converter.Converter;
import calculator.model.PositiveNumbers;
import calculator.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static calculator.utils.CalculatorConstants.*;

public class Calculator {

    private static final String INPUT_STRING_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_RESULT_MESSAGE = "결과 : ";

    Converter converter;
    Validator validator;

    public Calculator() {
        this.converter = new Converter(DELIMITER_REGEX, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);
        this.validator = new Validator(DELIMITER_REGEX, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);
    }

    public void run() {
        String input = inputString();
        validator.validateDelimiter(input);
        List<Integer> integers = converter.convertNumbersFromString(input);
        PositiveNumbers positiveNumbers = PositiveNumbers.from(integers);
        printResult(positiveNumbers.calculateSum());
    }

    private String inputString() {
        System.out.println(INPUT_STRING_MESSAGE);
        return Console.readLine();
    }

    private void printResult(int result) {
        System.out.println(OUTPUT_RESULT_MESSAGE + result);
    }

}
