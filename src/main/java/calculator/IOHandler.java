package calculator;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {
    public void printStartMsg(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String getInputString(){
        return Console.readLine();
    }

    public void printResultMsg(int result){
        System.out.println("결과 :"+Integer.toString(result));
    }
}
