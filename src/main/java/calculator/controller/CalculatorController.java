package calculator.controller;

import calculator.exception.CalculatorException;
import calculator.service.CalculatorService;
import calculator.service.ParsingService;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    private final ParsingService parser;
    private final CalculatorService calculator;
    private final InputView inputView;

    private final OutputView outputView;

    public CalculatorController() {
        this.parser = new ParsingService();
        this.calculator = new CalculatorService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            // 문자열 입력
            String input = inputView.input();

            // 문자열 파싱
            List<String> numbers = parser.parse(input);

            // 덧셈 결과 계산
            String result = calculator.add(numbers);

            // 결과 출력
            outputView.printResult(result);

        } catch (CalculatorException e) {
            // 예외 발생 시 메시지 출력
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
