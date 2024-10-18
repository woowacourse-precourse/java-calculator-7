package calculator;

import java.util.ArrayList;
import java.util.List;

// 입력 문자열을 파싱하여 구분자 및 숫자 리스트를 반환하는 클래스
public class Parser {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_START = "//";
    private static final String CUSTOM_SEPARATOR_END = "\\n"; // 실제로는 문자 '\n'

    public List<Integer> parse(String input) {
        if (input.startsWith(CUSTOM_SEPARATOR_START)) {
            int customSeparatorEndIndex = input.indexOf(CUSTOM_SEPARATOR_END);
            if (customSeparatorEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. 커스텀 구분자 다음에 '\\n'이 필요합니다.");
            }
            String customSeparator = input.substring(2, customSeparatorEndIndex);
            String numbers = input.substring(customSeparatorEndIndex + 2); // "\n"의 길이 만큼 더함

            // 커스텀 구분자를 사용하여 숫자 분리
            return splitAndValidate(numbers, customSeparator);
        }

        return splitAndValidate(input, DEFAULT_SEPARATOR);
    }

    private List<Integer> splitAndValidate(String input, String separator) {
        String[] nums = input.split(separator);
        List<Integer> result = new ArrayList<>();

        return result;
    }

}
