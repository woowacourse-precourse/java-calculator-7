package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 문자열 입력 받기
        System.out.println(("덧셈할 문자열을 입력해 주세요."));
        String input = Console.readLine();

        // InputValidator 클래스 호출
        InputValidator validator = new InputValidator();

        // 빈 문자열 검증
        int result = validator.validateEmptyString(input);
        if (result == 0) {
            System.out.println("결과 : 0");
            return;
        }

        //validator.validateNonNumeric(input);

        // GetNumbers 클래스 호출
        GetNumbers getNumbers = new GetNumbers();
        List<Integer> numbers = getNumbers.extractNumbers(input);

        // 음수값 검증
        validator.validateNegative(numbers);

        // Calculator 클래스 호출
        Calculator calculator = new Calculator();
        int sum = calculator.sumNumbers(numbers);

        System.out.println("결과 : " + sum);
    }
}
