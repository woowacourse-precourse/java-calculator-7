package calculator.viewer;

import java.util.NoSuchElementException;

public class CalculatorViewer {
    public String readUserInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            String userInput = camp.nextstep.edu.missionutils.Console.readLine();
            return userInput;
        }
        catch (NoSuchElementException e){
            return "";
        }
    }

    public void printResult(long result){
        System.out.println("결과 : " + result);
    }
}
