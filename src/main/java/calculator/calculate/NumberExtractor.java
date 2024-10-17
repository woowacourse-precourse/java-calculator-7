package calculator.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberExtractor {


    private List<Integer> numbers;

    public NumberExtractor() {
        this.numbers = new ArrayList<>();
    }

    // 숫자 변환 메서드
    public List<Integer> extractNumbers(String additionString, List<String> separators) {
        if (additionString.isEmpty()) {
            this.numbers.add(0);  // 0인 경우 처리
            return this.numbers;
        }

        // 구분자 공백 변경
        String modifiedString = additionString.replaceAll(String.join("|", separators), " ");

        // 구분자를 기준으로 숫자로 변환
        Arrays.stream(modifiedString.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(numbers::add);

        // 양수만 있는지 검증
        if (!isAllNumberPositive()) {
            throw new IllegalArgumentException();
        }

        return this.numbers;
    }

    // 양수 검증
    private boolean isAllNumberPositive() {
        return numbers.stream().allMatch(i -> i > 0);
    }

}
