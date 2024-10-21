package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        try { // 입력
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            // 계산 수행
            int result = calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
           // 예외 발생 시 프로그램 종료
            System.err.println(e);
        }
    }

    // 문자열 계산
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열은 0 반환
        }

        // 기본 구분자 처리
        String delimiter = ",|:";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자를 추출
                input = matcher.group(2); // 커스텀 구분자 이후의 숫자 문자열
            } else {
                throw new IllegalArgumentException();
            }
        }

        // 구분자로 문자열을 분리하여 숫자 추출
        String[] numbers = input.split(delimiter);
        return sum(numbers); // 숫자들의 합 계산
    }

    // 숫자 배열을 받아서 합을 계산
    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = parseNumber(number); // 숫자로 변환
            sum += num;
        }
        return sum;
    }

    // 입력값이 숫자인지 확인하고, 잘못된 값이면 예외 발생
    private static int parseNumber(String number) {
        int num;
        try {
            num = Integer.parseInt(number.trim()); // 문자열을 정수로 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // 잘못된 값일 경우 예외 발생
        }
        return num;
    }
}
