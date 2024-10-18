package calculator;

import static calculator.constants.*;

public class StringCalculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return ZERO;
        }
        return sumString(splitString(input));
    }

    public String[] splitString(String input) {
        String div_words = default_words;

        if (input.startsWith(prefix_custom) && input.contains(postfix_custom)) {
            String custom_words = input.substring(start_idx, end_idx);
            input = input.substring(number_idx);
            div_words = custom_words;
        }
        return input.split(div_words);
    }

    private int sumString(String[] numbers) {
        int sum = ZERO;
        for (int i = ZERO; i < numbers.length; i++) {
            checkException(numbers[i]);
            int num = Integer.parseInt(numbers[i]);
            sum += num;
        }
        return sum;
    }

    private void checkException(String input) {
        if (input.contains(minus_Check) || !number_Range.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }
}
