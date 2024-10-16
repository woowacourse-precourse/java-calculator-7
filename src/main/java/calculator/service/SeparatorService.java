package calculator.service;

import calculator.domain.Separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorService {

    private static final String REGEX_PATTERN = "^//(.)(\\\\n.*)";

    public static void makeUpSeparators(){
        String userInput = ValueService.getOriginalInput();
        if(isCustomSeparatorExist(userInput)){
            String customSeparator = extractCustomSeparator(userInput);
            addSeparator(customSeparator);
        }
    }

    public static boolean isCustomSeparatorExist(String inputString){
        return Pattern.matches(REGEX_PATTERN,inputString);
    }

    public static String extractCustomSeparator(String inputString){
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = pattern.matcher(inputString);
        String separator = "";
        if(matcher.matches()){
            separator =  matcher.group(1);
        }
        return separator;
    }

    public static void addSeparator(String customSeparator){
        Separator.addSeparator(customSeparator);
    }

    public static String getSeparators(){
        return Separator.getSeparators();
    }
}
