package calculator.domain.calculation;

import calculator.domain.NumberGenerator;
import calculator.domain.SumCalculator;
import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.Delimiter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculationFactory {

    public static CalculationFlow createCalculationFlow() {
        SumCalculator sumCalculator = new SumCalculator();
        NumberGenerator numberGenerator = new NumberGenerator(sumCalculator);
        Delimiter delimiter = new Delimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter();

        CalculationProcessor calculationProcessor = new CalculationProcessor(delimiter, customDelimiter, numberGenerator, sumCalculator);

        return new CalculationFlow(new InputView(), new OutputView(), calculationProcessor);
    }
}
