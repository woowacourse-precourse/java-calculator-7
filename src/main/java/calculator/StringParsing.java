package calculator;

public class StringParsing {
    private static String[] userInputArr;

    public static String[] splitNpushString(String userInput, String delimiter) {
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
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다");
            }
        }
    }
}
