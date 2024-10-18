package calculator.model;
import java.util.regex.Pattern;


public class Splitter {
    private String[] splittedNumbers;

    public Splitter(CustomDelimiter customDelimiter){
        this.splittedNumbers = splitNumbers(customDelimiter);
    }

    public String[] getSplittedNumbers(){
        return this.splittedNumbers;
    }

    public String[] splitNumbers(CustomDelimiter customDelimiter){
        String delimiter = ",|:";
        String numbers = customDelimiter.getNumbersPart();
        String customDelim = customDelimiter.getCustomDelimiter();
        if(customDelim != null){
            delimiter = delimiter + "|" + Pattern.quote(customDelim);
        }
        return numbers.split(delimiter);
    }

}
