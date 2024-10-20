package calculator.model;

public class CalculatorModel {
    public int add(String[] numbers) {
        int sum = 0;

        if (numbers == null) {
            return sum;
        }

        for (String number : numbers) {
            int num = Integer.parseInt(number);

            if (num <= 0) {
                throw new IllegalArgumentException("양수를 입력해 주세요.");
            }

            sum += num;
        }

        return sum;
    }
}