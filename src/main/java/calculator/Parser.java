package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String DEFAULT_DELIMITER = ",|:";

    // 문자열을 파싱하여 숫자 리스트를 반환
    public List<Integer> parse(String input) {
        if (input == null || input.isEmpty()) {
            return List.of(0);
        }

        String delimiter = DEFAULT_DELIMITER;
        String numbersPart = input;

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException();
            }
            delimiter = input.substring(2, delimiterEndIndex); // 커스텀 구분자 추출
            numbersPart = input.substring(delimiterEndIndex + 2); // 숫자 부분 추출
        }

        // 구분자를 기준으로 문자열을 분리하고 숫자 리스트 반환
        String[] tokens = numbersPart.split(delimiter);
        return parseNumbers(tokens);
    }

    // 문자열 배열을 숫자 리스트로 변환
    private List<Integer> parseNumbers(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(NumberValidator.validateAndParse(token));
        }
        return numbers;
    }
}
