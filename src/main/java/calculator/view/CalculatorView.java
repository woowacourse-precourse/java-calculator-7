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
        // 핸들러가 예외를 던질지 경고를 출력할지 결정함
        ErrorHandler.handlerError(errorMessage);
    }

}
