package calculator.controller;

import calculator.service.Adder;
import calculator.service.Extractor;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Extractor extractor;
    private final Adder adder;

    public CalculatorController(InputView inputView, OutputView outputView, Extractor extractor, Adder adder) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.extractor = extractor;
        this.adder = adder;
    }

    public void start() {
        while (true) {

            // TODO:
            //  시작 시 InputView 객체 생성해서 사용자 입력 받고
            //  validate하고
            //  add하고
            //  return한다.(OutputView)

            String input = inputView.getUserInput();               // 사용자 입력 받기
            List<Integer> extractedIntegers = extractor.extractNumbers(input);

            // TODO 만약 추출했는데 null이라면 ?
            int result = adder.addAllNumbers(extractedIntegers);
            outputView.printAllAddedResult(result);
            break;
        }
    }
}
