package calculator.domain;

import calculator.exception.NumberException;
import calculator.validator.EmptyStringValidator;

public class Number {
    private String[] numString;
    private int[] numbers;
    private int sum;

    public Number(String[] numString) {
        this.numString = numString;
        this.numbers = new int[]{};
        this.sum = 0;
    }

    public void convertStringToInt() {
        if (EmptyStringValidator.isEmptyString(numString)) {
            return;
        }

        numbers = new int[numString.length];
        for (int i = 0; i < numString.length; ++i) {
            numbers[i] = NumberException.parseAndValidateInt(numString[i]);
        }
    }

    public int calculateSum() {
        convertStringToInt();

        if (!EmptyStringValidator.isEmptyString(numString)) {
            for (int num : numbers) {
                sum += num;
            }
        }
        return sum;
    }

    public int[] getNumbers() {
        return numbers;
    }
}
