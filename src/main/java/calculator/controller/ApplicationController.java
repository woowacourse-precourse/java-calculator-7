package calculator.controller;

import calculator.domain.Delimiter;
import calculator.domain.NumberStorage;
import calculator.view.ResultOutput;
import calculator.view.UserInput;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ApplicationController {
    private final UserInput userInput = new UserInput();
    private final UserInputController userInputController = new UserInputController(userInput);
    private final ResultOutput resultOutput = new ResultOutput();
    private final Delimiter delimiter;
    private final NumberStorage numberStorage;
    private final String userInputMessage;
    private final BigDecimal totalSum;



    public ApplicationController(){
        userInputMessage = userInputController.getUserInputMessage();
        delimiter = userInputController.getDelimiter();
        numberStorage = new NumberStorage();
        updateNumberStorage();
        totalSum = new BigDecimal(String.valueOf(numberStorage.getTotalSum()));
        resultOutput.promptResultOutput(totalSum);
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
            if(!numList.get(i).equals("")) numberStorage.addNumber(numList.get(i), delimiter);
        }
    }
}
