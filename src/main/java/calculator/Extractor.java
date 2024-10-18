package calculator;

import static calculator.Constant.BASIC_DELIMITER_1;
import static calculator.Constant.BASIC_DELIMITER_2;
import static calculator.Constant.CUSTOM_DELIMITER_END;
import static calculator.Constant.CUSTOM_DELIMITER_START;
import static calculator.Constant.REGEX_PIPE_OPERATOR;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class Extractor {

    public static String[] extractStrNumArray(String input) {
        // 구분자 정의
        String[] delimiter = new String[3];
        delimiter[0] = BASIC_DELIMITER_1;
        delimiter[1] = BASIC_DELIMITER_2;

        // 커스텀 구분자 확인
        if (input.startsWith(CUSTOM_DELIMITER_START)) {
            int customEndIndex = input.indexOf(CUSTOM_DELIMITER_END);
            delimiter[2] = input.substring(2, customEndIndex);

            // 커스텀 구분자가 숫자인 경우
            if (delimiter[2].matches("^\\d+$")) {
                throw new IllegalArgumentException("숫자 추출에서 유효하지 않은 값이 검출되었습니다.");
            }

            // 커스텀 구분자 필드 제거
            input = input.substring(customEndIndex + 2);
        }

        // 구분자 배열을 안전하게 정규식 패턴으로 변환
        // ex. {",", ":", null} -> \Q,\E|\Q:\E
        String delimiterRegex = Arrays.stream(delimiter)
                .filter(Objects::nonNull)
                .map(Pattern::quote)
                .reduce((d1, d2) -> d1 + REGEX_PIPE_OPERATOR + d2)
                .orElse("");

        // 문자열이 빈 경우 0으로 처리
        if (input.isBlank()) {
            input = "0";
        }

        // 숫자 추출
        String[] strNumArray = input.split(delimiterRegex);

        // 커스텀 구분자가 제거된 문자열이 올바른 형태인지 검증한다.
        Validator.validateConvertedInput(input, delimiterRegex, strNumArray);

        return strNumArray;
    }
}
