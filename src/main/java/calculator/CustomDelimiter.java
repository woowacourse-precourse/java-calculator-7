package calculator;

public class CustomDelimiter {
    private static String delimiters = ",|:";

    public static String parseDelimiters(String inputMessage) {
        if (inputMessage.length() >= 4) {
            findDelimiter(inputMessage);
        }
        return delimiters;
    }

    private static void findDelimiter(String inputMessage) {
        int start = 0;
        int end = 2;

        String pre = inputMessage.substring(start, end);
        if (!(pre.equals("//"))) {
            return;
        }

        int next = inputMessage.indexOf("\\n", end);
        if (next == 2) {
            validateAndAddDelimiter("");
            return;
        }

        if (!(next == 3)) {
            throw new IllegalArgumentException("커스텀 구분자 입력 값이 올바르지 않습니다.");
        }
        validateAndAddDelimiter(String.valueOf(inputMessage.charAt(2)));
    }

    private static void validateAndAddDelimiter(String delimiter) {
        String escapedChars = ".*+?^${}[]()|";

        isNonNumeric(delimiter);
        if (escapedChars.contains(delimiter) && !delimiter.isEmpty()) {
            delimiter = "\\" + delimiter;
        }
        addDelimiter(delimiter);
    }

    private static void addDelimiter(String delimiter) {
        delimiters += "|" + delimiter;
    }

    private static void isNonNumeric(String delmiter) {
        char[] cArr = delmiter.toCharArray();

        for (char c : cArr) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자는 구분자가 될 수 없습니다.");
            }
        }
    }
}
