package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {


    /**
     * caculate 메소드 입력값의 유효성을 검증하고 구분자를 통해 문자열에서 숫자를 추출한다.
     *
     * @param input
     * @return
     */
    public int caculate(String input) {
        if (input == null || input.isEmpty()) { //입력값이 null 혹은 비어있다면
            return 0;   // 0을 반환한다.
        }

        String delimiter = ",|:"; //기본 구분자
        //커스텀 구분자
        if (input.startsWith("//") && input.contains("\n")) {
            Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                input = matcher.group(2);
            }
        }

        String[] numbers = input.split(delimiter);

    }
}
