package calculator;

public class StringSumCalculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(",|:");

        int sum = 0;
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number.trim());
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수 불가");
            }
            sum += parsedNumber;
        }
        return sum;
    }

}
