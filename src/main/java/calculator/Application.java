package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        // System.out.println("입력값: " + input);
        int result = StringCalculator.add(input);
        System.out.println("결과 : " + result);
    }
}

class StringCalculator{
    public static int add(String input){
        String[] numbers = input.split(",|:");
        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers){
        int sum = 0;
        for (String number : numbers){
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }
}
