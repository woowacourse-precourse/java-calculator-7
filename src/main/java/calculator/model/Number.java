package calculator.model;

public class Number {
    private String[] numString;
    private int[] numbers;
    private int sum;

    public Number(String[] numString) {
        this.numString = numString;
        this.sum = 0;
    }

    private boolean isNullString() {
        return numString == null || numString.length == 0;
    }

    public void convertStringToInt() {
        if (isNullString()) {
            return;
        }

        numbers = new int[numString.length];
        for (int i = 0; i < numString.length; ++i) {
            numbers[i] = isPositiveInt(numString[i]);
        }
    }

    public int isPositiveInt(String tmpString) {
        try {
            int number = Integer.parseInt(tmpString);
            if (number < 1) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자 이외에 숫자만 입력가능합니다.");
        }
    }

    public int calculateSum() {
        convertStringToInt(); // calculateSum() 메서드가 먼저 호출되면 numbers 에 아무 문자열이 없으므로 방지를 위해 내부에 선언

        if (isNullString()) {
            return sum;
        }

        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public int[] getNumbers() {
        return numbers;
    }
}
