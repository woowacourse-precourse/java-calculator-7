package calculator;

import calculator.controller.CalculatorController;
import calculator.model.DelimiterExtractor;
import calculator.model.StringCalculator;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {

        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        StringCalculator calculator = new StringCalculator(delimiterExtractor);
        CalculatorView view = new CalculatorView();

        // 의존성을 주입받아 컨트롤러 인스턴스 생성
        CalculatorController controller = new CalculatorController(calculator, view);
        controller.run();
        // TODO: 프로그램 구현
    }
}
