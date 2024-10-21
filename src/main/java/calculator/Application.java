package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AddCalculator {
    static Pattern customDelimiterRegex = Pattern.compile("//(.)\\\\n(.*)");

    boolean isCustomDelimiterExisted(String input) {
        Matcher matcher = customDelimiterRegex.matcher(input);
        return matcher.matches();
    }

    String[] validateCustomDelimiterInput(String input) {
        Matcher matcher = customDelimiterRegex.matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        // TODO: 예외 상황 처리 로직 추가

        String customDelimiter = matcher.group(1);

        return matcher.group(2).split(",|:|" + customDelimiter);
    }

    String[] validateDefaultInput(String input) {

        // TODO: 예외 상황 처리 로직 추가

        return input.split("[,:]");
    }

}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        AddCalculator addCalculator = new AddCalculator();
        if (addCalculator.isCustomDelimiterExisted(input)) {
            // 테스트용 출력문
            System.out.println(Arrays.toString(addCalculator.validateCustomDelimiterInput(input)));
        } else {
            // 테스트용 출력문
            System.out.println(Arrays.toString(addCalculator.validateDefaultInput(input)));
        }

        System.out.println("결과 : " + result);
    }
}
