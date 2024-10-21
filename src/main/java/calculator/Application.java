package calculator;


import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.Validator;
import calculator.view.ConsoleView;

/*
-fix 사항: 오류 사유를 명확히 출력할 수 있도록 Validation 수정하기
-test: customTest로 edge case 확인하기 
-refac
 */
public class Application {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        Calculator calculator = new Calculator();
        Validator validator = new Validator();
        CalculatorController controller = new CalculatorController(calculator, validator, view);

        controller.run();

    }
}

