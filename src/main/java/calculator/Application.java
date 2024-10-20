package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 받기 (한 줄로 입력)
        String input = Console.readLine();

        // 빈 문자열 또는 null 처리
        if (input == null || input.trim().isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        int sum = add(input);
        System.out.println("결과 : " + sum);
    }

    public static int add(String text) {
        String[] tokens = split(text);
        int sum = 0;
        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty()) {
                continue; // 빈 문자열 처리
            }
            int number = toPositiveInt(token);
            sum += number;
        }
        return sum;
    }

    private static String[] split(String text) {
        String numbers = text;
        String delimiter = ",|:";

        if (text.startsWith("//")) {
            Matcher m = Pattern.compile("//(.)\\\\n(.*)").matcher(text);
            if (m.find()) {
                String customDelimiter = m.group(1);
                numbers = m.group(2);

                // 구분자에 특수 문자가 포함된 경우를 대비하여 Pattern.quote 사용
                delimiter = Pattern.quote(customDelimiter);
            } else {
                throw new IllegalArgumentException("잘못된 형식입니다: " + text);
            }
        }

        return numbers.split(delimiter);
    }



    private static int toPositiveInt(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
        }
    }
}
