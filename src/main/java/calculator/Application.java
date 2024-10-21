package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine(); // 사용자로부터 입력 받기
        int result = calculateSum(input);   // 입력된 문자열을 계산
        System.out.println("결과 : " + result); // 결과 출력
    }

    private static int calculateSum(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = determineDelimiter(input);
        input = removeDelimiterHeader(input);
        List<Integer> numbers = parseNumbers(input, delimiter);
        return sumNumbers(numbers);
    }

    private static List<Integer> parseNumbers(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(Application::convertToInteger)
                .collect(Collectors.toList());
    }

    private static int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum(); // 숫자 합산
    }

    private static int convertToInteger(String s) {
        return Integer.parseInt(s); // 문자열을 정수로 변환
    }

    private static String determineDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            return extractCustomDelimiter(input); // 커스텀 구분자 추출
        }
        return ",|:"; // 기본 구분자
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//"); // 커스텀 구분자 확인
    }

    private static String extractCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.*?)\\\\n").matcher(input);
        if (matcher.find()) {
            return Pattern.quote(matcher.group(1)); // 커스텀 구분자 반환
        }
        throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다."); // 잘못된 경우 예외 처리
    }

    private static String removeDelimiterHeader(String input) {
        return input.contains("\\n") ? input.split("\\\\n", 2)[1] : input; // 구분자 헤더 제거
    }
}
