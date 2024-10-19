package calculator.dto;

import java.util.ArrayList;
import java.util.List;

public class DelimiterInputDto {
    private String inputString;
    private final List<String> delimiters;

    public DelimiterInputDto(String inputString, List<String> delimiters){
        this.inputString = inputString;
        this.delimiters = delimiters;
    }

    public void setInputString(String inputString){
        this.inputString = inputString;
    }

    public String getInputString(){
        return inputString;
    }

    public void addDelimiter(String delimiter){
        delimiters.add(delimiter);
    }

    public List<String> getDelimiters(){
        return new ArrayList<>(delimiters);
    }
}
