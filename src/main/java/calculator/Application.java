package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (!input.isEmpty()) {
            String customDelimiter = "^//(.)\\\\n(.*)";
            Pattern pattern = Pattern.compile(customDelimiter);
            Matcher matcher = pattern.matcher(input);
            String[] numbers;

            if (matcher.find()) {
                String capturedDelimiter = matcher.group(1);
                String inputAfterDelimiter = matcher.group(2);
                numbers = inputAfterDelimiter.split(Pattern.quote(capturedDelimiter));
            } else {
                String defaultDelimiter = "[,|:]";
                numbers = input.split(defaultDelimiter);
            }
            int sum = 0;
            for (String number : numbers) {
                int parsedNumber = Integer.parseInt(number);
                if (parsedNumber < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                sum += parsedNumber;
            }
            System.out.println("결과 : " + sum);
        }

    }
}
