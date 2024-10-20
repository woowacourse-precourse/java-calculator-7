package calculator.model;

import java.util.regex.Pattern;

public class StringProcessor {
    private String parseCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                String customDelimiter = input.substring(2, delimiterEndIndex);
                if (customDelimiter.isEmpty()) {
                    throw new IllegalArgumentException("커스텀 구분자를 입력해 주세요.");
                }
                return Pattern.quote(customDelimiter);
            } else {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        }
        return null;
    }

    public String[] StringSplitter(String input) {

        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        String delimiter = ",|:";
        String numbers = input;

        String customDelimiter = parseCustomDelimiter(input);
        if (customDelimiter != null) {
            delimiter = customDelimiter;
            int delimiterEndIndex = input.indexOf("\\n");
            numbers = input.substring(delimiterEndIndex + 2);
        }

        if (!numbers.matches("[-\\d" + delimiter + "]+")) {
            throw new IllegalArgumentException("올바르지 않은 구분자입니다.");
        }

        String[] splitNumbers = numbers.split(delimiter);

        if (splitNumbers.length == 0 || numbers.matches(delimiter + "+")) {
            throw new IllegalArgumentException("구분자를 쓸 때는 숫자를 입력해 주세요.");
        }

        return splitNumbers;
    }
}