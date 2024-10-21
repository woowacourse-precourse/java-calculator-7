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

            if (matcher.find()) {
                String capturedDelimiter = matcher.group(1);
                String inputAfterDelimiter = matcher.group(2);
                String[] numbers = inputAfterDelimiter.split(capturedDelimiter);
                // int 배열로 변경
            } else {
                String defaultDelimiter = "[,|:]";
                String[] numbers = input.split(defaultDelimiter);
                // int 배열로 변경
            }
        }

    }
}
