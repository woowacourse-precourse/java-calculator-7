package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Calculator {

    private List<Delimiter> delimiters;
    private CustomDelimiterParser customDelimiterParser;
    private String analyzingTarget;
    private Adder adder;
    private DelimiterSplitter delimiterSplitter;

    public Calculator(Adder adder, CustomDelimiterParser customDelimiterParser) {
        this.delimiters = new ArrayList<>(List.of(new Delimiter(","), new Delimiter(":")));
        this.customDelimiterParser = customDelimiterParser;
        this.adder = adder;
        this.analyzingTarget = "";
    }

    public int calculate() {
        parsingCustomDelimiter();
        List<Number> sumTargets = getSumTargets();
        return adder.calculateSum(sumTargets);
    }

    private List<Number> getSumTargets() {
        delimiterSplitter = new DelimiterSplitter(analyzingTarget, delimiters);
        return delimiterSplitter.splitByDelimiter();
    }

    private void parsingCustomDelimiter() {
        Optional<Delimiter> customDelimiter = customDelimiterParser.getCustomDelimiter();
        customDelimiter.ifPresent(s -> delimiters.add(s));
        this.analyzingTarget = customDelimiterParser.getRemainingInput();
    }
}
