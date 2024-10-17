package calculator.models;

public class NumberModel {
    private static final String ERROR_MSG = "계산 가능한 범위의 숫자가 아닙니다.";

    public static int addNumbers(String input, String regex) {
        String[] numbers = input.split(regex);

        try {
            return getArraySum(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MSG);
        }
    }

    private static int getArraySum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            int value = number.isEmpty() ? 0 : Integer.parseInt(number);
            sum += value;
        }

        return sum;
    }
}
