package calculator.config;

import calculator.controller.Controller;
import calculator.model.Calculator;
import calculator.model.CalculatorImpl;
import calculator.model.StringTokenizer;
import calculator.model.Tokenizer;
import calculator.view.ViewImpl;
import calculator.view.View;

public class ApplicationConfiguration {

    public Controller controller() {
        return new Controller(tokenizer(), calculator(), view());
    }

    private Calculator calculator() {
        return new CalculatorImpl();
    }

    private Tokenizer tokenizer() {
        return new StringTokenizer(new StringBuilder());
    }

    private View view() {
        return new ViewImpl();
    }

}
