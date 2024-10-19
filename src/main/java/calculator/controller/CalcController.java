package calculator.controller;

import calculator.model.Numbers;
import calculator.model.Separator;
import calculator.view.IOView;

public class CalcController {

    private final Separator separator;
    private final IOView ioView;

    public CalcController() {
        this.separator = new Separator();
        this.ioView = new IOView();
    }

    public void run() {
        String input = ioView.printInput();
        int[] extractedNumbers = separator.extractNumbers(input);
        Numbers numbers = new Numbers(extractedNumbers);
        ioView.printResult(numbers.getSumResult());
    }
}
