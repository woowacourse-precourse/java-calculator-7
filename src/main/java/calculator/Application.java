package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        System.out.println("덧셈할 문자열을 입력하세요:");
        int result = calculator.calculate();
        System.out.println("결과 : " + result);
    }
}

class StringCalculator {
    static String[] delimiters = {",", ":"}; // 쉼표와 콜론 구분자

    public int calculate() {
        String input = Console.readLine(); // 사용자 입력 받기

        // null 혹은 빈 문자열을 입력할 경우 0을 반환
        if (input == null || input.isBlank()) {
            return 0;
        }

        // 숫자 하나만 입력되었을 경우 해당 숫자를 반환
        if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
            return Integer.parseInt(input);
        }

        // 커스텀 구분자 지정한 경우
        if (input.startsWith("//")) {
            String customDelimiter = input.substring(2, 3); // 커스텀 구분자
            input = input.substring(4);  // 실제 숫자 문자열 부분 추출
            String[] numbers = input.split(customDelimiter);
            return sumNumbers(numbers);
        }

        // 기본 구분자로 숫자 합 계산
        String[] numbers = input.split(delimiters[0]);  // 쉼표로 분리
        return sumNumbers(numbers);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            String[] splitNumbers = number.split(delimiters[1]);  // 콜론으로 분리
            for (String num : splitNumbers) {
                validateNumber(num);  // 음수 체크
                sum += Integer.parseInt(num);
            }
        }
        return sum;
    }

    private void validateNumber(String num) {
        int value = Integer.parseInt(num);
        if (value < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}