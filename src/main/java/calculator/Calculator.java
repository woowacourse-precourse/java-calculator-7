package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String input;
    private String operator = ",:";
    private String[] splitStr;
    public String readLine(){
        return input = Console.readLine();
    }

    public String[] splitInput(){
        Pattern pattern = Pattern.compile("//.\\\\n");
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            operator += matcher.group(0).charAt(2);
        }

        String[] temp = input.split(pattern.pattern());
        splitStr = temp[temp.length - 1].split("["+operator+"]");

        return splitStr;
    }


    public void isValid() throws IllegalArgumentException{
        for(int i=2; i<operator.length(); i++){
           if(operator.charAt(i)>= '0' && operator.charAt(i)<= '9'){
               throw new IllegalArgumentException("Invalid operator");
           }
        }

        for(String str : splitStr){
            if(!str.matches("^[0-9]*$")){
                throw new IllegalArgumentException("Invalid number");
            }
        }
    }

    public Integer getResult(){
        int result = 0;
        for(String str : splitStr){
            result += Integer.parseInt(str);
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
