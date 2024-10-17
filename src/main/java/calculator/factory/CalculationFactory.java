package calculator.factory;

import calculator.domain.*;
import calculator.input.InputHandler;
import calculator.output.OutputHandler;

public class CalculationFactory {

    public CalculationManager createCalculationManager() {
        InputHandler inputHandler = new InputHandler();
        Delimiter delimiter = new Delimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter();
        SumCalculator sumCalculator = new SumCalculator();
        NumberGenerator numberGenerator = new NumberGenerator(sumCalculator);
        OutputHandler outputHandler = new OutputHandler(sumCalculator);

        return new CalculationManager(
                inputHandler,
                outputHandler,
                delimiter,
                customDelimiter,
                numberGenerator
        );
    }
}
