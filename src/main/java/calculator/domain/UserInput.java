package calculator.domain;


import calculator.util.Parser;
import java.util.List;

public class UserInput {
    private final String input;
    private final boolean hasCustomDelimiter;
    private final List<String> delimiters;

    public UserInput(String input, boolean hasCustomDelimiter, List<String> delimiters){
        this.input = input;
        this.hasCustomDelimiter = hasCustomDelimiter;
        this.delimiters = delimiters;
    }

    public String getInput(){
        return input;
    }

    public boolean hasCustomDelimiter(){
        return hasCustomDelimiter;
    }

    public List<String> getDelimiters(){
        return delimiters;
    }
}
