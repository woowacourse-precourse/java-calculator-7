package calculator.factory;

import calculator.domain.*;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculationFactory {

    public CalculationManager createCalculationManager() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Delimiter delimiter = new Delimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter();
        SumCalculator sumCalculator = new SumCalculator();
        NumberGenerator numberGenerator = new NumberGenerator(sumCalculator);

        return new CalculationManager(
                inputView,
                outputView,
                delimiter,
                customDelimiter,
                sumCalculator,
                numberGenerator
        );
    }
}
