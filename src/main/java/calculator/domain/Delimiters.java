package calculator.domain;

import java.util.ArrayList;

import static calculator.utils.Constants.DEFAULT_DELIMITER1;
import static calculator.utils.Constants.DEFAULT_DELIMITER2;

public class Delimiters {
    private ArrayList<Character> delimiters;

    public Delimiters(){
        this.delimiters = new ArrayList<>();
        addDefaultDelimiters();
    }

    private void addDefaultDelimiters() {
        delimiters.add(DEFAULT_DELIMITER1);
        delimiters.add(DEFAULT_DELIMITER2);
    }

    public void addCustomDelimiter(char customDelimiter){
        delimiters.add(customDelimiter);
    }

    public String createRegexFromDelimiters(){
        StringBuilder regexBuilder = new StringBuilder("[");
        for(char ch : delimiters){
            regexBuilder.append(ch);
        }
        regexBuilder.append("]");
        return regexBuilder.toString();
    }
}
