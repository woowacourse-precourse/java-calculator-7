package calculator.service;

import java.util.List;
import java.util.stream.Stream;

public class CalculatorService {

    public Integer executeAdd(String inputString){
        List<Integer> extractedNumbers = extractNumber(inputString);
        return add(extractedNumbers);
    }

    private List<Integer> extractNumber(String inputString) {
        String[] splittedString = detectSeparator(inputString);
        String separator = splittedString[0];
        return Stream.of(splittedString[1].split(separator))
                .map(Integer::parseInt)
                .toList();
    }

    // 구분자를 찾는 메서드
    // idx 0: 구분자, idx 1: 문자열
    private String[] detectSeparator(String inputString) {
        // 커스텀 구분자가 있는 경우
        if (inputString.startsWith("//")) {
            String[] split = inputString.replace("\\n", "\n").split("\n");
            split[0] = split[0].substring(2);
            return split;
        }
        // 커스텀 구분자가 없는 경우
        return new String[]{",|:", inputString};
    }


    private Integer add(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
