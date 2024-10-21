package calculator;

import java.util.regex.Pattern;

public class Calculator {

    // 쉼표(,) 또는 콜론(:)을 구분자로 숫자를 추출하는 메서드
    public String[] extractNumbers(String input) {
        // 빈 문자열을 받았다면 0이 담긴 배열을 반환
        if (input.isEmpty()) {
            return new String[]{"0"};
        }

        // 커스텀 구분자 지원 ("//[구분자]\n[구분자로 나뉜 숫자들]" 형식인 경우)
        if (input.startsWith("//")) {
            // 구분자를 추출
            String delimiter = input.substring(2, input.indexOf("\n"));
            // 입력된 문자열에서 숫자 부분 시작 추출
            String numbersPart = input.substring(input.indexOf("\n") + 1);

            // 커스텀 구분자를 기준으로 숫자를 분리
            return numbersPart.split(Pattern.quote(delimiter));
        }

        // 쉼표(,) 또는 콜론(:)을 기준으로 숫자를 분리
        return input.split("[,:]");
    }
}
