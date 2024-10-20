package calculator;

public class StringCalculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Delimiter delimiter = new Delimiter(input);
        StringParser parser = new StringParser(delimiter);
        String[] numbers = parser.parse(input);

        int sum = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
            }
            sum += num;
        }
        return sum;
    }
}
