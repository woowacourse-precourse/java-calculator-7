package calculator.controller;

import calculator.model.Calculator;
import calculator.model.InputData;

public class NumericCalculatorController {
    public Calculator createCalculatorPart(InputData inputData){
        return new Calculator(inputData.convertCalculatorPart());
    }
}
