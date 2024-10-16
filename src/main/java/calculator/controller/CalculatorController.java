package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void proceed(){
        String userInput = inputView.inputUserString();
        if(userInput.equals("")){
            outputView.printResult(0);
        }
        int result = calculateStringRemainder(DelimiterSeparator.registerDelimiter(userInput),userInput);
        outputView.printResult(result);
    }

    public int calculateStringRemainder(int index, String userInput){
        boolean isPreviousValueNumeric = false;
        int sum = 0;
        for(String str:userInput.substring(index).split("")){
            if(isPreviousValueNumeric){
                DelimiterSeparator.validateDelimiter(str);
                isPreviousValueNumeric = false;
                continue;
            }
            sum += extractNumber(str);
            isPreviousValueNumeric = true;
        }
        return sum;
    }

    public int extractNumber(String str){
        if(!NumberChecker.isNumber(str)){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        return Integer.parseInt(str);
    }
}
