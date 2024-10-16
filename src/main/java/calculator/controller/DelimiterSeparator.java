package calculator.controller;

import calculator.model.Delimiter;

public class DelimiterSeparator {

    public static boolean isNumber(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static int registerDelimiter(String userInput){
        int index = 0;
        if(!isNumber(userInput.substring(0,1))){
            index = specifyingDelimiter(userInput);
        }
        return index;
    }

    public static int specifyingDelimiter(String userInput){
        if(!userInput.startsWith("//")){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        int index = 2;
        Delimiter.updateDelimiter(userInput.charAt(index));
        if(!userInput.substring(index+1,index+3).equals("\n")){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        return index + 3;
    }

    public static void separateDelimiter(String str){
        if(isNumber(str)){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        // 구분자가 아니면 오류
    }
}
