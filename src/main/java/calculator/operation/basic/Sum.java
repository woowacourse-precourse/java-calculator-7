package calculator.operation.basic;

import calculator.operation.Calculator;

import java.util.List;
import java.util.regex.Pattern;

public class Sum implements Calculator {
    @Override
    public List<String> extractNumber(String numberPart, List<String> separators) {
        String separatorPattern = separators.stream()
                .map(Pattern::quote)  // 각 구분자를 이스케이프 처리
                .reduce((a, b) -> a + "|" + b)  // |로 결합
                .orElse(",");

        // 정규식 패턴에 맞춰서 split
        return List.of(numberPart.split(separatorPattern));
    }

    @Override
    public Integer calculate(List<String> numbers) {
        int total = 0;

        for (String number : numbers) {
            total += Integer.parseInt(number);
        }

        return total;
    }
}
