package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.util.Validator.validCustomSeparator;
import static calculator.util.Validator.validExtractList;


public class Util {
    private static final String BASIC_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\\\\n(.*)";

    public void extract(String text){
        String[] extractList = separatorExtract(text);
        validExtractList(extractList);
    }
    private String[] separatorExtract(String text){
        if(text.startsWith("//")){
            return customSeparatorExtract(text);
        }
        return basicSeparatorExtract(text);
    }

    private String[] basicSeparatorExtract(String text){
        return text.split(BASIC_SEPARATOR);
    }

    private String[] customSeparatorExtract(String text){
        validCustomSeparator(text);
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        if (matcher.matches()) {
            String customSeparator = matcher.group(1);
            String customInput = matcher.group(2);
            return customInput.split(customSeparator);
        }
        throw new IllegalArgumentException();
    }

}
