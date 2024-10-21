package calculator.controller;

import calculator.logic.CustomChecker;
import calculator.logic.Delimiter;
import calculator.logic.Sum;
import calculator.logic.Validation;
import calculator.io.Input;
import calculator.io.Output;

import static calculator.logic.CustomChecker.isCustom;

public class Controller {
    public void execution() {
        // 값을 입력받고 (완료)
        String str = Input.inputString();
        // 유효성 검증을 하고 (비어있는 경우에는 그냥 종료)
        if (str.isEmpty()) {
            Output.printOutMessage(0);
            return;
        }
        Validation.execution(str);
        // 문자와 숫자를 분리한다. (완료)
        String[] delimitedValues =  Delimiter.execution(str, isCustom(str));
        // 문자와 분리된 수를 더 한다. (완료)
        int sumVal = Sum.doSummation(delimitedValues);
        // 더한 값을 출력한다. (완료)
        Output.printOutMessage(sumVal);
    }
}
