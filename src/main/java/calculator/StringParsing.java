package calculator;

public class StringParsing {

    private static String[] userInputArr;
    private static final String IS_NOT_NUMBER = "숫자가 아닌 값이 포함되어 있습니다";
    private static final String IS_NOT_POSITIVE = "양수가 아닙니다.";

    public static String[] splitNpushString(String userInput, String delimiter) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                throw new IllegalArgumentException(IS_NOT_POSITIVE);
            }
        }
        userInputArr = userInput.split(delimiter);
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
