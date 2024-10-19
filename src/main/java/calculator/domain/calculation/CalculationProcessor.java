package calculator.domain.calculation;

import calculator.domain.CharAnalyzer;
import calculator.domain.NumberGenerator;
import calculator.domain.SumCalculator;
import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.Delimiter;

public class CalculationProcessor {

    private final Delimiter delimiter;
    private final CustomDelimiter customDelimiter;
    private final NumberGenerator numberGenerator;
    private final SumCalculator sumCalculator;

    public CalculationProcessor(Delimiter delimiter, CustomDelimiter customDelimiter, NumberGenerator numberGenerator, SumCalculator sumCalculator) {
        this.delimiter = delimiter;
        this.customDelimiter = customDelimiter;
        this.numberGenerator = numberGenerator;
        this.sumCalculator = sumCalculator;
    }

    public int process(String input) {
        CharAnalyzer charAnalyzer = new CharAnalyzer(input, delimiter, customDelimiter, numberGenerator);
        charAnalyzer.analyzeAllChars();
        return sumCalculator.getResult();
    }
}
