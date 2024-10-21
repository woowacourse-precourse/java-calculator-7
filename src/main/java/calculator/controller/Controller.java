package calculator.controller;

import calculator.Validation;
import calculator.io.Input;
import calculator.io.Output;

public class Controller {
    public void execution() {
        // 사용자 입력 값
        String str = Input.inputString();
        // 빈 문자열
        if (str.isEmpty()) {
            Output.printOutMessage(0);
            return;
        }
        Validation.execution(str);
        // 구분자 구별 및 처리

        // 숫자 합 계산

        // 결과 반환
        
    }
}