package calculator.controller;

import calculator.service.Calculator;
import calculator.service.Parser;
import calculator.service.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Parser parser = new Parser();
    private final Validator validator = new Validator();
    private final Calculator calculator = new Calculator();

    public void run() {
        // 입력 받아오기
        String inputNumber = inputView.inputValue();

        // 파싱 및 검증
        String[] inputArr = parseAndValidate(inputNumber);

        // 계산
        int sum = calculator.sumNumber(inputArr);

        // 결과 출력
        String result = outputView.getResult(sum);
        System.out.println(result);
    }

    private String[] parseAndValidate(String input) {
        String[] parsedInput = parser.parse(input);
        validator.validate(parsedInput);
        return parsedInput;
    }
}
