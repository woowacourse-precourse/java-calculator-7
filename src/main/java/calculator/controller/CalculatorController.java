package calculator.controller;

import calculator.view.CalculatorView;

public class CalculatorController {

    public void run(){
        try{
            String input = CalculatorView.getInput();
        }
        catch (IllegalArgumentException e){
            //Todo 에러메시지 출력
        }
    }
}
