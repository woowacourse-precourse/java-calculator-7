package calculator.converter;

import calculator.exception.ExceptionMessage;

public class NumberConverterImpl implements NumberConverter {

    @Override
    public int[] convert(String[] stringArr) {
        int[] numberArr = new int[stringArr.length];

        for (int i = 0; i < stringArr.length; i++) {
            try {
                if (stringArr[i].isEmpty()) {
                    numberArr[i] = 0;
                    continue;
                }
                int number = Integer.parseInt(stringArr[i]);
                if (number <= 0) {
                    throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_NUMBER.getMessage() + stringArr[i]);
                }
                numberArr[i] = number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_FORMAT.getMessage() + stringArr[i]
                );
            }
        }
        return numberArr;
    }
}
