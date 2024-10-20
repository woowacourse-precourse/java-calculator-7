package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String input;
    private String operator = ",:";
    private String customOperator = "";
    private String[] splitStr;

    public void readLine(){
        input = Console.readLine();
    }

    public String[] splitInput(){
        Pattern pattern = Pattern.compile("//(.*)\\\\n");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            customOperator = matcher.group(1);
            if(customOperator.equals("\\")){
                customOperator = "\\\\";
            }
        }

        //패턴제거 ex) //;\n3:4:5 -> 3:4:5
        String temp = input.replaceAll(pattern.pattern(), "");
        splitStr = temp.split("[" + operator + customOperator + "]");
        return splitStr;
    }

    boolean checkCustomOperator(){
        return customOperator.isEmpty() || customOperator.equals("\\\\")
                || (customOperator.length() == 1 && (customOperator.charAt(0) < '0' || customOperator.charAt(0) > '9'));
    }


    public void isValid() throws IllegalArgumentException{
        if(!checkCustomOperator()){
            throw new IllegalArgumentException("Invalid operator");
        }

        for(String str : splitStr){
            if(!str.matches("^[0-9]*$") || str.equals("0")){
                throw new IllegalArgumentException("Invalid format");
            }
        }
    }

    public Integer getResult(){
        int result = 0;
        for(String str : splitStr){
            if(!str.isEmpty()){
                result += Integer.parseInt(str);
            }
        }
        return result;
    }

    public int initialize(){
        readLine();
        splitInput();
        isValid();
        return getResult();
    }

}
