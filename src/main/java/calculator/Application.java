package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Application {

    private Application() {
    }

    public static void main(String[] args) {
        List<Integer> numbers = InputView.inputNumbers();
        int result = Calculator.sum(numbers);
        OutputView.print(result);
    }
}
