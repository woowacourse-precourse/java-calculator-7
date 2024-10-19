package calculator.factory;

import calculator.controller.CalculationController;
import calculator.domain.NumberGenerator;
import calculator.domain.SumCalculator;
import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.Delimiter;
import calculator.service.CalculationService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class FlowFactory {

    public static CalculationController createCalculationFlow() {
        SumCalculator sumCalculator = new SumCalculator();
        NumberGenerator numberGenerator = new NumberGenerator(sumCalculator);
        Delimiter delimiter = new Delimiter();
        CustomDelimiter customDelimiter = new CustomDelimiter();

        CalculationService calculationProcessor = new CalculationService(delimiter, customDelimiter, numberGenerator, sumCalculator);

        return new CalculationController(new InputView(), new OutputView(), calculationProcessor);
    }
}
