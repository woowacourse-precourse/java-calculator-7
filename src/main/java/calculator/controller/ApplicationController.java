package calculator.controller;

import calculator.domain.Delimiter;
import calculator.domain.NumberStorage;
import calculator.view.ResultOutput;
import calculator.view.UserInput;

import java.util.ArrayList;
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
        this.userInputMessage = userInputController.getUserInputMessage();
        this.delimiter = userInputController.getDelimiter();
        this.numberStorage = new NumberStorage();
        updateNumberStorage();
        totalSum = numberStorage.getTotalSum();
        resultOutput.promptResultOutput(changeResultToString(totalSum));
    }



    private List<Integer> findNumIndex(String userSubInputMessage){
        List<Integer> numIndexList = new ArrayList<>();
        int id = 0;
        while(id < userSubInputMessage.length()-1 && numIndexList.size() < 3){
            if(delimiter.checkDelimiter(userSubInputMessage.charAt(id)) && numIndexList.size() < 1 && id < userSubInputMessage.length() - 2){
                numIndexList.add(id+1);
            }
            else if(delimiter.checkDelimiter(userSubInputMessage.charAt(id)) && numIndexList.size() > 0){
                numIndexList.add(id);
                if(numIndexList.get(0) >= numIndexList.get(1)){
                    numIndexList.clear();
                }
            }
            id++;
        }
        if(numIndexList.size() == 1) numIndexList.add(userSubInputMessage.length());
        return numIndexList;
    }

    private void updateNumberStorage(){
        List<Integer> numIndexList = findNumIndex(userInputMessage);
        int subFirstIndex = 0;
        while(numIndexList.size() != 0 && numIndexList.get(1) != userInputMessage.length() - 1){
            numberStorage.addNumber(userInputMessage.substring(subFirstIndex + numIndexList.get(0), subFirstIndex + numIndexList.get(1)), delimiter);
            subFirstIndex += numIndexList.get(1);
            numIndexList = findNumIndex(userInputMessage.substring(subFirstIndex, userInputMessage.length()));
        }
    }

    private String changeResultToString(Double totalSum){
        if(totalSum % 1 == 0.0){
            return Integer.toString(Integer.parseInt(Double.toString(totalSum)));
        }
        else{
            return Double.toString(totalSum);
        }
    }
}
