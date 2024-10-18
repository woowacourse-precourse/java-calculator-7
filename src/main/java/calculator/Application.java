package calculator;

import camp.nextstep.edu.missionutils.Console;
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

        // 기본 구분자로 숫자 합 계산
        String[] numbers = input.split(delimiters[0]);  // "," 분리하기!
        int sum = 0;
        for (String number : numbers) {
            String[] splitNumbers = number.split(delimiters[1]); //":" 분리하기!
            for (String num : splitNumbers) {
                sum += Integer.parseInt(num);
            }
        }

        return sum;
    }
}