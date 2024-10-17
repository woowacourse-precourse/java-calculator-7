package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Calculator {
    private int result;
    private static final String basicDelimiter = ",|:";


    public Calculator() {
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








