package calculator.util;
//문자열 처리 부분 역할/책임 옮기기

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputParser {


    /**
     * StringCalculator 에서 문자열 파싱 부분 책임 분리
     *
     * @param input
     * @return
     */
    public List<String> parse(String input) {
        System.out.println("InputParser - 입력 문자열: '" + input + "'");

        if (input == null || input.trim().isEmpty()) {
            System.out.println("InputParser - 빈 입력, 빈 리스트 반환");
            return List.of();
        }

        // Case1 기본 구문자
        String delimiter = ",|:";
        String numbers = input;

        // Case2 커스텀 구문자
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\\n");
            System.out.println("input 확인: " + input);
            System.out.println("delimiterEnd " + delimiterEnd);

            if (delimiterEnd == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다: " + input);
            }
            delimiter = Pattern.quote(input.substring(2, delimiterEnd));
            numbers = input.substring(delimiterEnd + 2); // \\n은 2개의 문자 임으로 +2 해줘야함
        }

        System.out.println("InputParser - 최종 구분자: '" + delimiter + "'");
        System.out.println("InputParser - 파싱할 숫자 문자열: '" + numbers + "'");

        List<String> result = Arrays.asList(numbers.split(delimiter));
        System.out.println("InputParser - 최종 파싱 결과: " + result);
        return result;
    }
}