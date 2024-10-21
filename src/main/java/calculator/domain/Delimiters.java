package calculator.domain;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static calculator.utils.Constants.DEFAULT_DELIMITER1;
import static calculator.utils.Constants.DEFAULT_DELIMITER2;

public class Delimiters {
    private final ArrayList<String> delimiters;

    public Delimiters(){
        this.delimiters = new ArrayList<>();
        addDefaultDelimiters();
    }

    private void addDefaultDelimiters() {
        delimiters.add(DEFAULT_DELIMITER1);
        delimiters.add(DEFAULT_DELIMITER2);
    }

    public void addCustomDelimiter(String customDelimiter){
        delimiters.add(customDelimiter);
    }

    public String createRegexFromDelimiters(){
        StringBuilder regexBuilder = new StringBuilder();
        for(String delimiter : delimiters){
            //구분자를 이스케이프하여 추가
            String escapeDelimiter = Pattern.quote(delimiter);
            regexBuilder.append(escapeDelimiter);
            regexBuilder.append("|");
        }
        regexBuilder.setLength(regexBuilder.length() - 1);
        return regexBuilder.toString();
    }
}
