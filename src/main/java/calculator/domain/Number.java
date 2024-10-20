package calculator.domain;

import calculator.util.NumberValidator;

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
        if (NumberValidator.isNullString(numString)) {
            return;
        }

        numbers = new int[numString.length];
        for (int i = 0; i < numString.length; ++i) {
            numbers[i] = NumberValidator.parseAndValidateInt(numString[i]);
        }
    }

    public int calculateSum() {
        convertStringToInt(); // calculateSum() 메서드가 먼저 호출되면 numbers 에 아무 문자열이 없으므로 방지를 위해 내부에 선언

        if (!NumberValidator.isNullString(numString)) {
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
