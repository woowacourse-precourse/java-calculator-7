package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    private final List<String> delimiters = new ArrayList<>();
    private String numbers;

    public StringParser(String input) {
        delimiters.add(",");
        delimiters.add(":");
        parseInput(input);
    }

    private void parseInput(String input) {
        numbers = input;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf('\n');
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
            String customDelimiter = input.substring(2, delimiterEndIndex);
            delimiters.clear();
            delimiters.add(customDelimiter);
            numbers = input.substring(delimiterEndIndex + 1); // '\n'의 길이는 1입니다.
        }
    }

    public List<String> getTokens() {
        List<String> tokens = new ArrayList<>();
        StringBuilder numberBuilder = new StringBuilder();

        for (int i = 0; i < numbers.length(); i++) {
            boolean isDelimiter = false;
            for (String delimiter : delimiters) {
                if (numbers.startsWith(delimiter, i)) {
                    if (!numberBuilder.isEmpty()) {
                        tokens.add(numberBuilder.toString());
                        numberBuilder.setLength(0);
                    }
                    i += delimiter.length() - 1; // 인덱스 조정
                    isDelimiter = true;
                    break;
                }
            }
            if (!isDelimiter) {
                numberBuilder.append(numbers.charAt(i));
            }
        }

        // 마지막 숫자 추가
        if (!numberBuilder.isEmpty()) {
            tokens.add(numberBuilder.toString());
        }

        return tokens;
    }
}