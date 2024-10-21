package calculator.service;

import java.util.Arrays;
import java.util.List;

public class CalculatorService {

    public List<String> splitByDelimiters(String input) {
        String delimiter = ",|:";  //기본 구분자

        //커스텀 구분자 탐색
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            String customDelimiter = input.substring(2, delimiterIndex);
            delimiter = delimiter + "|" + customDelimiter;  //기본 구분자에 커스텀 구분자 추가
            input = input.substring(delimiterIndex + 1);  //문자열에서 커스텀 구분자 부분 제거
        }

        return Arrays.stream(input.split(delimiter))
                .toList();
    }

    public long sum(List<String> splitInput) {
        return splitInput.stream()
                .mapToLong(Long::parseLong)
                .sum();
    }

    private void validateNumbers(List<String> splitInput) {
        splitInput.forEach(value -> {
            if (isNotNumeric(value)) {
                throw new IllegalArgumentException();
            }

            long number = Long.parseLong(value);
            if (number <= 0) {
                throw new IllegalArgumentException();
            }
        });
    }

    private boolean isNotNumeric(String value) {
        try {
            Long.parseLong(value);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
