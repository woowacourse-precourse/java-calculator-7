package calculator;

import java.util.regex.Pattern;

public class Tokenizer {

    public static String[] tokenize(char[] separators, String str) {
        for (char separator: separators) {
            str = str.replace(separator, separators[0]);
        }
        return str.split(String.valueOf(separators[0]));
    }

    public static int[] tokensToNums(String[] tokens) {
        int[] nums = new int[tokens.length];
        for (int i=0; i< tokens.length; i++) {
            nums[i] = Integer.valueOf(tokens[i]);
        }
        return nums;
    }

    public static String removeHeader(String user_input) {
        return user_input.replaceAll("^(//).*\\\\n", "");
    }
}
