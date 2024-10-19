package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        StringConvertFactory stringConvertFactory = new StringConvertFactory();
        String[] numbers = stringConvertFactory.parseString(input);

        if (numbers.length == 1) {
            System.out.println("결과 : " + numbers[0]);
            return;
        }
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(numbers);

        System.out.println("결과 : " + result);
    }
}
