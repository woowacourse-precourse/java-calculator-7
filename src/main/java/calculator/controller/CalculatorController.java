package calculator.controller;

import calculator.model.Calculator;
import calculator.model.InputValidator;
import calculator.view.ConsoleView;


public class CalculatorController {
    private final Calculator calculator;
    private final InputValidator validator;
    private final ConsoleView view;

    public CalculatorController(Calculator calculator, InputValidator validator, ConsoleView view) {
        this.calculator = calculator;
        this.validator = validator;
        this.view = view;
    }

    //사용자 입력을 받아 모델의 덧셈 기능 호출
    public void run() {
        try {
            String input = view.getInput();
            validator.validate(input);

            //모델에서 계산된 결과를 받아 뷰에 전달
            int result = calculator.add(input);
            view.printResult(result);

        }catch (IllegalArgumentException e) {
            //사용자에게 잘못된 입력에 대한 예외 처리를 수행하여 적절한 메시지 출력
            view.printErrorMessage(e.getMessage());
        }
    }
}

