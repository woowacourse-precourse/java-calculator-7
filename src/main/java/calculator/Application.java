package calculator;

import calculator.calculate.Calculator;
import calculator.input.InputHandler;
import calculator.input.Validator;
import calculator.parse.StringParser;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        StringParser stringParser = new StringParser();
        InputHandler inputHandler = new InputHandler(validator, stringParser);

        // 입력 처리 및 검증
        String input = inputHandler.getInput();

        // 입력 받은 값을 숫자 배열로 변환
        int[] numbers = stringParser.convertStringToIntArray(input);

        Calculator calculator = new Calculator();
        int sum = calculator.calculateNumbers(numbers);

        System.out.println("결과 : " + sum);
    }
}
