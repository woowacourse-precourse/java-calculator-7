package calculator.model;

import calculator.util.MessageSource;
import calculator.util.ValidatorUtil;

public class CalculatorImpl implements Calculator {

    private final ExtractNumber extractNumber;
    private final MessageSource messageSource;

    public CalculatorImpl(ExtractNumber extractNumber, MessageSource messageSource) {
        this.extractNumber = extractNumber;
        this.messageSource = messageSource;
    }

    @Override
    public int calculate(String input) {

        if (ValidatorUtil.isEmptyInput(input)) {
            return 0;
        }

        String[] numbers = extractNumber.extractNumberFromInput(input);

        return sum(numbers);
    }

    private int sum(String[] extractNumbers) {

        int total = 0;

        for (String extractNumber : extractNumbers) {
            try {

                int number = Integer.parseInt(extractNumber);

                if (ValidatorUtil.isNegativeNumber(number)) {
                    throw new IllegalArgumentException(messageSource.getMessage("error.negative_number"));
                }

                total += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(messageSource.getMessage("error.invalid_number_format"));
            }
        }

        return total;
    }
}
