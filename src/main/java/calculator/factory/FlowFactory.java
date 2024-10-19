package calculator.factory;

import calculator.controller.CalculationController;
import calculator.domain.NumberAccumulator;
import calculator.domain.SumCalculator;
import calculator.domain.delimiter.CustomDelimiterRegistrar;
import calculator.domain.delimiter.Delimiter;
import calculator.service.CalculationService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class FlowFactory {

    public static CalculationController createCalculationFlow() {
        SumCalculator sumCalculator = new SumCalculator();
        NumberAccumulator numberGenerator = new NumberAccumulator(sumCalculator);
        Delimiter delimiter = new Delimiter();
        CustomDelimiterRegistrar customDelimiterRegistrar = new CustomDelimiterRegistrar();

        CalculationService calculationProcessor = new CalculationService(delimiter, customDelimiterRegistrar, numberGenerator, sumCalculator);

        return new CalculationController(new InputView(), new OutputView(), calculationProcessor);
    }
}
