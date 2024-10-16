package calculator;

import java.util.HashSet;
import java.util.Set;

public class CheckForm {

    private static final String errorMessage = "적절하지 않은 형식입니다.";

    public static void throwException(){
        throw new IllegalArgumentException(errorMessage);
    }

    public static void checkFormOfCustomSeparator(InputString inputString){
        String input = inputString.getInput();

        if(isStartsWithTwoSlash(input)){
            checkContainNewLine(input);
            checkSeparatorIsCharacter(input);
            checkIsCustomSeparatorEmpty(input);
        }
    }

    public static void checkFormOfOperands(InputString inputString){
        String input = inputString.getInput();

        if(isStartsWithTwoSlash(input)){
            input = input.substring(input.indexOf("\\n")+2);
        }

        Set<Character> separators = inputString.getSeparator();

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
