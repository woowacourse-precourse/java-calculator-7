package calculator.controller;

import calculator.service.Extractor;
import calculator.view.InputView;

import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final Extractor extractor;

    public CalculatorController(InputView inputView, Extractor extractor) {
        this.inputView = inputView;
        this.extractor = extractor;
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
            System.out.println(extractedIntegers);
        }
    }
}
