package calculator;

public class CostomDelimiter {
    private static String delimiters = ",|:";

    public static String parseDelimiters(String inputMessage) {
        if (inputMessage.length() >= 4) {
            findDelimiter(inputMessage);
        }
        return delimiters;
    }

    public static void findDelimiter(String inputMessage) {
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
        if (next != 3) {
            throw new IllegalArgumentException("커스텀 구분자 입력 값이 올바르지 않습니다.");
        }
        validateAndAddDelimiter(String.valueOf(inputMessage.charAt(2)));
    }

    private static void validateAndAddDelimiter(String delimiter) {
        if (isNonNumeric(delimiter)) {
            addDelimiter(delimiter);
        }
    }

    public static void addDelimiter(String delimiter) {
        delimiters += "|" + delimiter;
    }

    public static boolean isNonNumeric(String delmiter) {
        char[] cArr = delmiter.toCharArray();

        for (char c : cArr) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자는 구분자가 될 수 없습니다.");
            }
        }
        return true;
    }
}
