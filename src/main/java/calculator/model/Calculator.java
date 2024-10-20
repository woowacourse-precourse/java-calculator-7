package calculator.model;

public class Calculator {

    private String[] splitString(String input){
        String delimeter = ",|:"; //기본 구문자 지정
        return input.split(delimeter);
    }
}
