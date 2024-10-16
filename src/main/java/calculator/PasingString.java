package calculator;

public class PasingString {
    private static final int BASIC_DELIMITER_SIZE = 3;
    private static int findStartIndex;
    private static String parseString;

    public static String pasingString(String input, String delimiter) {
        findStartIndex(input, delimiter);
        String substring = input.substring(findStartIndex);
        String[] list = substring.split(delimiter);

        for (String digit : list) {
            if (!digit.matches("\\d+")) {
                throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
            }
        }

        return input.substring(findStartIndex);
    }

    public static void findStartIndex(String input, String delimiter) {
        if (delimiter.length() > BASIC_DELIMITER_SIZE) {
            findStartIndex = 5;
        }
    }


}
