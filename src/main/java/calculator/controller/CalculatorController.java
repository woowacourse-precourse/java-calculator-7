package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            Calculator calculator = new Calculator();
            String consoleInput = inputView.getConsoleInput();
            List<Integer> numbers = getNumbersList(consoleInput)
                    .stream()
                    .map(Integer::parseInt)
                    .toList();
            outputView.printSum(calculator.sum(numbers));
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public List<String> getNumbersList(String consoleInput) {
        if (consoleInput.startsWith("//")) {
            int customIndex = consoleInput.indexOf("\\n");
            String customSeperator = consoleInput.substring(2,customIndex);
            String custom = consoleInput.substring(customIndex + 2);
            return List.of(custom.split(customSeperator.trim()));
        }
        return List.of(consoleInput.split("[,:]"));
    }
}
