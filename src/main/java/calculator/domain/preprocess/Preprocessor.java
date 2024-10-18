package calculator.domain.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocessor {

    private final DelimeterSegmentProcessor delimeterSegmentProcessor;
    private final InputManager inputManager;
    private final SplitManager splitManager;

    public Preprocessor(DelimeterSegmentProcessor delimeterSegmentProcessor, InputManager inputManager, SplitManager splitManager) {
        this.delimeterSegmentProcessor = delimeterSegmentProcessor;
        this.inputManager = inputManager;
        this.splitManager = splitManager;
    }

    private boolean validateDelimeterRequest(String input) {
        if (delimeterSegmentProcessor.checkCustomDelimeterRequest(input)) {
            delimeterSegmentProcessor.validateCutomDelimeterRequest(input);
            if (inputManager.isInteger(delimeterSegmentProcessor.extractCustomDelimeter(input))) {
                throw new IllegalArgumentException("구분자로 숫자를 입력했습니다");
            }
            return true;
        }
        return false;
    }


    public List<String> preprocessDelimeter(String input) {
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":"));

        if (validateDelimeterRequest(input)) {
            return delimeterSegmentProcessor.makeDelimeterList(delimeterSegmentProcessor.extractCustomDelimeter(input));
        }

        return delimeterList;
    }

    public String preprocessString(String input) {
        if (validateDelimeterRequest(input)) {
            return delimeterSegmentProcessor.extractPartTobeProcessed(input);
        } else {
            return input;
        }
    }

    public void validateInputString(List<String> delimeter, String input){
        inputManager.findNoneDelimeterString(delimeter,input);
    }

    public List<String> extractSumNumbers(List<String> delimeterList, String input){
        return splitManager.extractNumbers(delimeterList,input);
    }
}
