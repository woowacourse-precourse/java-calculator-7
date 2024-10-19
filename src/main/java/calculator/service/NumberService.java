package calculator.service;

import calculator.domain.Number;

public class NumberService {

    public static Number extractNum(){
        String[] separatedVals = ValueService.getSeparatedValue();
        return new Number(separatedVals);
    }
}
