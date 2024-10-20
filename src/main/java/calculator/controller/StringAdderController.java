package calculator.controller;

import calculator.model.Delimiter;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class StringAdderController {

    private final InputView inputView;
    private final OutputView outputView;

    public StringAdderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        // 문자열 입력
        String input = inputView.readInputExpression();

        // 계산 수행
        int result = getNumbersArrayWithDelimiter(input);

        // 결과 출력
        outputView.printResult(result);

    }

    private int getNumbersArrayWithDelimiter(String input) {
        Delimiter delimiter = new Delimiter(input);
        String[] stringArray = delimiter.getStringNumbersArray(input);
        List<Integer> stringNumbersArray = delimiter.parse(stringArray);
        return delimiter.sum(stringNumbersArray);
    }


}