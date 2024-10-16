package calculator;

public class CostomDelimiter {
    private static String delimiters = ",|:";

    public static String parseDelimiters(String inputMessage) {
        findDelimiter(inputMessage);
        return delimiters;
    }

    public static void findDelimiter(String inputMessage) {
        int start = 0;
        int end = 2;
        String pre = inputMessage.substring(start, end);
        int next = inputMessage.indexOf("\\n", end);

        if (!(pre.equals("//") && next == 3)) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }
        validateAndAddDelimiter(inputMessage.charAt(2));
    }

    private static void validateAndAddDelimiter(char delimiter) {
        if (isNonNumeric(delimiter)) {
            addDelimiter(delimiter);
        }
    }

    public static void addDelimiter(char delimiter) {
        delimiters += "|" + delimiter;
    }

    public static boolean isNonNumeric(char delmiter) {
        if (Character.isDigit(delmiter)) {
            throw new IllegalArgumentException("숫자는 구분자가 될 수 없습니다.");
        }
        return true;
    }
}
