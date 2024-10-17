package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    /**
     * 숫자의 합 계산
     */
    public int add(String input) {
        // 빈 입력 처리 (빈 문자열, 엔터, 탭, null)
        if (input.isBlank() || input == null) {
            return 0;
        }

        // 단일 숫자 입력 처리
        if (isInteger(input)) {
            return Integer.parseInt(input);
        }

        // 음수 입력 예외 처리
        if (input.contains("-")) {
            throw new IllegalArgumentException();
        }

        // 구분자 처리
        Delimiter delimiter = new Delimiter(input);
        String[] tokens = delimiter.extractNumbers();
        List<Integer> numbers = convertToNumbers(tokens);

        return sum(numbers);
    }

    /**
     * 문자열 배열을 정수 리스트로 변환하는 메서드
     */
    private List<Integer> convertToNumbers(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식이 포함되어 있습니다: " + token);
            }
        }
        return numbers;
    }

    /**
     * 숫자들의 합을 구하는 메서드
     */
    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    /**
     * 입력이 정수인지 확인
     */
    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
