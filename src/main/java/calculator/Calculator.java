package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static void run() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // 문자열 입력

        if (checkEmpty(input)) { // 입력 문자열 비어있는지 확인
            System.out.println("결과 : 0");
            return;
        }

        List<String> numbers = splitByDelimiters(input);  // 구분자로 숫자 분리
        System.out.println("결과 : " + sum(numbers)); // 결괏값 출력
    }

    // 입력한 문자열이 비었는지 확인 -> 비었으면 0 출력
    public static boolean checkEmpty(String input) {
        return input == null || input.isEmpty();
    }

    // 입력된 문자열에서 구분자로 숫자 분리
    public static List<String> splitByDelimiters(String input) {
        if (input.startsWith("//")) {
            return splitByCustomDelimiter(input);  // 커스텀 구분자 처리
        } else {
            return splitByDefaultDelimiters(input); // 기본 구분자 처리
        }
    }

    // 기본 구분자로 문자열을 분리
    private static List<String> splitByDefaultDelimiters(String input) {
        // 문자열에서 기본 구분자 외에 다른 문자가 있는지 확인
        if (input.matches(".*[^0-9, :, -].*")) {
            throw new IllegalArgumentException("기본 구분자 외 다른 문자가 포함되어 있습니다.");
        }
        return Arrays.asList(input.split("[,:]"));
    }

    // 커스텀 구분자로 문자열을 분리
    private static List<String> splitByCustomDelimiter(String input) {
        if (!input.contains("\\n")) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 선언 형식 입니다.");
        }
        int startIndex = 2; // 커스텀 구분자의 시작 인덱스
        int endIndex = input.indexOf("\\n"); // 구분자와 숫자 부분을 분리
        String customDelimiters = input.substring(startIndex, endIndex); // 커스텀 구분자 추출

        String numbers = input.substring(endIndex + 2); // 숫자 부분 추출
        String delimiters = "[" + customDelimiters + ",:]"; // 커스텀 구분자와 기본 구분자를 모두 포함
        return Arrays.asList(numbers.split(delimiters)); // 최종 구분자로 문자열을 분리
    }

    // 숫자 합산
    public static int sum(List<String> numbers) {
        int total = 0;
        for (String number : numbers) {
            validateNumber(number);  // 숫자 유효성 검사
            total += Integer.parseInt(number);
        }
        return total;
    }

    // 숫자 유효성 검사
    private static void validateNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            validatePositive(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자열에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    // 양수 유효성 검사
    private static void validatePositive(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("숫자는 오직 양수만 허용 됩니다.");
        }
    }
}