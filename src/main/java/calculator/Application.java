package calculator;

import calculator.io.InputView;
import calculator.io.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            String inputString = InputView.printInputAddString();
            List<String> digits = Division.split(inputString);
            result(digits);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    private static void result(List<String> digits) {
        int sum = Calculator.sumPositiveNumbers(digits);
        OutputView.printResult(sum);
    }
}
