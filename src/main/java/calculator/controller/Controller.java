package calculator.controller;

import calculator.service.Parser;
import calculator.service.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {

    public void run() {
        String inputNumber = getNumber();

        // 계산 메서드
        System.out.println(parseInput(inputNumber));

        // 결과값 출력
        String result = getResult(100);
        System.out.println(result);
    }

    private String getNumber() {
        InputView inputView = new InputView();
        String input = inputView.inputValue();

        return input;
    }

    private String getResult(int answer) {
        OutputView outputView = new OutputView();
        return outputView.getResult(answer);
    }

    private String parseInput(String input) {
        Parser parser = new Parser();
        Validator validator = new Validator();
        StringBuilder sb = new StringBuilder();
        String[] inputArr = parser.parse(input);

        validator.validate(inputArr);

        for (String s : inputArr) {
            sb.append(s).append(", ");
        }
        return sb.toString();
    }
}
