package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private String userInput;
    private final OutputView outputView = new OutputView();
    private String DELIMITER = ",|:|";
    private Long resultNumber = 0L;

    public Calculator() {
        InputView inputView = new InputView();
        userInput = inputView.getInput();
    }

    public void stringSummation() {
        if (hasCustomSpliter()) {
            DELIMITER += getCustomSpliter();
        }

        try {
            List<String> splitInput = splitString();
            Long[] numberOfInputString = changeStringToNumber(splitInput);
            sumNumber(numberOfInputString);
            outputView.printResult(resultNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


    }

    private void sumNumber(Long[] numberArrays) {
        for (Long num : numberArrays) {
            resultNumber += num;
        }
    }

    private Long[] changeStringToNumber(List<String> splitInput) throws IllegalArgumentException{
        Long[] numberOfInputString = new Long[splitInput.size()];
        for (int i=0; i< splitInput.size(); i++) {
            numberOfInputString[i] = Long.parseLong(splitInput.get(i));
        }
        return numberOfInputString;
    }

    private List<String> splitString() throws IllegalArgumentException {
        List<String> splitInput;
        splitInput = Arrays.stream(userInput.split(DELIMITER)).toList();
        return splitInput;
    }


    private boolean hasCustomSpliter(){
        if (userInput.length() >= 5 && userInput.startsWith("//")) {
            return true;
        } else {
            return false;
        }
    }

    private String getCustomSpliter() {
        int delimiterIndex = userInput.indexOf("\n");
        String newDelimiter = userInput.substring(2, delimiterIndex);
        userInput = userInput.substring(delimiterIndex + 1);
        return newDelimiter;
    }

    private boolean isValidInput(){
        String regexForValidInput = "[0-9" + escapeSetting() + "]*";
        return userInput.matches(regexForValidInput);
    }

    private String escapeSetting() {
        return DELIMITER.replaceAll("([\\W])", "\\\\$1");
    }

}
