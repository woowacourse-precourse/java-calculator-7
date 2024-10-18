package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparatorManager {
    private List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));

    public List<String> getSeparators() {
        return separators;
    }

    public String addCustomSeparatorAndTrim(String input) {
        if (hasCustomSeparator(input)) {
            int separatorIndex = findSeparatorIndex(input);
            String customSeparator = extractCustomSeparator(input, separatorIndex);  // 커스텀 구분자 추출
            validateCustomSeparator(customSeparator);               // 커스텀 구분자가 문자인지 검증
            addSeparator(customSeparator);                          // 커스텀 구분자 추가
            return trimInput(input, separatorIndex);                // 커스텀 구분자 제외 문자열 반환
        }
        return input;
    }

    private boolean hasCustomSeparator(String input) {
        return input.startsWith("//");
    }

    private int findSeparatorIndex(String input) {
        int separatorIndex = input.indexOf("\\n");
        if (separatorIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. 커스텀 구분자 뒤에 '\\n'이 필요합니다.");
        }
        return separatorIndex;
    }

    private String extractCustomSeparator(String input, int separatorIndex) {
        return input.substring(2, separatorIndex);  // "//" 이후 "\n" 이전 구분자 추출
    }

    private void addSeparator(String customSeparator) {
        separators.add(customSeparator);
    }

    private String trimInput(String input, int separatorIndex) {
        return input.substring(separatorIndex + 2);  // 커스텀 구분자 뒤의 문자열 반환
    }

    // 커스텀 구분자가 문자가 아닌 숫자일 경우 검증
    private void validateCustomSeparator(String customSeparator) {
        if (customSeparator.matches("\\d")) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다: " + customSeparator);
        }
    }
}
