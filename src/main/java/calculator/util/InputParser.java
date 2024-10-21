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