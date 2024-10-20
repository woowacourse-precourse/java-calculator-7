package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

    }

    /**
     * 정규식으로 //와 \n 사이의 구분자를 추출하여 모든 구분자를 반환한다.
     *
     * @param input 구분자를 추출할 문자열
     * @return |로 구분한 기본 구분자와 커스텀 구분자
     * @throws IllegalArgumentException 입력이 //로 시작하였지만 구분자를 찾지 못한 경우
     */
    private static String getDelimiter(String input) throws IllegalArgumentException {
        String delimiters = ",|:";

        // 커스텀 구분자가 없는 경우
        if (!input.startsWith("//")) {
            return delimiters;
        }

        Pattern pattern = Pattern.compile("//(.)\\\\n");
        Matcher matcher = pattern.matcher(input);

        // //로 시작하였지만 구분자를 찾지 못함
        if (!matcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자를 찾을 수 없습니다.");
        }

        String customDelimiter = matcher.group(1);

        // '|'가 구분자로 들어온 경우 이스케이프 처리
        if (customDelimiter.equals("|")) {
            customDelimiter = "\\|";
        }

        delimiters = delimiters + "|" + customDelimiter;

        return delimiters;
    }
}
