package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {
    private static String input;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자로부터 입력을 받는다.
        System.out.print("덧셈할 문자열을 입력해 주세요: "); // 프롬프트 메시지 출력
        String input = Console.readLine(); // 매개변수 없이 호출
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    public static int add(String input) {
        // 입력이 비어있다면 0을 반환
        if (input.isEmpty()) {
            return 0;
        }

        // 커스텀 구분자 처리
        String delimiter = ",|:"; // 기본 구분자
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            // 커스텀 구분자 추출
            delimiter = Pattern.quote(input.substring(2, delimiterEndIndex)); // Escape special characters
            input = input.substring(delimiterEndIndex + 1);
        }

        // 입력에서 숫자 추출
        String[] numbers = input.split(delimiter);
        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int num = parseNumber(number);
            total += num;
        }
        return total;
    }

    private static int parseNumber(String number) {
        // 숫자가 비어있거나 공백만 있는 경우
        if (number.trim().isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        int num = Integer.parseInt(number.trim());
        // 음수는 허용되지 않음
        if (num < 0) {
            throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
        }
        return num;
    }

}