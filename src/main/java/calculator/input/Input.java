package calculator.input;

import calculator.Utils.NumUtil;

public class Input {

    private static final char SEPARATOR_COMMA = ',';
    private static final char SEPARATOR_COLON = ':';

    private final String nums;

    protected Input(String nums) {
        this.nums = nums;
    }

    public static Input of(String input) {
        return InputFilter.from(input);
    }

    public int[] getNums() {
        int[] numArr = new int[nums.length() + 1];
        int idx = 0, cur = 0;
        boolean isPrevSeparator = false;
        for (int i = 0; i < nums.length(); i++) {
            char ch = nums.charAt(i);
            if (isSeparator(ch) && !isPrevSeparator) {
                numArr[idx++] = cur;
                cur = 0;
                isPrevSeparator = true;
                continue;
            }
            cur *= 10;
            cur += NumUtil.toInt(ch);
            isPrevSeparator = false;
        }
        numArr[idx] = cur;
        return numArr;
    }

    protected boolean isSeparator(char ch) {
        return ch == SEPARATOR_COLON || ch == SEPARATOR_COMMA;
    }
}
