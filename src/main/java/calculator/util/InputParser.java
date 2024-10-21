package calculator.util;
//문자열 처리 부분 역할/책임 옮기기

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * InputParser 클래스 :  StringCalculator에서 사용되는 문자열 파싱 로직을 담당, 기본 구분자와 커스텀 구분자를 처리
 */
public class InputParser {

    /**
     * 주어진 입력 문자열을 파싱하여 숫자 문자열 리스트로 반환 다음과 같은 입력을 처리할 수 있습니다: 1. 기본 구분자(',', ':')를 사용한 입력 2. 커스텀 구분자를 사용한 입력 (예:
     * "//;\n1;2;3")
     *
     * @param input 파싱할 입력 문자열
     * @return 파싱된 숫자 문자열의 리스트
     * @throws IllegalArgumentException 커스텀 구분자 형식이 올바르지 않은 경우
     */
    public List<String> parse(String input) {

        if (input == null || input.trim().isEmpty()) {
            return List.of();
        }

        // Case1 기본 구문자
        String delimiter = ",|:";
        String numbers = input;

        // Case2 커스텀 구문자
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\\n");

            if (delimiterEnd == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterEnd));
            numbers = input.substring(delimiterEnd + 2); // \\n은 2개의 문자 임으로 +2 해줘야함
        }

        return Arrays.asList(numbers.split(delimiter));
    }
}