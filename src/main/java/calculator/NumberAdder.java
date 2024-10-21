package calculator;

public class NumberAdder {
    public long add(String[] numbers) {
        long sum = 0L;
        for (String number : numbers) {
            long parsedNumber = parseNumber(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: " + parsedNumber);
            }
            sum += parsedNumber;
        }
        return sum;
    }

    private long parseNumber(String number) {
        if (!number.matches("-?\\d+")) {
            throw new IllegalArgumentException("Invalid input: " + number);
        }
        return Long.parseLong(number);
    }
}
