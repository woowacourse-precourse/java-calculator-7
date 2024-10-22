package calculator.domain.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocessor {

    private final DelimiterSegmentProcessor delimiterSegmentProcessor;
    private final CalculationSegmentProcessor calculationSegmentProcessor;

    public Preprocessor(DelimiterSegmentProcessor delimiterSegmentProcessor, CalculationSegmentProcessor calculationSegmentProcessor) {
        this.delimiterSegmentProcessor = delimiterSegmentProcessor;
        this.calculationSegmentProcessor = calculationSegmentProcessor;
    }

    public List<String> preprocessDelimiterSegment(String input) {
        List<String> delimiterList = new ArrayList<>(Arrays.asList(",", ":"));

        if (delimiterSegmentProcessor.checkCustomDelimiterRequest(input)) {
            return delimiterSegmentProcessor.extractDelimiterList(input);
        }

        return delimiterList;
    }

    public String preprocessCalculationSegment(String input) {
        if (delimiterSegmentProcessor.checkCustomDelimiterRequest(input)) {
            return delimiterSegmentProcessor.extractCalculationSegment(input);
        } else {
            return input;
        }
    }

    public void validateCalculationSegment(List<String> delimiter, String input) {
        calculationSegmentProcessor.findNoneDelimiterString(delimiter, input);
    }

    public List<String> extractSumNumbers(List<String> delimiterList, String input) {
        return calculationSegmentProcessor.extractNumbers(delimiterList, input);
    }
}
