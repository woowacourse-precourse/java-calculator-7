package calculator.controller;

import calculator.model.Delimiter;

public class DelimiterSeparator {

    public static int registerDelimiter(String userInput){
        int index = 0;
        if(!NumberChecker.isNumber(userInput.substring(0,1))){
            index = specifyingDelimiter(userInput);
        }
        return index;
    }

    public static int specifyingDelimiter(String userInput){
        if(!userInput.startsWith("//")){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        int index = 2;
        if(userInput.substring(index).length() < 3 ){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        Delimiter.updateDelimiter(userInput.charAt(index));
        if(!userInput.substring(index+1,index+2).equals("\n")){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        return index + 2;
    }

    public static void validateDelimiter(String str){
        if(NumberChecker.isNumber(str)){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        if(!Delimiter.isDelimiter(str)){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
    }
}
