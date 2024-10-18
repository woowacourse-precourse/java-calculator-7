package calculator.factory;

import calculator.domain.*;
import calculator.input.InputHandler;
import calculator.output.OutputHandler;
import calculator.view.OutputView;

public class CalculationFactory {

    public CalculationManager createCalculationManager() {
        OutputView outputView = new OutputView();
        InputHandler inputHandler = new InputHandler();
        Delimiter delimiter = new Delimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter();
        SumCalculator sumCalculator = new SumCalculator();
        NumberGenerator numberGenerator = new NumberGenerator(sumCalculator);
        OutputHandler outputHandler = new OutputHandler(sumCalculator);

        return new CalculationManager(
                outputView,
                inputHandler,
                outputHandler,
                delimiter,
                customDelimiter,
                numberGenerator
        );
    }
}
