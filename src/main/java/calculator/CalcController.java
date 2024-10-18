package calculator;

import calculator.domain.Calculator;
import calculator.domain.Extractor;
import calculator.domain.PositiveCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalcController {

    private InputView inputView;
    private OutputView outputView;

    public CalcController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printInputRequest();
        String numsWithDelimiter = inputView.readNumbers();

        Extractor ex = new Extractor();
        String delimiter = ex.extractDelimiter(numsWithDelimiter);
        String delimitedNums =
            (delimiter.isEmpty()) ? numsWithDelimiter : numsWithDelimiter.substring(delimiter.length() + 4);
        int[] nums = ex.extractNumbers(delimitedNums, delimiter);

        Calculator calc = new PositiveCalculator(nums);
        outputView.printCalculatedResult(calc.sum());
    }
}
