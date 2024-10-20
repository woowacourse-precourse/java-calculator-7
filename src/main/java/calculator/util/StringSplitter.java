package calculator.util;

import java.util.List;

public class StringSplitter {
    private String input;

    public StringSplitter(String input) {
        this.input = input;
    }

    public List<String> split(String delimiter) {
        // 먼저 \\n을 실제 줄 바꿈 문자로 변환
        input = input.replace("\\n", "\n");

        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);  // \n을 기준으로 구분
            if (parts.length < 2) {
                throw new IllegalArgumentException("올바른 형식의 커스텀 구분자를 입력해 주세요.");
            }
            String customSeparator = parts[0].substring(2);  // 커스텀 구분자 추출
            return List.of(parts[1].split(customSeparator));
        }
        return List.of(input.split(delimiter));  // 기본 구분자 처리
    }
}