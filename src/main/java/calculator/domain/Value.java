package calculator.domain;

import java.util.Arrays;

public class Value {
    private static String originalValue;
    private static String[] separatedValue;

    public static void setOriginalValue(String userInput){
        originalValue = userInput;
    }

    public static void saveParts(String[] parts){
        separatedValue = Arrays.copyOf(parts, parts.length);
    }

    public static String getOriginalInput(){
        return originalValue;
    }

    public static String[] getSeparatedValue(){
        return separatedValue;
    }
}
