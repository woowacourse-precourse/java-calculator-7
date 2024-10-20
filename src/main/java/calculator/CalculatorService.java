package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorService {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final NumberExtractor numberExtractor;
    private final SumCalculator sumCalculator;

    public CalculatorService(InputView inputView, OutputView outputView, InputValidator inputValidator,
                             NumberExtractor numberExtractor, SumCalculator sumCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.numberExtractor = numberExtractor;
        this.sumCalculator = sumCalculator;
    }

    public void start() {
        String input = inputView.input();
        inputValidator.validate(input);
        List<Integer> numbers = numberExtractor.extractNumbers(input);
        int sum = sumCalculator.sum(numbers);
        outputView.printResult(sum);
    }
}
