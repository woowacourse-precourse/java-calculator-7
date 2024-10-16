package calculator.utils;

import calculator.input.Input;

public class NumUtil {

    public static boolean isNum(char ch) {
        return '0' <= ch && ch <= '9';
    }

    public static boolean isValidFirstNum(String nums) {
        if (nums.isEmpty()) {
            return true; // 빈 문자열 허용
        }
        return isNum(nums.charAt(0));
    }

    public static int toInt(char ch) {
        if (isNum(ch)) {
            return ch - 48;
        }
        throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
    }

    public static int[] toIntArray(Input input) {
        String nums = input.getNums();
        int[] numArr = new int[nums.length() / 2 + 1];

        int idx = 0, cur = 0;
        boolean isPrevSeparator = false;
        for (int i = 0; i < nums.length(); i++) {
            char ch = nums.charAt(i);
            if (input.isSeparatorEqual(ch) && !isPrevSeparator) {
                numArr[idx++] = cur;
                cur = 0;
                isPrevSeparator = true;
                continue;
            }
            cur *= 10;
            cur += toInt(ch);
            isPrevSeparator = false;
        }
        numArr[idx] = cur;
        return numArr;
    }
}
