package calculator.controller;

import calculator.service.StringSeparator;
import calculator.view.InputView;

public class CalculatorController {
    private StringSeparator stringSeparator;
    private InputView inputView;

    public CalculatorController() {
      this.stringSeparator = new StringSeparator();
      this.inputView = new InputView();
    }

    public void run() {
        String str = inputView.inputString();
        stringSeparator.divideSeparator(str);

    }
}
