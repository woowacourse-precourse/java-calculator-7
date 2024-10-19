package calculator.controller;

import calculator.model.Arithmetic;
import calculator.model.InputData;

public class NumericCalculatorController {
    public Arithmetic createCalculatorPart(InputData inputData){
        return new Arithmetic(inputData.convertCalculatorPart());
    }
}
