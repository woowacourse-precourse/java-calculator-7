package calculator.controller;

import calculator.model.Calculator;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * 해당 클래스는 전체적인 계산기 서비스를 연결하는 컨트롤러 클래스입니다.
 *
 * @author Kalsteve98
 * @since 1.0
 */
public class MainController {
    /**
     * 사용자로부터 입력을 받는 뷰
     */
    private final InputView inputView;
    /**
     * 결과를 출력하는 뷰
     */
    private final OutputView outputView;
    /**
     * 계산을 위한 클래스
     */
    private final Calculator calculator;
    /**
     * 계산기 서비스를 제공하는 서비스 클래스
     */
    private final CalculatorService calculatorService;

    /**
     * MainController의 생성자입니다.
     */
    public MainController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.calculator = new Calculator();
        this.calculatorService = new CalculatorService(inputView, outputView, calculator);
    }

    /**
     * 계산기 서비스를 실행하는 메서드입니다.
     */
    public void run() {
        calculatorService.run();
    }


}
