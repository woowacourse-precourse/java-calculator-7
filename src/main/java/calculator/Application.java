package calculator;

import calculator.controller.Controller;
import calculator.model.Delimiter;
import calculator.model.Extractor;
import calculator.model.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Delimiter delimiter = new Delimiter();
        Numbers numbers = new Numbers();
        Extractor extractor = new Extractor();
        Controller controller = new Controller(delimiter, extractor, numbers);

        outputView.printInputMessage();
        Integer result = controller.execute(inputView.readInput());
        outputView.printResultMessage(String.valueOf(result));
    }
}
