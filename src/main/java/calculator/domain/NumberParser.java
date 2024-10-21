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

        private static void validateNumbers(String[] numbers) {
            for (String number : numbers) {
                if (!isNumeric(number)) {
                    throw new IllegalArgumentException("숫자가 아닌 잘못된 입력입니다: " + number);
                }
                if (Integer.parseInt(number) < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
            }
        }

        private static boolean isNumeric(String str) {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}
