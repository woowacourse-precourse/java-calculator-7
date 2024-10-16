package calculator.domain.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocessor {

    private final DelimeterProcessor delimeterProcessor;
    private final InputManager inputManager;
    private final SplitManager splitManager;

    public Preprocessor(DelimeterProcessor delimeterProcessor, InputManager inputManager, SplitManager splitManager) {
        this.delimeterProcessor = delimeterProcessor;
        this.inputManager = inputManager;
        this.splitManager = splitManager;
    }

    private boolean validateDelimeterRequest(String input) {
        if (delimeterProcessor.checkCustomDelimeterRequest(input)) {
            validateDelimeterRequest(input);
            if (inputManager.isInteger(delimeterProcessor.extractCustomDelimeter(input))) {
                throw new IllegalArgumentException("구분자로 숫자를 입력했습니다");
            }
            return true;
        }
        return false;
    }


    public List<String> preprocessDelimeter(String input) {
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":"));

        if (validateDelimeterRequest(input)) {
            return delimeterProcessor.makeDelimeterList(delimeterProcessor.extractCustomDelimeter(input));
        }

        return delimeterList;
    }

    public String preprocessString(String input) {
        if (validateDelimeterRequest(input)) {
            return delimeterProcessor.discardCustomDelimeterRequest(input);
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
