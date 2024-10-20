package calculator;

public class StringParsing {

    private static String[] userInputArr;
    private static final String IS_NOT_NUMBER = "숫자가 아닌 값이 포함되어 있습니다";
    private static final String IS_NOT_POSITIVE = "양수가 아닙니다.";

    public static String[] stringParsingCheck(String userInput, String delimiter) {
        if (delimiter.length() > 3) {
            userInput = userInput.substring(userInput.indexOf("\\n") + 2);
        }
        String[] splitArr = splitNpushString(userInput, delimiter);
        stringValidateCheck(splitArr);
        return splitArr;
    }

    public static String[] splitNpushString(String userInput, String delimiter) {
        userInputArr = userInput.split(delimiter);
        for (String s : userInputArr) {
            if (s.isEmpty()) {
                continue;
            }
            if (!s.matches("\\d+")) {
                throw new IllegalArgumentException(IS_NOT_POSITIVE);
            }
        }
        return userInputArr;
    }

    public static void stringValidateCheck(String[] userInputArr) {
        for (String s : userInputArr) {
            if (s.isEmpty()) {
                continue;
            }
            try {
                Long.parseLong(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(IS_NOT_NUMBER);
            }
        }
    }
}
