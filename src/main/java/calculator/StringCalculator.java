package calculator;

import static calculator.global.constant.IoFormatConstants.INPUT_PROMPT_FORMAT;
import static calculator.global.constant.IoFormatConstants.OUTPUT_PROMPT_FORMAT;

import calculator.utils.InputParserUtil;
import calculator.validation.NumberValidator;
import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    private static final int DEFAULT_RESULT = 0;

    private final InputParserUtil inputParserUtil;
    private final NumberValidator numberValidator;

    public StringCalculator(InputParserUtil inputParserUtil, NumberValidator numberValidator) {
        this.inputParserUtil = inputParserUtil;
        this.numberValidator = numberValidator;
    }

    public void stringPlusCalculator() {
        System.out.println(INPUT_PROMPT_FORMAT);
        String userInput = Console.readLine();

        if (userInput.isEmpty()) {
            System.out.println(OUTPUT_PROMPT_FORMAT + DEFAULT_RESULT);
            return;
        }

        System.out.println(userInput);

        String[] numberList = inputParserUtil.seperator(userInput);

        numberValidator.validateNumbers(numberList);
        int[] validNumbers = convertToNumbers(numberList);
        int result = calculateSum(validNumbers);

        System.out.println(OUTPUT_PROMPT_FORMAT + result);
    }


    private int[] convertToNumbers(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }


    private int calculateSum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
