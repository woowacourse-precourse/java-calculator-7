package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private List<Integer> numbers = new ArrayList<>();
    private String[] delimiter = new String[]{",", ":"};

    public StringCalculator(String input) {
        this.numbers = split(input);
    }

    public int calculate() {
        int result = 0;
        for (int num : numbers) {
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            result += num;
        }
        return result;
    }


    public void addCustomDelimiter(String input, int endIndex) {
        String delimiterPart = input.substring(2, endIndex);
        String[] customDelimiters = delimiterPart.split("\\|");
        this.delimiter = mergeDelimiters(delimiter, customDelimiters);
    }

    private String[] mergeDelimiters(String[] baseDelimiters, String[] customDelimiters) {
        String[] merged = Arrays.copyOf(baseDelimiters, baseDelimiters.length + customDelimiters.length);
        System.arraycopy(customDelimiters, 0, merged, baseDelimiters.length, customDelimiters.length);
        return merged;
    }

    public List<Integer> split(String input) {
        // 빈 문자열 처리
        if (input == null || input.isEmpty()) {
            return List.of(0);
        }

        // 커스텀 구분자 처리
        if (input.startsWith("//") && input.contains("\\n")) {
            int endIndex = input.indexOf("\\n");  // 실제 개행 문자 \n 처리
            addCustomDelimiter(input, endIndex); // 커스텀 구분자 추가
            input = input.substring(endIndex + 2);  // 개행 문자 뒤로 이동
        }

        // 기본 구분자 또는 커스텀 구분자로 문자열을 분리한 후 숫자 리스트로 변환
        try {
            List<Integer> numberList = Arrays.stream(input.split(String.join("|", delimiter)))
                    .map(String::trim)           // 공백 제거
                    .filter(s -> !s.isEmpty())   // 빈 문자열 필터링
                    .map(Integer::parseInt)      // 문자열을 정수로 변환
                    .toList();

            // 음수 값 처리
            for (int num : numberList) {
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
            }

            return numberList;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }

}
