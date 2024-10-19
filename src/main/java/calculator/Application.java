package calculator;

import calculator.view.InputView;
import java.util.List;

public class Application {

    private Application() {
    }

    public static void main(String[] args) {
        List<Integer> numbers = InputView.inputNumbers();
        System.out.println(Calculator.sum(numbers));
    }
}
