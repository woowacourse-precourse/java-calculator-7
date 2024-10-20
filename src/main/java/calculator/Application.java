package calculator;

import static calculator.service.DelimiterParser.parseDelimiters;

import calculator.dto.CalculatorRequest;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {

        String userInput = InputView.view();
        CalculatorRequest request = parseDelimiters(userInput);
    }
}
