package calculator.string;

import java.util.Arrays;

/**
 * 문자열 계산기 클래스
 * 입력된 문자열을 파싱하고 숫자의 합을 계산
 */
public class StringCalculator {

    /**
     * 입력된 문자열의 숫자들을 더한 결과 반환
     * 숫자는 쉼표(,)로 or 콜(:)으로 구분, 개수 제한 없음
     * 커스텀 구분자 사용 가능, "//"와 "\n" 사이에 정의
     *
     * @param input 계산할 숫자들이 포함된 문자열
     * @return 문자열에 포함된 숫자들의 합
     */
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String numbers = input;
        String delimiter = ",";

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            numbers = input.substring(delimiterIndex + 1);
        }

        numbers = numbers.replace(delimiter, ",").replace(":", ",");

        return Arrays.stream(numbers.split(","))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
