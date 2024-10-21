package calculator.service;

import java.util.List;
import java.util.Map;

public class CalculatorService {

    private static final String DEFAULT_DELIMITER = ",|:";

    /**
     * 입력받은 문자열을 구분자로 나누어 합을 계산
     *
     * @param extractedMap 입력 문자열과 커스텀 구분자를 포함한 맵
     * @return 계산된 결과값
     */
    public static int extractAndCalculate(Map<String, String> extractedMap) {

        String delimiter = mergeDelimiters(extractedMap.get("customDelimiter"));

        List<String> values = List.of(extractedMap.get("calculateString").split(delimiter));
        return sum(values);
    }

    /**
     * 문자열 리스트를 정수 리스트로 변환 후 합을 계산
     *
     * @param values 문자열 리스트
     * @return 더해진 결과값
     */
    private static int sum(List<String> values) {

        List<Integer> intValues = values.stream()
                .filter(value -> !value.isEmpty())
                .map(Integer::parseInt)
                .toList();

        checkNegativeNumbers(intValues);

        return intValues.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * 기본 구분자와 사용자 정의 구분자를 병합
     *
     * @param customDelimiter 커스텀 구분자
     * @return 병합된 구분자 regex
     */
    private static String mergeDelimiters(String customDelimiter) {
        return DEFAULT_DELIMITER +
                (customDelimiter != null ? "|" + customDelimiter : "");
    }

    /**
     * 음수가 포함되어 있는지 확인
     *
     * @param values 더할 정수 리스트
     */
    private static void checkNegativeNumbers(List<Integer> values) {
        List<String> negativeNumbers = values.stream()
                .filter(value -> value < 0)
                .map(String::valueOf)
                .toList();
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다. : " + String.join(", ", negativeNumbers));
        }
    }
}
