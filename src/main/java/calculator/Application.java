package calculator;

import calculator.delimiter.CustomDelimiterPattern;
import calculator.delimiter.DefaultDelimiterPattern;
import calculator.delimiter.DelimiterPattern;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<DelimiterPattern> patterns = List.of(new DefaultDelimiterPattern(), new CustomDelimiterPattern());
        CalculatorService service = new CalculatorService(new InputView(), new OutputView(),
                new InputValidator(patterns), new InputExtractor(), new SumCalculator());
        service.start();
    }
}
