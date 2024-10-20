package calculator.utils;

public class SplitString {
    private static final String defaultDelimiter = ",|:";

    public static String[] splitInput(String input) {
        String delimiter = defaultDelimiter;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");

            if (delimiterIndex == -1 || delimiterIndex == 2) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }

            String customDelimiter = input.substring(2, delimiterIndex);
            delimiter = customDelimiter;

            input = input.substring(delimiterIndex + 2);
        }

        try {
            return input.split(delimiter);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
