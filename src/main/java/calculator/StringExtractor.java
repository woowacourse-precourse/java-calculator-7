package calculator;

public class StringExtractor {
    public String[] extract(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        if (input.startsWith("//")) {
            return extractWithCustom(input);
        }

        return extractWithDefault(input);
    }

    private String[] extractWithDefault(String input) {
        return input.split(",|:");
    }

    private String[] extractWithCustom(String input) {
        int delimiterIndex = input.indexOf("\\n");
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        String customDelimiter = input.substring(2, delimiterIndex);
        input = input.substring(delimiterIndex + 2);
        return input.split(customDelimiter);
    }
}
