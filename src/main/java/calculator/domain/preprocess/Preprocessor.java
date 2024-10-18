package calculator.domain.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocessor {

    private final DelimeterSegmentProcessor delimeterSegmentProcessor;
    private final CalculationSegmentProcessor calculationSegmentProcessor;

    public Preprocessor(DelimeterSegmentProcessor delimeterSegmentProcessor, CalculationSegmentProcessor calculationSegmentProcessor) {
        this.delimeterSegmentProcessor = delimeterSegmentProcessor;
        this.calculationSegmentProcessor = calculationSegmentProcessor;
    }

    private boolean validateDelimeterRequest(String input) {
        if (delimeterSegmentProcessor.checkCustomDelimeterRequest(input)) {
            return true;
        }
        return false;
    }


    public List<String> preprocessDelimeter(String input) {
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":"));

        if (validateDelimeterRequest(input)) {
            return delimeterSegmentProcessor.extractDelimeterList(input);
        }

        return delimeterList;
    }

    public String preprocessString(String input) {
        if (validateDelimeterRequest(input)) {
            return delimeterSegmentProcessor.extractCalculationSegment(input);
        } else {
            return input;
        }
    }

    public void validateInputString(List<String> delimeter, String input){
        calculationSegmentProcessor.findNoneDelimeterString(delimeter,input);
    }

    public List<String> extractSumNumbers(List<String> delimeterList, String input){
        return calculationSegmentProcessor.extractNumbers(delimeterList,input);
    }
}
