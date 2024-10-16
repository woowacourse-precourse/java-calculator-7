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
        int result = calculateStringRemainder(DelimiterSeparator.registerDelimiter(userInput),userInput);
        // result 출력
    }

    public boolean isNumber(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public int calculateStringRemainder(int index, String userInput){
        boolean isPreviousValueNumeric = false;
        int sum = 0;
        for(String str:userInput.substring(index).split("")){
            if(isPreviousValueNumeric){
                DelimiterSeparator.separateDelimiter(str);
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
}
