package calculator.domain.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocessor {

    private final DelimeterSegmentProcessor delimeterSegmentProcessor;
    private final CalculationSegmentProcessor calculationSegmentProcessor;
    private final SplitManager splitManager;

    public Preprocessor(DelimeterSegmentProcessor delimeterSegmentProcessor, CalculationSegmentProcessor calculationSegmentProcessor, SplitManager splitManager) {
        this.delimeterSegmentProcessor = delimeterSegmentProcessor;
        this.calculationSegmentProcessor = calculationSegmentProcessor;
        this.splitManager = splitManager;
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
        return splitManager.extractNumbers(delimeterList,input);
    }
}
