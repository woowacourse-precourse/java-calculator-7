package calculator.controller;

import calculator.domain.Delimiter;
import calculator.domain.NumberStorage;
import calculator.view.ResultOutput;
import calculator.view.UserInput;

import java.util.Arrays;
import java.util.List;

public class ApplicationController {
    private final UserInput userInput = new UserInput();
    private final UserInputController userInputController = new UserInputController(userInput);
    private final ResultOutput resultOutput = new ResultOutput();
    private final Delimiter delimiter;
    private final NumberStorage numberStorage;
    private final String userInputMessage;
    private final Double totalSum;



    public ApplicationController(){
        userInputMessage = userInputController.getUserInputMessage();
        delimiter = userInputController.getDelimiter();
        numberStorage = new NumberStorage();
        updateNumberStorage();
        totalSum = numberStorage.getTotalSum();
        resultOutput.promptResultOutput(changeResultToString(totalSum));
    }



    private List<String> getNumList(String userInputMessage) {
        List<String> numIndexList;
        if (delimiter.hasCustomDelimiter()) {
            numIndexList = Arrays.asList(userInputMessage.split("[" + delimiter.CUSTOM_DELIMITER + Delimiter.COLON_DELIMITER + Delimiter.COMMA_DELIMITER + "]"));
        } else {
            numIndexList = Arrays.asList(userInputMessage.split("[" + Delimiter.COLON_DELIMITER + Delimiter.COMMA_DELIMITER + "]"));
        }
        return numIndexList;
    }

    private void updateNumberStorage(){
        List<String> numList;
        if(delimiter.hasCustomDelimiter()) numList = getNumList(userInputMessage.substring(5));
        else numList = getNumList(userInputMessage);
        for(int i = 0; i < numList.size(); i++){
            numberStorage.addNumber(numList.get(i), delimiter);
        }
    }

    private String changeResultToString(Double totalSum){
        if(totalSum % 1 == 0.0){
            return Integer.toString((int) Math.floor(totalSum));
        }
        else{
            return Double.toString(totalSum);
        }
    }
}
