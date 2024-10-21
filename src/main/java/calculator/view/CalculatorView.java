package calculator.view;

import calculator.global.error.ErrorMessage;
import calculator.global.error.handler.ErrorHandler;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    public String getInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요 : ");
        return Console.readLine();
    }

    public void printResult(int result){
        System.out.print("결과 : " + result);
    }

    public void printError(ErrorMessage errorMessage) {
        ErrorHandler.handlerError(errorMessage);
    }

}
