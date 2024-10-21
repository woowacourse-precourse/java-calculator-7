package validator;

import java.util.regex.Pattern;

public class InputValidator {
    public static void validateInput(String input) {
        // 1. 빈 문자열은 허용
        if (input.isEmpty()) {
            return ;
        }

        // 2. 커스텀 구분자를 사용할 경우 형식 검증
        if (input.startsWith("//")) {
            // "\n"이 있는지 확인
            if (!input.contains("\\n")) {
                throw new IllegalArgumentException("잘못된 형식입니다. 커스텀 구분자는 //와 \\n 사이에 있어야 합니다.");
            }

            // 커스텀 구분자와 숫자 부분을 "\\n" 기준으로 분리
            String[] parts = input.split("\\\\n", 2);


            if (parts.length < 2 || parts[1].isEmpty()) {
                throw new IllegalArgumentException("잘못된 형식입니다. \\n 이후에 숫자가 있어야 합니다.");
            }


            // 커스텀 구분자를 추출
            String customDelimiter = parts[0].substring(2);  // "//" 이후의 구분자 추출
            String numbersPart = parts[1];

            // 커스텀 구분자를 사용하여 숫자 분리
            String[] tokens = numbersPart.split(Pattern.quote(customDelimiter));

            for (String token : tokens) {
                if (!token.matches("\\d+")) {
                    throw new IllegalArgumentException("잘못된 숫자가 포함되어 있습니다: " + token);
                }
            }
        } else {
            // 3. 기본 구분자 쉼표와 콜론으로 구분
            String[] tokens = input.split("[,|:]");

            for (String token : tokens) {
                if (!token.matches("\\d+")) {
                    throw new IllegalArgumentException("잘못된 숫자가 포함되어 있습니다: " + token);
                }
            }
        }
    }

}
