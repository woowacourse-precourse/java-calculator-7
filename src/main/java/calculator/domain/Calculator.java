package calculator.domain;

import calculator.util.Utils;
import calculator.validation.Validation;

import java.util.List;

public class Calculator {
    private int[] calculateNumbers;
    public Calculator(String[] splitStringArr) {
        Validation.validateStringArrToIntegerArr(splitStringArr);
        this.calculateNumbers = Utils.stringToIntegerList(splitStringArr);
    }

    public int getCalculateResult(){

    }
}
