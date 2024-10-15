package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calculator {
    private String userInput;
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private String DELIMITER = ",|:";
    private Long resultNumber = 0L;

    public Calculator() {
        userInput = inputView.getInput();
    }

    public void stringSummation() {
        if (hasCustomSpliter()) {
            DELIMITER += ("|" +getCustomSpliter());
        }
        List<String> splitInput = splitString();
        Long[] numberOfInputString = changeStringToNumber(splitInput);
        sumNumber(numberOfInputString);
        outputView.printResult(resultNumber);
        inputView.closedConsole();

    }

    private void sumNumber(Long[] numberArrays) {
        for (Long num : numberArrays) {
            resultNumber += num;
        }
    }

    private Long[] changeStringToNumber(List<String> splitInput){
        Long[] numberOfInputString = new Long[splitInput.size()];

        for (int i=0; i< splitInput.size(); i++) {
            Long number = Long.parseLong(splitInput.get(i));
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            numberOfInputString[i] = Long.parseLong(splitInput.get(i));
        }
        return numberOfInputString;
    }

    private List<String> splitString() throws IllegalArgumentException {
        if (userInput == null || userInput.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(userInput.split(DELIMITER)).toList();
    }


    private boolean hasCustomSpliter(){
        if (userInput.length() >= 5 && userInput.startsWith("//")) {
            return true;
        } else {
            return false;
        }
    }

    private String getCustomSpliter() {
        int delimiterIndex = userInput.indexOf("\\n");
        String newDelimiter = userInput.substring(2, delimiterIndex);
        userInput = userInput.substring(delimiterIndex + 2);
        return newDelimiter;
    }

}
