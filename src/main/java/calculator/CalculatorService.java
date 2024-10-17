package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorService {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final InputExtractor inputExtractor;
    private final SumCalculator sumCalculator;

    public CalculatorService(InputView inputView, OutputView outputView, InputValidator inputValidator,
                             InputExtractor inputExtractor, SumCalculator sumCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.inputExtractor = inputExtractor;
        this.sumCalculator = sumCalculator;
    }

    public void start() {
        String input = inputView.input();
        inputValidator.validate(input);
        List<Integer> numbers = inputExtractor.extractNumbers(input);
        int sum = sumCalculator.sum(numbers);
        outputView.printResult(sum);
    }
}
