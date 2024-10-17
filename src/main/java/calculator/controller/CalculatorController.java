package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        String consoleInput = inputView.getConsoleInput();
    }

    public List<String> getNumbersList(String consoleInput) {
        if (consoleInput.startsWith("//")) {
            int customIndex = consoleInput.indexOf("\\n");
            String customSeperator = consoleInput.substring(2, customIndex + 1);
            return List.of(consoleInput.split(customSeperator));
        }
        return List.of(consoleInput.split("[,:]"));
    }
}
