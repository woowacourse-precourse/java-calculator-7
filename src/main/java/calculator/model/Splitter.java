package calculator.model;
import java.util.regex.Pattern;


public class Splitter {
    private String[] splitterNumbers;

    public Splitter(CustomDelimiter customDelimiter){
        this.splitterNumbers = splitNumbers(customDelimiter);
    }

    public String[] splitNumbers(CustomDelimiter customDelimiter){
        String delimiter = "";
        String numbers = customDelimiter.getFormula();
        if(customDelimiter.checkCustomDelimiter()){
            delimiter = customDelimiter.getCustomDelimiter();
            numbers = customDelimiter.SplitDelimiter();
            return numbers.split("[,;]|" + Pattern.quote(delimiter));
        }
            return numbers.split("[,;]");
    }

}
