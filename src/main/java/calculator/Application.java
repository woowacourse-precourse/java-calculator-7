package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputValidator inputValidator = new InputValidator();
        StringSplitter stringSplitter = new StringSplitter();
        Calculator calculator = new Calculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (!inputValidator.isValid(input)){
            throw new IllegalArgumentException("잘못된 입력입니다. " + input);
        }
        // 입력 문자열을 구분자로 분리하고 숫자를 추출
        List<Integer> numbers = stringSplitter.split(input);
        // 추출된 숫자의 합 계산
        int result = calculator.calculateSum(numbers);
        System.out.println("결과 : " + result);

    }
}
