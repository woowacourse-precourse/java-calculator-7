package calculator;

public class PasingString {
    private static int findStartIndex;
    private static String parseString;

    public static String pasingString(String input, String delimiter) {
        findStartString(input);
        isNumeric(parseString, delimiter);
        return parseString;
    }

    public static void findStartString(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                findStartIndex = i;
                break;
            }
        }
        parseString = input.substring(findStartIndex);
        emptyString(parseString);
    }

    public static void isNumeric(String startString, String delimiter) {
        String[] list = startString.split(delimiter);

        for (String digit : list) {
            if (!digit.matches("\\d+")) {
                throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
            }
        }
    }

    public static void emptyString(String input) {
        if (input.isEmpty()) {
            parseString = "0";
        }
    }
}
