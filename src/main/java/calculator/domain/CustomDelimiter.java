package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomDelimiter {
    // 커스텀 구분자 목록
    private List<String> customDelimiters = new ArrayList<>();

    // 기본 구분자와 커스텀 구분자를 함께 관리
    public List<String> getAllDelimiters() {
        List<String> allDelimiters = new ArrayList<>(Delimiter.getAll());
        allDelimiters.addAll(customDelimiters);
        return allDelimiters;
    }

    // 커스텀 구분자 추가
    public void addCustomDelimiter(String customDelimiter) {
        customDelimiters.add(customDelimiter);
    }

    // 커스텀 + 디폴트 구분자를 정규식으로 변환
    public String toRegex() {
        return getAllDelimiters().stream()
                .map(d -> d.replaceAll("([\\W])", "\\\\$1"))
                .collect(Collectors.joining("|"));
    }
}
