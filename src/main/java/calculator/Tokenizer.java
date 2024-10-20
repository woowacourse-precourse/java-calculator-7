package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private int[] tokens;

    public Tokenizer(String input) throws IllegalArgumentException {
        tokens = tokenize(input);
    }

    public int[] toArray() {
        return tokens;
    }

    private int[] tokenize(String input) throws IllegalArgumentException {
        StringBuilder delimiters = new StringBuilder();
        delimiters.append(":");
        delimiters.append(",");

        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            delimiters.append(matcher.group(1).charAt(0));
            input = matcher.group(2);
        }

        String[] nums = input.split("[" + delimiters.toString() + "]");

        int[] result = new int[nums.length];

        try {
            for (int i = 0; i < nums.length; i++) {
                result[i] = Integer.parseInt(nums[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return result;
    }
}
