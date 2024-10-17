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














