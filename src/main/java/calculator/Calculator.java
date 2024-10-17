package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Calculator {
    private String input;
    private int result;
    private int inputLen;
    private static final String basicDelimiter = ",|:";


    public Calculator() {
        try {
            this.input = Console.readLine();
            this.inputLen = input.length();
            checkType(input);
        } catch (NoSuchElementException e) {
            isNull();
        } finally {
            Console.close();
        }
    }


    private void checkType(String input) {
        if (input.equals("")){
            isNull();
        }

        if (input.startsWith("//")){
            String[] operandArr = CustomDelimiterSplit.splitInput(input, inputLen, basicDelimiter);
            if (operandArr == null){
                isNull();
            } else{
                calculate(operandArr);
            }
        } else{
            String[] operandArr = BasicDelimiterSplit.splitInput(input, basicDelimiter);
            calculate(operandArr);
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








