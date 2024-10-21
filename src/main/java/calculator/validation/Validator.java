package calculator.validation;

import java.math.BigInteger;

public class Validator {

    public Validator() {
    }

    public void numberListValidation(String[] numbers) {
        emptyCheck(numbers);

        for (String number : numbers) {
            onlyZeroCheck(number);
            positiveNumberCheck(number);
        }
    }

    private void emptyCheck(String[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("숫자가 없습니다.");
        }
    }

    private void positiveNumberCheck(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!(number.charAt(i) >= '0' && number.charAt(i) <= '9')) {
                throw new IllegalArgumentException("양수가 아니거나, 올바른 숫자가 아닙니다.");
            }
        }
    }

    private void onlyZeroCheck(String number) {
        if (number.length() == 1 && number.charAt(0) == '0') {
            throw new IllegalArgumentException("0값은 올 수 없습니다.");
        }
        if (duplicateZeroCheck(number)) {
            throw new IllegalArgumentException("0값은 올 수 없습니다.");
        }
    }

    private static boolean duplicateZeroCheck(String number) {
        return new BigInteger(number).equals(new BigInteger("0"));
    }
}
