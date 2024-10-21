package calculator;

import calculator.calculate.CalculateService;
import calculator.calculate.CalculateServiceImpl;
import calculator.controller.CalculateController;
import calculator.separator.SeparatorService;
import calculator.separator.SeparatorServiceImpl;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        SeparatorService separatorService = new SeparatorServiceImpl();
        CalculateService calculateService = new CalculateServiceImpl();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        // CalculateController 인스턴스 생성 및 실행
        CalculateController controller =
                new CalculateController(separatorService, calculateService, inputView, outputView);
        controller.run();
    }
}
