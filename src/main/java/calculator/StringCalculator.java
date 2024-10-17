package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int ZERO = 0;
    private static final String default_words = ",|:";
    private static final Pattern number_Range = Pattern.compile("^[1-9]*$");
    private static final String prefix_custom = "//";
    private static final String postfix_custom = "\\n";
    private static final int custom_start_idx = 2;
    private static final int custom_end_idx = 3;
    private static final int number_idx = 5;

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return ZERO;
        }
        return sumString(splitString(input));
    }

    public String[] splitString(String input) {
        String div_words = default_words;

        if (input.startsWith(prefix_custom) && input.contains(postfix_custom)) {
            String custom_words = input.substring(custom_start_idx, custom_end_idx);
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
        if (input.contains("-") || !number_Range.matcher(input).matches()) {
            throw new IllegalArgumentException(Application.ErrorMessage);
        }
    }
}
