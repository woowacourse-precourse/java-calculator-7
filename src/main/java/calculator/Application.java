package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // 사용자 입력 받기

        try {
            int result = calculator(input); // 계산 결과
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("에러: " + e.getMessage());
        }
    }

    public static int calculator(String input) {

        // 입력이 null 또는 빈 문자열이면 0을 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 입력에서 공백 제거
        input = input.replaceAll(" ", "");

        // 기본 구분자로 계산
        return defaultCalculator(input);
    }

    private static int defaultCalculator(String input) {

        // 길이가 1인 경우 숫자 하나만 있는 것이므로 바로 반환
        if (input.length() == 1) {
            return isPositive(input);
        }

        // 기본 구분자(, 또는 :)를 포함하는 경우 분리 후 합산
        if (input.contains(",") || input.contains(":")) {
            return sum(input.split(",|:"));
        }

        // 커스텀 구분자 처리
        return customCalculator(input);
    }

    private static int customCalculator(String input) {
        Matcher matcher = Pattern.compile("//(.*?)\n(.*)").matcher(input); // 수정된 정규식
        if (matcher.find()) {
            // 커스텀 구분자 추출
            String delimiter = matcher.group(1);
            String numbers = matcher.group(2);

            // 커스텀 구분자로 숫자 분리 후 합산
            return sum(numbers.split(Pattern.quote(delimiter)));
        }

        // 잘못된 입력일 경우 0 반환
        return 0;
    }

    private static int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            total += isPositive(number); // 음수 체크 및 합산
        }
        return total;
    }

    private static int isPositive(String input) {
        int number;
        try {
            number = Integer.parseInt(input); // 숫자로 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자가 입력되었습니다.");
        }

        // 음수 처리
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
        }

        return number;
    }
}
