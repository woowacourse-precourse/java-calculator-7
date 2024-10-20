package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CusTomDelimiterParser {

    public String delimiter(String inputString) {

        if (inputString.startsWith("//")) {
            if (!inputString.matches("//.\\\\n.*")) {
                throw new IllegalArgumentException("커스텀 구분자의 문법이 잘못되었습니다.");
            }
        }
        // 정규 표현식 패턴 설정
        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher m = pattern.matcher(inputString);

        // 패턴이 일치하는지 확인
        if (m.find()) {
            return m.group(1); // 사용자 정의 구분자를 반환
        }

        // 패턴이 일치하지 않으면 빈 문자열을 반환
        return "";
    }
}
