package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getStringFromUser(){
        System.out.println("문자열을 입력하세요 : ");
        return Console.readLine();
    }
}
