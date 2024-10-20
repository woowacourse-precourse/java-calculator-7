package calculator.View;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String userInput(){
        System.out.println("덧샘할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
