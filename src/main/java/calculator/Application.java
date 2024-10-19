package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
        } else {
            String delimiter = "[,:]";
            // 커스텀 문자열 추가 시작
            String patternString = "(//(.*)\\\\n)?(.*)";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(input);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("입력 형식이 올바르지 않습니다");
            }
            String customDelimiter = matcher.group(2);
            String numberAndDelimiter = matcher.group(3);
            if (customDelimiter != null) {
                // "\" 을 문자열 자체로 취급하려면 "\\"으로 작성해야 한다.
                customDelimiter = customDelimiter.replace("\\", "\\\\");
                delimiter = "[,:" + customDelimiter + "]";
            }
            // 커스텀 문자열 추가 종료

            // 2번째 인수로 limit==-1 로 선언하면 마지막까지 공백으로 받을 수 있음.
            String[] tokens = numberAndDelimiter.split(delimiter, -1);
            int sum = 0;
            for (String token : tokens) {
                int number = parseString(token);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력 불가합니다");
                }
                sum += number;
            }
            System.out.println("결과 : " + sum);
            Console.close();
        }

    }

    private static int parseString(String token) {
        try {
            return Integer.parseInt(token);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다");
        }
    }
}
