package calculator.controller;

import calculator.service.Adder;
import calculator.service.Extractor;
import calculator.view.InputView;

import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final Extractor extractor;
    private final Adder adder;

    public CalculatorController(InputView inputView, Extractor extractor, Adder adder) {
        this.inputView = inputView;
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
            adder.addAllNumbers(extractedIntegers);
            System.out.println(adder.addAllNumbers(extractedIntegers));
        }
    }
}
