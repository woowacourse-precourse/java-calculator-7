package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {
    private CalculatorService calculatorService;
    public CalculatorController(CalculatorService service){
        this.calculatorService = service;
    }
    private String inputString;
    private String transString;
    private String[] numList;
    private int result;

    public void app(){
        // startString
        calculatorService.printStartString();
        // read input
        inputString = calculatorService.setInputString();
        // calculate
        calculatorService.calculate(inputString);
        // print endString, result
        calculatorService.printResult();
    }
}
