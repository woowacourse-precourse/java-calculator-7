package calculator.domain;


import calculator.util.Parser;
import java.util.List;

public class UserInput {
    private final String input;
    private final boolean hasCustomDelimiter;
    private final List<String> delimiters;

    public UserInput(String input){
        this.hasCustomDelimiter = Parser.hasCustomDelimiter(input);
        this.input = hasCustomDelimiter ? input : input.replace(" ","");
        this.delimiters = hasCustomDelimiter ? List.of(Parser.extractCustomDelimiter(input)) : List.of(":",",");
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
