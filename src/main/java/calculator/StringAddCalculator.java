package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
        // 문자열 덧셈 계산기 메인 메소드
        public static int add(String input) {
            // 빈 문자열 처리
            if (input == null || input.isEmpty()) {
                return 0;
            }
    
            // 커스텀 구분자가 있는지 확인
            if (input.startsWith("//")) {
                return addWithCustomDelimiter(input);
            }
    
            // 쉼표 또는 콜론을 구분자로 처리
            return addWithDefaultDelimiters(input);
        }

}

