package calculator.service;

import calculator.domain.CharAnalyzer;
import calculator.domain.NumberAccumulator;
import calculator.domain.SumCalculator;
import calculator.domain.delimiter.CustomDelimiterRegistrar;
import calculator.domain.delimiter.Delimiter;

public class CalculationService {

    private final Delimiter delimiter;
    private final CustomDelimiterRegistrar customDelimiterRegistrar;
    private final NumberAccumulator numberGenerator;
    private final SumCalculator sumCalculator;

    public CalculationService(Delimiter delimiter, CustomDelimiterRegistrar customDelimiterRegistrar, NumberAccumulator numberGenerator, SumCalculator sumCalculator) {
        this.delimiter = delimiter;
        this.customDelimiterRegistrar = customDelimiterRegistrar;
        this.numberGenerator = numberGenerator;
        this.sumCalculator = sumCalculator;
    }

    public int process(String input) {
        CharAnalyzer charAnalyzer = new CharAnalyzer(input, delimiter, customDelimiterRegistrar, numberGenerator);
        charAnalyzer.analyzeAllChars();
        return sumCalculator.getResult();
    }
}
