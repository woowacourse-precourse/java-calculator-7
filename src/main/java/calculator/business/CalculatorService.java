package calculator.business;

import static calculator.common.Constant.COMMON_DELIMITER;
import static calculator.common.Constant.CUSTOM_DELIMITER;
import static calculator.common.Constant.END_CUSTOM_DELIMITER;
import static calculator.common.Constant.MINIMUM_ALLOWED_NUMBER;
import static calculator.common.Constant.START_CALCULATOR_STRING;
import static calculator.common.Constant.START_CUSTOM_DELIMITER;
import static calculator.common.Constant.START_REPEAT_NUMBER;

import calculator.business.dto.CalculatorInputDTO;
import calculator.business.dto.CalculatorOutputDTO;

public class CalculatorService {
    private String delimiter;


    public CalculatorOutputDTO run(CalculatorInputDTO calculatorInputDTO) {
        String inputWithoutDelimiter = selectCalculateMode(calculatorInputDTO.getInput());
        int[] numbers = convertStringToInt(inputWithoutDelimiter);
        return new CalculatorOutputDTO(calculate(numbers));
    }

    private int calculate(int[] numbers) {
        int sum = START_REPEAT_NUMBER;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private int[] convertStringToInt(String input) {
        String[] inputString = input.split(delimiter);
        int[] numbers = new int[inputString.length];

        for (int i = START_REPEAT_NUMBER; i < inputString.length; i++) {

            int parsedNumber;
            try {
                parsedNumber = Integer.parseInt(inputString[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            if (parsedNumber < MINIMUM_ALLOWED_NUMBER) {
                throw new IllegalArgumentException();
            }

            numbers[i] = parsedNumber;
        }

        return numbers;
    }

    private String selectCalculateMode(String input) {

        if (input.startsWith(CUSTOM_DELIMITER)) {
            delimiter = input.substring(START_CUSTOM_DELIMITER, END_CUSTOM_DELIMITER);
            input = input.substring(START_CALCULATOR_STRING);
        } else {
            delimiter = COMMON_DELIMITER;
        }

        return input;
    }

}
