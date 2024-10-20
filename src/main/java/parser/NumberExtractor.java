package parser;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {
    public List<Integer> extractNumbers(String input, String delimiterRegex) {
        String numbersPart = input.startsWith("//") ? input.substring(input.indexOf("\\n") + 2) : input;
        String[] tokens = numbersPart.split(delimiterRegex);
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            if (token.trim().isEmpty()) {
                throw new IllegalArgumentException("숫자가 누락되었습니다.");
            }
            try {
                numbers.add(Integer.parseInt(token.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다.");
            }
            if (Integer.parseInt(token.trim()) < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
        return numbers;
    }
}
