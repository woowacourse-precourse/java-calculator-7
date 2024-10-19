package calculator.controller;

import calculator.model.Arithmetic;
import calculator.model.Delimiter;
import calculator.model.InputData;

public class NumericCalculatorController {
    public Arithmetic createCalculatorPart(Delimiter delimiter,InputData inputData){
        return new Arithmetic(delimiter, inputData);
    }
}
