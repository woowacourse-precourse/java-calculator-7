package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine(); // 사용자로부터 입력 받기
        int result = calculateSum(input);   // 입력된 문자열을 계산
        System.out.println("결과 : " + result); // 결과 출력
    }

    private static int calculateSum(String input) {
        if (input.isEmpty()) {
            return 0; // 빈 문자열 입력 시 0 반환
        }
        String delimiter = ",|:"; // 기본 구분자
        List<Integer> numbers = parseNumbers(input, delimiter);
        return sumNumbers(numbers); // 숫자 합산
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
}
