package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 문자열 입력 받기
        System.out.println(("덧셈할 문자열을 입력해 주세요."));
        String input = Console.readLine();

        // GetNumbers 클래스 호출
        GetNumbers getNumbers = new GetNumbers();
        List<Integer> numbers = getNumbers.extractNumbers(input);

        // Calculator 클래스 호출
        Calculator calculator = new Calculator();
        int result = calculator.sumNumbers(numbers);
    }
}
