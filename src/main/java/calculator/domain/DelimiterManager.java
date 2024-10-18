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
        return "";
    }

    // 현재 커스텀 구분자를 반환하는 메서드
    public String getCustomDelimiter() {
        return customDelimiter;
    }
}