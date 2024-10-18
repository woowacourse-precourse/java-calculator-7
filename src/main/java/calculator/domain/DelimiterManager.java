package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class DelimiterManager {

    private final List<String> defaultDelimiters;  // 기본 구분자 리스트
    private String customDelimiter;                // 커스텀 구분자

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
        if (customDelimiter != null) {
            delimiters.add(customDelimiter);
        }

        return delimiters;
    }

    // 커스텀 구분자를 추출하는 메서드
    private String extractCustomDelimiter(String input) {
        // 입력 문자열에서 "//"와 "\n" 사이의 커스텀 구분자를 찾음
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex != -1) {
                // 커스텀 구분자를 "//"와 "\n" 사이에서 추출
                return input.substring(2, delimiterEndIndex);
            }
        }
        return null;  // 커스텀 구분자가 없을 경우 null 반환
    }

    // 현재 커스텀 구분자를 반환하는 메서드
    public String getCustomDelimiter() {
        return customDelimiter;
    }
}