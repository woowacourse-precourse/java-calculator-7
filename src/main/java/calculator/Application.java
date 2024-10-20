package calculator;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        InputHandler.input();
        CustomValidator.validate(InputHandler.getInputData());
        ArrayList<Integer> numbers = InputParser.parse();
        int result = Calculator.sum(numbers);
        System.out.printf("결과 : %d", result);

    }
}
