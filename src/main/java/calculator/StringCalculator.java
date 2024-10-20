package calculator;

public class StringCalculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (input.matches("\\d+")) {
            return Integer.parseInt(input);
        }

        // 쉼표 또는 콜론으로 구분하여 숫자 합산
        String[] numbers = input.split("[,|:]");
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
