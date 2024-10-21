package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int res = calSum(input);
            System.out.println("결과 : " + res);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static int calSum(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String separator = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            /*
            "//" : 리터럴
            (.) : 구분자로 사용될 문자
            "\\\\n" : 실제 \n를 표현 정규표현식
            "(.*) : numbers
             */
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
            if (matcher.find()) {
                separator = Pattern.quote(matcher.group(1));
                numbers = matcher.group(2);
            } else {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
        }
        return Arrays.stream(numbers.split(separator))
                .filter(s -> !s.isEmpty())
                .mapToInt(Application::parseNumbers)
                .sum();
    }

    private static int parseNumbers(String numbers) {
        try {
            int number = Integer.parseInt(numbers.trim());
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식: " + numbers);
        }
    }
}
