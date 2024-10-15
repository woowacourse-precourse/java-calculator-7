package calculator.controller;

import calculator.model.Delimiter;
import calculator.view.InputView;

public class CalculatorController {
    private final InputView inputView;

    public CalculatorController(InputView inputView){
        this.inputView = inputView;
    }

    public void run(){

    }

    public void proceed(){
        String userInput = inputView.inputUserString();
        if(userInput.equals("")){
            // 0 출력 (OutputView 구현)
        }
        int result = calculateStringRemainder(splitString(userInput),userInput);
        // result 출력
    }

    public int splitString(String userInput){
        int index = 0;
        if(!isNumber(userInput.substring(0,1))){
            index = specifyingDelimiter(userInput);
        }
        return index;
    }


    public boolean isNumber(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public int specifyingDelimiter(String userInput){
        if(!userInput.startsWith("//")){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        int index = 2;
        Delimiter.updateDelimiter(userInput.charAt(index));
        if(!userInput.substring(index+1,index+3).equals("\n")){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        return index + 3;
    }

    public int calculateStringRemainder(int index, String userInput){
        boolean isPreviousValueNumeric = false;
        int sum = 0;
        for(String str:userInput.substring(index).split("")){
            if(isPreviousValueNumeric){
                separateDelimiter(str);
                isPreviousValueNumeric = false;
                continue;
            }
            sum += extractNumber(str);
            isPreviousValueNumeric = true;
        }
        return sum;
    }

    public int extractNumber(String str){
        if(!isNumber(str)){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        return Integer.parseInt(str);
    }

    public void separateDelimiter(String str){
        if(isNumber(str)){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        // 구분자가 아니면 오류
    }
}
