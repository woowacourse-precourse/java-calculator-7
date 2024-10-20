package calculator.viewer;

public class CalculatorViewer {
    public String readUserInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        return userInput;
    }

    public void printResult(long result){
        System.out.println("결과 : " + result);
    }
}
