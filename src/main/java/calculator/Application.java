package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Delimiter;
import calculator.model.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // 모델, 뷰, 컨트롤러 생성
        Delimiter delimiter = new Delimiter();
        Number number = new Number();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorController controller = new CalculatorController(delimiter, number, inputView, outputView);

        // 애플리케이션 실행
        controller.run();
    }
}
