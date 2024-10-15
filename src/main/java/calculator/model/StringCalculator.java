package calculator.model;

public class StringCalculator {

    // TODO 입력값이 유효 처리
    public int add(String input) {
        if (input != null || input.isEmpty()) {
            return 0;
        }
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            delimiter = parts[0].substring(2);
            input = parts[1];
        }

        String[] numbers = input.split(delimiter);
        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            try {
                total += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다 : " + number);
            }

        }
        return total;
    }
}
