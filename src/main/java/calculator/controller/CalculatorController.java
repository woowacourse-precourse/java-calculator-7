package calculator.controller;

import calculator.checkMethod.CheckInputType;
import calculator.checkMethod.CheckIsPositiveNum;
import calculator.delimiterSplit.BasicDelimiterSplit;
import calculator.delimiterSplit.CustomDelimiterSplit;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class CalculatorController {
    private int result;
    private static final String basicDelimiter = ",|:";


    public CalculatorController() {
        try {
            String input = Console.readLine();
            int inputLen = input.length();
            String[] operandArr = getOperandArr(input, inputLen);

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

    private String[] getOperandArr(String input, int inputLen) {

        String[] operandArr;

        CheckInputType checkInputType = new CheckInputType();
        String type = checkInputType.checkType(input);

        if (type.equals("custom")){
            operandArr = CustomDelimiterSplit.customDelimiterSplit(input, inputLen, basicDelimiter);
        } else if(type.equals("basic")){
            operandArr = BasicDelimiterSplit.basicDelimiterSplit(input, basicDelimiter);
        } else {
            operandArr = null;
        }

        return operandArr;
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








