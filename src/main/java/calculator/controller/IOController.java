package calculator.controller;

import calculator.view.UserInputView;
import calculator.view.UserOutputView;

public class IOController {

    // 입력을 받아오고 출력을 제공하는 뷰와 소통하는 컨트롤러
    public void run() {

        // 사용자로부터 입력을 받아오는 뷰
        String userInput = UserInputView.inputExpression();

        // 입력 받은 문자열의 검사하고 잘못된 경우 IllegalArgumentException을 던짐
        InputValidator.validate(userInput);

        // 입력받은 문자열을 계산하는 컨트롤러
        int result = ExpressionCalculator.calculate(userInput);

        // 계산 결과를 출력하는 뷰
        UserOutputView.outputResult(result);
    }
}
