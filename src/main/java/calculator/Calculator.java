package calculator;

import calculator.dto.Data;

public class Calculator {

    public static int sum(Data data) {

        int sum = 0;
        String contentString = new String(data.getContents());
        String separatorString = getSeparatorsString(data.getSeparators());
        String[] nums = contentString.split(separatorString);
        for (int i = 0; i < nums.length; i++) {
            sum += Integer.parseInt(nums[i]);
        }
        return sum;
    }

    private static boolean isSeparator(char c, char[] separator) {
        for (int i = 0; i < separator.length; i++) {
            if (c == separator[i]) {
                return true;
            }
        }
        return false;
    }

    private static String getSeparatorsString(char[] separators) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < separators.length - 1; i++) {
            sb.append(separators[i]);
            sb.append("|");
        }
        char lastElement = separators[separators.length - 1];
        sb.append(lastElement);
        return sb.toString();
    }

    public static int charToInt(char c) {
        return c - '0';
    }
}
