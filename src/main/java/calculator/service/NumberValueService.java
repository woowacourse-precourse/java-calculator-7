package calculator.service;

import calculator.domain.NumberValue;

public class NumberValueService {

    public static NumberValue extractNum(String[] separatedValue){
        return new NumberValue(separatedValue);
    }
}
