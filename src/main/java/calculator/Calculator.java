package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 구분자를 제거하고 숫자들의 합을 반환한다
 */
public class Calculator {

    private final List<Character> delimiters;
    private final String input;

    public Calculator(List<Character> delimiters, String input) {
        this.delimiters = delimiters;
        this.input = input;
    }

    /**
     * 합을 계산하여 반환한다
     *
     * @return 합 결과
     */
    public int CalculateSum() {
        //문자열을 split한다
        List<Integer> numbers = splitString();
        //각 숫자가 유효한지 판단 (양수여야한다)
        validateNumbers(numbers);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * 숫자들이 모두 양수인지 검증한다
     *
     * @param numbers 검증해야하는 숫자 리스트
     */
    private void validateNumbers(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i < 0) {
                throw new IllegalArgumentException("숫자는 양수여야합니다.");
            }
        }
    }

    /**
     * 문자열을 구분자들을 기준으로 분리하여 반환
     *
     * @return 숫자 리스트
     */
    private ArrayList<Integer> splitString() {
        String regex = delimiters.stream()
                .map(String::valueOf)
                .reduce((a, b) -> a + "|" + b)
                .orElse("");

        ArrayList<Integer> numbers = new ArrayList<>();
        Arrays.stream(input.split(regex)).forEach(number -> numbers.add(Integer.parseInt(number)));
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("최소 하나 이상의 숫자를 입력하세요");
        }
        return numbers;
    }
}
