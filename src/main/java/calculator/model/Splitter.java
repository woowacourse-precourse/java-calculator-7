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
