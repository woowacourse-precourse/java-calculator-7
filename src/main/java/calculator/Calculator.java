package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Calculator {

    private String input;
    private int result;
    private int inputLen;
    private static final String basicDelimiter = ",|:";

    // 생성자에서 입력 받기
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

    // 테스트용 생성자
    public Calculator(String input) {
        this.input = input;
        this.inputLen = input.length();
    }

    private void checkType(String input) {
        if (input.equals("")){
            isNull();
        }

        if (input.startsWith("//")){
            customDelimiterSplit();
        } else{
            basicDelimiterSplit();
        }
    }


    private void basicDelimiterSplit() {
        String[] operandArr = input.split(basicDelimiter);
        calculate(operandArr);
    }


    private void customDelimiterSplit() {
        int idx = input.indexOf("\\n", 2);
        String customDelimiter = basicDelimiter + "|";
        String operandStr = "";

        if (inputLen == idx+2){
            isNull();
            return;
        }

        if (idx == -1) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        } else{
            // |가 커스텀구분자에 포함되었을 경우에 \\|로 치환하여 문자로 인식하도록
            customDelimiter += input.substring(2, idx).replace("|", "\\|");
        }

        operandStr = input.substring(idx+2, inputLen);
        String[] operandArr = operandStr.split(customDelimiter);
        calculate(operandArr);
    }


    private void isNull(){
        result = 0;
    }


    public int isPositiveNum(String operand){
        int num;

        if (operand.equals("")){
            return 0;
        }

        try{
            num = Integer.parseInt(operand);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        if (num > 0){
            return num;
        } else{
            throw new IllegalArgumentException("양수가 아닙니다.");
        }
    }


    private void calculate(String[] operandArr){
        for (String operand : operandArr) {
            if (operand != null){
                result += isPositiveNum(operand);
            }
        }
    }


    public void printResult(){
        System.out.println("결과 : " + result);
    }



}














