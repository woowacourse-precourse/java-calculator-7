package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class DelimiterManager {

    private final List<String> defaultDelimiters;  // 기본 구분자 리스트

    public DelimiterManager() {
        // 기본 구분자 설정 (쉼표, 콜론)
        this.defaultDelimiters = new ArrayList<>();
        defaultDelimiters.add(",");
        defaultDelimiters.add(":");
    }

    // 입력 문자열에서 구분자를 추출하고 반환하는 메서드
    public List<String> getDelimiters(String input) {
        List<String> delimiters = new ArrayList<>(defaultDelimiters);

        // 커스텀 구분자가 있는지 확인
        String customDelimiter = extractCustomDelimiter(input);

        // 커스텀 구분자가 있을 때만 구분자 리스트에 추가
        if (customDelimiter != null) {
            // 구분자가 한 글자 이상이면 예외 처리
            if (customDelimiter.length() > 1) {
                throw new IllegalArgumentException("구분자는 하나의 문자여야 합니다.");
            }

            // 메타 문자가 포함된 구분자에 대해 이스케이프 처리
            delimiters.add(escapeMetaCharacters(customDelimiter));
        }

        return delimiters; // 커스텀 구분자가 없을 경우 기본 구분자만 반환
    }

    // 정규식 메타 문자를 이스케이프 처리하는 메서드
    private String escapeMetaCharacters(String delimiter) {
        // 정규식에서 메타문자를 이스케이프 처리
        if (delimiter.matches("[\\[\\](){}.*+?^$|\\\\]")) {
            return "\\" + delimiter;
        }
        return delimiter;
    }

    // 커스텀 구분자를 추출하는 메서드
    private String extractCustomDelimiter(String input) {
        // 입력 문자열에서 "//"와 "\n" 사이의 커스텀 구분자를 찾음
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");

            // "//"로 시작했지만 "\n"이 없는 경우 예외 처리
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException(
                    "커스텀 구분자가 제대로 지정되지 않았습니다. 구분자와 숫자 사이에는 '\\n'이 포함되어야 합니다.");
            }

            // 커스텀 구분자가 존재하지 않는 경우 (예: "//\n"만 있는 경우) null 반환
            if (delimiterEndIndex == 2) {
                return null; // 커스텀 구분자가 없으므로 기본 구분자로 처리
            }

            // 커스텀 구분자를 "//"와 "\n" 사이에서 추출
            return input.substring(2, delimiterEndIndex);
        }
        return null;  // 커스텀 구분자가 없을 경우 null 반환
    }
}
