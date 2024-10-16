package calculator;

import calculator.dto.Data;

public class Calculator {

    public static int sum(Data data) {
        int sum = 0;
        String contentString = getContentString(data.getContents(), data.getSeparators());
        String separatorString = getSeparatorsString(data.getSeparators());
        String[] nums = contentString.split("[" + separatorString + "]");
        try {
            for (int i = 0; i < nums.length; i++) {
                sum += Integer.parseInt(nums[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
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

    private static String getContentString(char[] contents, char[] separator) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        if (isSeparator(contents[0], separator)) {
            index = 1;
        }
        for (int i = index; i < contents.length; i++) {
            sb.append(contents[i]);
        }
        return sb.toString();
    }

    private static String getSeparatorsString(char[] separators) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < separators.length - 1; i++) {
            sb.append(separators[i]);
        }
        char lastElement = separators[separators.length - 1];
        sb.append(lastElement);
        return sb.toString();
    }
}
