package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    private final String BASIC_SEPARATOR = "[,:]";

    public void extract(String text){
        separatorExtract(text);
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

    }

}
