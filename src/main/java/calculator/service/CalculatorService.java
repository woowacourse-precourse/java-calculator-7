package calculator.service;

import java.util.List;
import java.util.regex.Pattern;
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
                .map(number->{
                    try {
                        int parsedInt = Integer.parseInt(number);
                        if (parsedInt <= 0) {
                            // 음수인 경우
                            throw new IllegalArgumentException("입력은 구분자와 양수로 구성된 문자열이어야 합니다.");
                        }
                        return parsedInt;

                    } catch (IllegalArgumentException e) {
                        // 숫자가 아닌 경우
                        throw new IllegalArgumentException("입력은 구분자와 양수로 구성된 문자열이어야 합니다.");
                    }
                })
                .toList();
    }

    // 구분자를 찾는 메서드
    // returns [구분자, 문자열]
    private String[] detectSeparator(String inputString) {
        // 커스텀 구분자가 있는 경우
        if (inputString.startsWith("//")) {
            if (!inputString.contains("\\n")) {
                throw new IllegalArgumentException("커스텀 구분자를 사용하려면 \\n을 포함해야 합니다.");
            }
            String[] split = inputString.replace("\\n", "\n").split("\n");
            String sub = split[0].substring(2);
            if (sub.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자는 공백일수 없습니다.");
            } else if (sub.equals(",") || sub.equals(":")) {
                throw new IllegalArgumentException("커스텀 구분자는 , 또는 : 이외의 문자여야 합니다.");
            }
            split[0] = Pattern.quote(sub);
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
