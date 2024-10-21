package calculator.controller;

import static calculator.CustomCheck.isCustom;

import calculator.Delimiter;
import calculator.Sum;
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
        String[] delimitedValues = Delimiter.execution(str, isCustom(str));
        // 숫자 합 계산
        int sumVal = Sum.doSummation(delimitedValues);
        // 결과 반환

    }
}