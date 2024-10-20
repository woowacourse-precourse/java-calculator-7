package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    // 문자열에서 숫자를 추출하고 합을 계산하는 함수
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열일 경우 0 반환
        }

        String delimiter = ",|:"; // 기본 구분자 쉼표와 콜론
        String numbers = input;

        // 구분자를 기준으로 숫자 분리
        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
