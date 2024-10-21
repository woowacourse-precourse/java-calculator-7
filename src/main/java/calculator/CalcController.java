package calculator;

import calculator.domain.Calculator;
import calculator.domain.Extractor;
import calculator.domain.PositiveCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalcController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalcController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printInputRequest();
        String numsWithDelimiter = inputView.readNumbers();
        int[] nums;

        Extractor ex = new Extractor();
        if (ex.isDefaultDelimiterUsed(numsWithDelimiter)) {
            nums = ex.extractNumbersWithDefaultDelimiter(numsWithDelimiter);
        } else {
            String customDelimiter = ex.extractCustomDelimiter(numsWithDelimiter);
            nums = ex.extractNumbersWithCustomDelimiter(numsWithDelimiter, customDelimiter);
        }

        Calculator calc = new PositiveCalculator(nums);
        outputView.printCalculatedResult(calc.sum());
    }
}
