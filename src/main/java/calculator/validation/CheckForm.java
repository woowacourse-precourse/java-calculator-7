package calculator.validation;

import java.util.Set;

import static calculator.data.keywords.DOUBLE_SLASH;
import static calculator.data.keywords.NEW_LINE;

public class CheckForm {

    private static final String errorMessage = "적절하지 않은 형식입니다.";

    private CheckForm(){}

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
            input = input.substring(input.indexOf(NEW_LINE.getKeyword())+2);
        }
        for(char character : input.toCharArray()){
            if(!separators.contains(character) && (character < '0' || character > '9')){
                throwException();
            }
        }
    }

    private static boolean isStartsWithTwoSlash(String input){
        return input.startsWith(DOUBLE_SLASH.getKeyword());
    }

    private static void checkContainNewLine(String input){
        if(!input.contains(NEW_LINE.getKeyword())) {
            throwException();
        }
    }

    private static void checkSeparatorIsCharacter(String input){
        if(input.indexOf(NEW_LINE.getKeyword()) != 3){
            throwException();
        }
    }

    private static void checkIsCustomSeparatorEmpty(String input){
        if(input.substring(0, input.indexOf(NEW_LINE.getKeyword())).isEmpty()){
            throwException();
        }
    }
}
