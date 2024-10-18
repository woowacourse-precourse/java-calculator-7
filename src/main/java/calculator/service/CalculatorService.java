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
        return Stream.of(inputString.split(separator))
                .map(Integer::parseInt)
                .toList();
    }

    // 구분자를 찾는 메서드
    private String detectSeparator(String inputString) {
        // 커스텀 구분자가 있는 경우
        if (inputString.startsWith("//")) {
            return inputString.split("\n")[0];
        }
        // 커스텀 구분자가 없는 경우
        return ",|:";
    }

    private Integer add(List<Integer> numbers) {
        return 0;
    }
}
