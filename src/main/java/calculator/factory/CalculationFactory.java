package calculator.factory;

import calculator.domain.*;
import calculator.output.OutputHandler;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculationFactory {

    public CalculationManager createCalculationManager() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        Delimiter delimiter = new Delimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter();
        SumCalculator sumCalculator = new SumCalculator();
        NumberGenerator numberGenerator = new NumberGenerator(sumCalculator);
        OutputHandler outputHandler = new OutputHandler(sumCalculator);

        return new CalculationManager(
                inputView,
                outputView,
                outputHandler,
                delimiter,
                customDelimiter,
                numberGenerator
        );
    }
}
