package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\\\\n(.*)";

    public static void validExtractList(String[] inputExtractText){
        for(String text : inputExtractText){
            validNumberFormat(text);
        }
    }

    private static void validNumberFormat(String text){
        try{
            int number = Integer.parseInt(text);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    public static void validCustomSeparator(String text){
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        if(!matcher.matches()||matcher.group(1).isEmpty()){
            throw new IllegalArgumentException();
        }
    }
}
