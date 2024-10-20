package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해주세요.");
            String input = Console.readLine().trim();
            int result = calculateSum(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgument Exception: " + e.getMessage());
        }
    }

    public static int calculateSum(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        // 예외 처리: 문자열이 "//"로 시작하지 않거나 숫자가 아닌 다른 기호로 시작하는 경우
        if (!input.startsWith("//") && !input.matches("^[0-9,:]+$")) {
            throw new IllegalArgumentException("유효한 입력이 아닙니다.");
        }

        // 알파벳이나 한글이 포함된 경우 예외 처리
        if (input.matches(".*[A-Za-z가-힣]+.*")) {
            throw new IllegalArgumentException("한글과 알파벳은 입력할 수 없습니다.");
        }

        // 구분자 추출
        String[] numbers = extractNumbers(input);
        return sumNumbers(numbers);
    }

    private static String[] extractNumbers(String input) {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);

        String[] numbers;
        // 커스텀 구분자가 있는 경우
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numberPart = matcher.group(2);
            // 예외 처리: 구분자 뒤에 숫자 부분이 없는 경우
            if (numberPart.isEmpty()) {
                throw new IllegalArgumentException("구분자 뒤에 숫자가 없습니다.");
            }
            numbers = numberPart.split(Pattern.quote(customDelimiter));
        } else {
            // 기본 구분자 (, 또는 :)
            numbers = input.split(",|:");
        }

        // 예외 처리: 문자열이 구분자로 끝나는 경우
        if (input.endsWith(",") || input.endsWith(":")) {
            throw new IllegalArgumentException("문자열이 구분자로 끝날 수 없습니다.");
        }

        return numbers;
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            number = number.trim(); // 공백 제거
            if (number.isEmpty()) {
                continue; // 빈 문자열은 무시
            }
            try {
                int value = Integer.parseInt(number);
                // 예외 처리: 음수 입력
                if (value < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + value);
                }
                sum += value;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닙니다: " + number);
            }
        }

        return sum;
    }
}
