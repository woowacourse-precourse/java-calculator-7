package calculator;

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
}
