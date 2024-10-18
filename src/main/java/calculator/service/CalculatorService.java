package calculator.service;

import java.util.List;
import java.util.stream.Stream;

public class CalculatorService {

    public Integer executeAdd(String inputString){
        List<Integer> extractedNumbers = extractNumber(inputString);
        return add(extractedNumbers);
    }

    private List<Integer> extractNumber(String inputString) {
        String separator = detectSeparator(inputString);
        if (!separator.equals(",|:")) { // 기본 구분자가 아닌 경우 \n 이후를 문자열로 사용
            inputString = inputString.split("\n")[1];
        }
        return Stream.of(inputString.split(separator))
                .map(Integer::parseInt)
                .toList();
    }

    // 구분자를 찾는 메서드
    private String detectSeparator(String inputString) {
        // 커스텀 구분자가 있는 경우
        if (inputString.startsWith("//")) {
            return inputString.split("\n")[0].substring(2);
        }
        // 커스텀 구분자가 없는 경우
        return ",|:";
    }

    private Integer add(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
