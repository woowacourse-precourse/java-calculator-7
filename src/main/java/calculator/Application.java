package calculator;

import static calculator.Constant.BASIC_DELIMITER_1;
import static calculator.Constant.BASIC_DELIMITER_2;
import static calculator.Constant.CUSTOM_DELIMITER_END;
import static calculator.Constant.CUSTOM_DELIMITER_START;
import static calculator.Constant.INPUT_GUIDE;
import static calculator.Constant.OUTPUT_RESULT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        // 입력
        System.out.println(INPUT_GUIDE);
        String input = Console.readLine();

        // 구분자 정의
        String[] delimiter = new String[3];
        delimiter[0] = BASIC_DELIMITER_1;
        delimiter[1] = BASIC_DELIMITER_2;

        // 커스텀 구분자 확인
        if (input.startsWith(CUSTOM_DELIMITER_START)) {
            int customEndIndex = input.indexOf(CUSTOM_DELIMITER_END);
            delimiter[2] = input.substring(2, customEndIndex);

            // 커스텀 구분자 필드 제거
            input = input.substring(customEndIndex + 2);
        }

        // 구분자 배열을 안전하게 정규식 패턴으로 변환
        // ex. {",", ":", null} -> \Q,\E|\Q:\E
        String delimiterRegex = Arrays.stream(delimiter)
                .filter(Objects::nonNull)
                .map(Pattern::quote)
                .reduce((d1, d2) -> d1 + "|" + d2)
                .orElse("");

        // 숫자 추출
        String[] split = input.split(delimiterRegex);
        int result = 0;
        for (String strNum : split) {
            if (strNum.isBlank()) {
                continue;
            }
            result += Integer.parseInt(strNum);
        }

        // 출력
        System.out.println(OUTPUT_RESULT + result);

        // scanner 닫기
        Console.close();
    }
}
