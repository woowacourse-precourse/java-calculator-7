package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserView {
    public String readInputString() {
        return readLine().strip();
    }

    public void printStartCalculator(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void printResult(int result){
        System.out.printf("결과 : %d", result);
    }

}