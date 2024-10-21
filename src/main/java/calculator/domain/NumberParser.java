package calculator.domain;

public class NumberParser {
    public String[] parse(String input, String delimiters) {
        Validator.validate(input);
        String processedInput = getSplittedString(input);
        return processedInput.split(delimiters);
    }

    private String getSplittedString(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            return input.substring(delimiterEndIndex + 1);
        }
        return input;
    }

    /* Validator */
    private static class Validator {

        private static void validate(String message) {
            if (isBlank(message)) {
                throw new IllegalArgumentException("비어있는 숫자가 입력되었습니다.");
            }
        }

        private static boolean isBlank(String message) {
            return message == null || message.isBlank(); // null 체크 추가
        }
    }
}
