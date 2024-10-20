package calculator.controller;

import calculator.service.addOperation;
import camp.nextstep.edu.missionutils.Console;

public class calculatorController {
    public void calculator(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        addOperation addOperation = new addOperation();
        int result = addOperation.add(input);
        System.out.println("결과 : " + result);
    }
}
