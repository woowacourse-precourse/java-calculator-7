package calculator.controller;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;
import calculator.exception.InputStringException;
import calculator.util.OutputUtil;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private final OutputUtil outputUtil = new OutputUtil();
    private final InputStringException inputStringException = new InputStringException();
    public void startCalculating(){
        Numbers numbers = new Numbers();
        Delimiters delimiters = new Delimiters();

        outputUtil.printProgramStart();
        String inputString = Console.readLine();

        numbers = inputStringException.validateInputPattern(inputString, numbers, delimiters);
    }
}
