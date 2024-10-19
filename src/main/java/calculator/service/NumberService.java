package calculator.service;

import calculator.domain.Number;

public class NumberService {

    public static Number extractNum(String[] separatedValue){
        return new Number(separatedValue);
    }
}
