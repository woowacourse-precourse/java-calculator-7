package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 문자가 없거나 빈 문자열이 입력되었을 때 0을 반환
    static int calc(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        } else {
            return getSplit(text);
        }
    }

    // 구분자로 문자 나누어서 반환
    private static int getSplit(String text) {
        // 사용자가 \n을 입력한 경우 실제 줄바꿈으로 변환
        text = text.replace("\\n", "\n");

        // 정규식에서 커스텀 구분자와 숫자 부분 추출
        Pattern pattern = Pattern.compile("//(.)\\n(.*)", Pattern.DOTALL);
        Matcher m = pattern.matcher(text);
        String[] tokens;

        // 커스텀 구분자가 있는 경우
        if (m.find()) {
            String customDelimiter = Pattern.quote(m.group(1));  // 커스텀 구분자 추출 및 이스케이프 처리
            String numbers = m.group(2);  // 숫자 부분 추출

            // 1. 커스텀 구분자로 문자열을 분리
            tokens = numbers.split(customDelimiter);
        } else {
            // 커스텀 구분자가 없으면 쉼표나 콜론으로 기본 구분
            tokens = text.split(",|:");
        }

        return sum(tokens);  // 분리된 숫자를 더함
    }

}
