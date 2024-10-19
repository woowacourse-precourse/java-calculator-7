package calculator;

import java.util.Set;

public class CheckForm {

    private static final String errorMessage = "적절하지 않은 형식입니다.";

    public static void throwException(){
        throw new IllegalArgumentException(errorMessage);
    }

    public static void checkFormOfCustomSeparator(String input){
        if(isStartsWithTwoSlash(input)){
            checkContainNewLine(input);
            checkSeparatorIsCharacter(input);
            checkIsCustomSeparatorEmpty(input);
        }
    }

    public static void checkFormOfOperands(String input, Set<Character> separators){
        if(isStartsWithTwoSlash(input)){
            input = input.substring(input.indexOf("\\n")+2);
        }
        for(char character : input.toCharArray()){
            if(!separators.contains(character) && (character < '0' || character > '9')){
                throwException();
            }
        }
    }

    private static boolean isStartsWithTwoSlash(String input){
        return input.startsWith("//");
    }

    private static void checkContainNewLine(String input){
        if(!input.contains("\\n")) {
            throwException();
        }
    }

    private static void checkSeparatorIsCharacter(String input){
        if(input.indexOf("\\n") != 3){
            throwException();
        }
    }

    private static void checkIsCustomSeparatorEmpty(String input){
        if(input.substring(0, input.indexOf("\\n")).isEmpty()){
            throwException();
        }
    }
}
