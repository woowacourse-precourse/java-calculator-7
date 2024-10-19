package calculator.service;

import calculator.domain.Separator;
import calculator.domain.StringValue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorService {

    private static final String REGEX_PATTERN = "^//(.)(\\\\n.*)";

    public static Separator makeUpSeparators(StringValue stringValue){
        if(isCustomSeparatorExist(stringValue.getOriginalValue())){
            String customSeparator = extractCustomSeparator(stringValue.getOriginalValue());
            StringValueService.removeMarking(stringValue);
            return new Separator(customSeparator);
        }else{
            return new Separator();
        }
    }

    private static boolean isCustomSeparatorExist(String originalInput){
        return Pattern.matches(REGEX_PATTERN,originalInput);
    }

    private static String extractCustomSeparator(String originalInput){
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = pattern.matcher(originalInput);
        String separator = "";
        if(matcher.matches()){
            separator =  matcher.group(1);
        }
        return separator;
    }
}
