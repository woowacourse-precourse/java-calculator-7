package calculator;

import calculator.data.CalculationData;
import calculator.extractor.DelimiterExtractor;
import calculator.extractor.NumberExtractor;
import calculator.handler.InputHandler;
import calculator.handler.OutputHandler;
import calculator.processor.MathProcessor;
import java.util.List;

public class Calculator {
    private String inputString = InputHandler.getInputString();
    private CalculationData calculationData = DelimiterExtractor.extractCustomDelimiters(inputString);
    private List<Long> values = NumberExtractor.extractValues(calculationData);

    public void sum() {
        Long result = MathProcessor.calculateSum(values);
        OutputHandler.printResult(result);
    }
}
