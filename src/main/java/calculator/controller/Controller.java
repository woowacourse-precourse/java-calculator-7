package calculator.controller;

import calculator.logic.CustomChecker;
import calculator.logic.Delimiter;
import calculator.logic.Sum;
import calculator.logic.Validation;
import calculator.io.Input;
import calculator.io.Output;

public class Controller {
    public void execution() {
        // 값을 입력받고
        String str = Input.inputString();
        // 유효성 검증을 하고
        Validation.execution(str);
        // 문제가 없다면 커스텀 검사를 하고
        CustomChecker.isCustom(str);
        // 추출된 문자가 있다면 그 문자를 함께, 없다면 원래 문자를 분리하고
        Delimiter.execution();
        //값을 더하고 나서
        Sum.execution();
        // 출력값에 전달한다
        Output.printOutMessage(str);
    }
}
