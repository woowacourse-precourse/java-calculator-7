package calculator;

import java.util.HashSet;
import java.util.Set;

public class DelimiterParser {
    private static final int CUSTOM_DELIMITER_START = 2;
    private static final Set<String> DEFAULT_DELIMITERS = Set.of(":", ",");  // 기본 구분자를 상수로 정의
    private final Set<String> delimiters = new HashSet<>();
    private int parseIndex = 0;

    public DelimiterParser() {
        delimiters.addAll(DEFAULT_DELIMITERS);
    }
    // 구분자 있는지 확인 후 파싱하는 메서드
    public int parse(String input) {
        // 커스텀 구분자 있는지 확인
        while (hasCustomDelimiter(input)) {
            parseIndex += CUSTOM_DELIMITER_START;  // "//" 스킵
            StringBuilder sepLetter = new StringBuilder();

            extractCustomDelimiter(input, sepLetter);
            addDelimiter(input, sepLetter);
        }
        return parseIndex;
    }

    // 커스텀 구분자가 있는지 확인하는 메서드
    private boolean hasCustomDelimiter(String input) {
        return input.length() > 2 && parseIndex + 1 < input.length()
                && input.charAt(parseIndex) == '/' && input.charAt(parseIndex + 1) == '/';
    }

    // 새로운 구분자를 추출하는 메서드
    private void extractCustomDelimiter(String input, StringBuilder sepLetter) {
        while (isNotEndOfDelimiter(input)) {
            sepLetter.append(input.charAt(parseIndex));
            parseIndex++;
        }

        if (sepLetter.length() == 0) {
            throw new IllegalArgumentException("구분자가 비어 있습니다.");
        }
    }

    // 구분자 끝을 확인하는 메서드
    private boolean isNotEndOfDelimiter(String input) {
        return parseIndex + 1 < input.length()
                && !(input.charAt(parseIndex) == '\\' && input.charAt(parseIndex + 1) == 'n');
    }

    // 추출한 구분자를 추가하는 메서드
    private void addDelimiter(String input, StringBuilder sepLetter) {
        if (isEndOfDelimiter(input)) {
            delimiters.add(sepLetter.toString());
            parseIndex += CUSTOM_DELIMITER_START;  // '\n' 스킵
        } else {
            throw new IllegalArgumentException("구분자 끝을 찾을 수 없습니다.");
        }
    }

    // 구분자 끝이 맞는지 확인하는 메서드
    private boolean isEndOfDelimiter(String input) {
        return parseIndex + 1 < input.length() && input.charAt(parseIndex) == '\\' && input.charAt(parseIndex + 1) == 'n';
    }

    public Set<String> getDelimiters() {
        return delimiters;
    }

    public int getParseIndex() {
        return parseIndex;
    }
}
