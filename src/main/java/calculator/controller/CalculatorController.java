package calculator.controller;

import calculator.checkMethod.CheckInputType;
import calculator.checkMethod.CheckIsPositiveNum;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class CalculatorController {
    private int result;
    private static final String basicDelimiter = ",|:";


    public CalculatorController() {
        try {
            String input = Console.readLine();
            int inputLen = input.length();
            String[] operandArr = CheckInputType.checkType(input, inputLen, basicDelimiter);
            if (operandArr == null){
                isNull();
            } else{
                calculate(operandArr);
            }
        } catch (NoSuchElementException e) {
            isNull();
        } finally {
            Console.close();
        }
    }


    private void isNull(){
        result = 0;
    }


    private void calculate(String[] operandArr){
        for (String operand : operandArr) {
            if (operand != null){
                result += CheckIsPositiveNum.isPositiveNum(operand);
            }
        }
    }


    public void printResult(){
        System.out.println("결과 : " + result);
    }

}








