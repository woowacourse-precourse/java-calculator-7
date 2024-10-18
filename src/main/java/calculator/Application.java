package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // Console API로 입력받기

        try {
            long result = calculate(input); // 결과 계산
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static long calculate(String input) {
        // 빈 문자열 또는 null 처리
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열 또는 null일 때 0 반환
        }

        // 정규 표현식으로 커스텀 구분자 추출
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        String delimiter = ",|:"; // 기본 구분자
        String numbers = input; // 숫자 문자열 초기화

        if (matcher.find()) {
            delimiter = matcher.group(1); // 커스텀 구분자
            numbers = matcher.group(2); // 나머지 숫자 문자열
        }

        // 입력 문자열을 구분자로 나누기
        String[] tokens = numbers.split("[,:" + Pattern.quote(delimiter) + "]"); // 기본 구분자 및 커스텀 구분자로 나누기
        long sum = 0;

        // 숫자를 하나씩 합산
        for (String numberStr : tokens) {
            validateNumber(numberStr); // 숫자 유효성 검증
            sum += Long.parseLong(numberStr); // 문자열을 숫자로 변환 후 합산
        }

        return sum; // 최종 합계 반환
    }

    // 유효한 숫자인지 확인하는 메서드
    private static void validateNumber(String numberStr) {
        if (numberStr.isEmpty()) { // 숫자가 없으면 예외 발생
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다!");
        }
        try {
            long number = Long.parseLong(numberStr); // 문자열을 숫자로 변환
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다!"); // 유효하지 않은 숫자 처리
        }
    }
}
