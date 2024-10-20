package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.CalculatorService;
import calculator.infrastructure.InputStringProcessor;
import calculator.infrastructure.NumberAddProcessor;
import calculator.infrastructure.SplitStrListValidator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        InputStringProcessor inputStringProcessor = new InputStringProcessor();
        NumberAddProcessor numberAddProcessor = new NumberAddProcessor();
        SplitStrListValidator splitStrListValidator = new SplitStrListValidator();

        CalculatorService calculatorService = new CalculatorService(inputStringProcessor, splitStrListValidator,
                numberAddProcessor);

        CalculatorController calculatorController = new CalculatorController(calculatorService);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        try {
            System.out.println("결과 : " + calculatorController.calculate(str));
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
