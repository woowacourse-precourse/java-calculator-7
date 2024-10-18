package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        System.out.println("덧셈할 문자열을 입력하세요:");
        // 예외 발생시 종료.
        int result = calculator.calculate();
        System.out.println("결과 : " + result);
    }
}

class StringCalculator {
    static String[] delimiters = {",", ":"};

    public void validateNumber(String num) {
        int value;

        try {
            value = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력이 불가능한 문자가 포함되어있습니다.");
        }

        if (value < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    public int calculate() {
        String input = Console.readLine(); // 사용자 입력 받기

        // null 혹은 빈 문자열을 입력할 경우 0을 반환
        if (input == null || input.isBlank()) {
            return 0;
        }

        if (input.length() == 1) {
            // 구분자 없이 숫자만 입력할 경우, 해당 숫자를 반환
            if (Character.isDigit(input.charAt(0))) {
                return input.charAt(0) - '0';
            }

            // 입력 불가능한 문자
            throw new IllegalArgumentException("입력이 불가능한 문자가 포함되어있습니다.");
        }
        
        int sum = 0;

        // 커스텀 구분자 지정한 경우
        if (input.charAt(0) == '/') {
            String customDelimiter = String.valueOf(input.charAt(2)); // 커스텀 구분자

            String numbersSection = input.substring(5);
            String[] numbers = numbersSection.split(customDelimiter);
            for (String number : numbers) {
                validateNumber(number);  // 항상 validateNumber 호출
                sum += Integer.parseInt(number);
            }
        } else {
            // 기본 구분자로 분리
            String[] numbers = input.split(delimiters[0]);
            for (String number : numbers) {
                // 콜론 구분자로 구분
                String[] splitNumbers = number.split(delimiters[1]);

                for (String num : splitNumbers) {
                    validateNumber(num);  // 항상 validateNumber 호출
                    sum += Integer.parseInt(num);
                }
            }
        }

        return sum;
    }
}