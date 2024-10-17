package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Calculator {

    private String input;
    private int result;
    private int inputLen;

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
        if (input == ""){
            isNull();
        }

        if (input.startsWith("//")){
            customDelimiter();
        } else{
            basicDelimiter();
        }
    }


    private void basicDelimiter() {
        String[] strArr = input.split(",|:");
        calculate(strArr, ",|:");
    }


    private void customDelimiter() {
        int idx = input.indexOf("\\n", 2);
        String delimiter = ",|:|";

        if (inputLen == idx+2){
            isNull();
            return;
        }

        if (idx == -1) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        } else if(idx == 2){
            String[] strArr = input.split(delimiter+"|");
        } else{
            delimiter += input.substring(2, idx).replace("|", "\\|");
        }

        String checkStr = input.substring(idx+2, inputLen);

        String[] strArr = checkStr.split(delimiter);
        calculate(strArr, delimiter);
    }


    private void isNull(){
        result = 0;
    }


    public int isPositiveNum(String s, String delimiter){

    }


    private void calculate(String[] strArr, String delimiter){
        for (String s : strArr) {
            if (s != null){
                result += isPositiveNum(s, delimiter);
            }
        }
    }


    public void printResult(){

    }




}














