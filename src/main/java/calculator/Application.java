package calculator;

import calculator.model.UserInput;
import calculator.service.SplitMethod;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInput userInput = new UserInput();
        SplitMethod splitMethod = new SplitMethod();

        System.out.println("덧셈할 문자열을 입력.");

        String input = userInput.input();

        int result = splitMethod.split(input);

        System.out.println("결과 : " + result);
    }
}
