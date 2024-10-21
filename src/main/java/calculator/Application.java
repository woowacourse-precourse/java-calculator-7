package calculator;

import calculator.domain.SumCalculator;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        SumCalculator sumCalculator = new SumCalculator();

        String input = inputView.askAddNumbers();
        int result = sumCalculator.sum(input);

        System.out.println("결과 : " + result);
    }
}
