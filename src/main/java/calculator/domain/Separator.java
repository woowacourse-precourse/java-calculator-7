package calculator.domain;

import java.util.List;

public class Separator {

    private DelimiterManager delimiterManager;

    // 생성자를 통해 DelimiterManager 주입
    public Separator(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
    }

    // 입력 문자열을 구분자를 기준으로 분리하여 숫자를 추출하는 메서드
    public String extractNumbers(String input) {
        // 사용할 구분자 리스트를 DelimiterManager에서 가져옴
        List<String> delimiters = delimiterManager.getDelimiters(input);

        // 구분자 리스트를 기반으로 입력 문자열을 분리
        return splitByDelimiters(input, delimiters);
    }

    // 구분자를 사용하여 숫자를 분리하는 메서드
    private String splitByDelimiters(String input, List<String> delimiters) {
        return "";
    }
}