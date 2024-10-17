package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine(); // 사용자 입력을 받음
        int result = add(input); // 입력 처리
        System.out.println("결과 : " + result); // 결과 출력
    }

    // 입력된 문자열에서 숫자를 추출하여 더하는 메서드
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열 또는 null이면 0 반환
        }

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            return sumWithCustomDelimiter(input);
        }

        // 기본 구분자 처리
        return sumWithDefaultDelimiter(input);
    }

    // 기본 구분자로 문자열을 분리하여 합산하는 메서드
    private static int sumWithDefaultDelimiter(String input) {
        String[] numbers = input.split("[,|:]"); // 쉼표와 콜론으로 분리
        return calculateSum(numbers);
    }

    // 커스텀 구분자로 문자열을 분리하여 합산하는 메서드
    private static int sumWithCustomDelimiter(String input) {
        String[] parts = input.split("\\n", 2); // 구분자를 설정한 줄과 숫자 부분 분리
        String delimiter = parts[0].substring(2); // "//" 이후의 문자
        String[] numbers = parts[1].split(delimiter); // 커스텀 구분자로 분리
        return calculateSum(numbers);
    }

    // 주어진 문자열 배열의 합산을 계산하는 메서드
    private static int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (isNumeric(number)) {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다"); // 음수 예외 처리
                }
                sum += num;
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다. 숫자만 입력할 수 있습니다."); // 잘못된 입력 처리
            }
        }
        return sum;
    }

    // 주어진 문자열이 숫자인지 확인하는 메서드
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str); // 문자열을 정수로 변환 시도
            return true; // 변환 성공 시 true 반환
        } catch (NumberFormatException e) {
            return false; // 변환 실패 시 false 반환
        }
    }
}