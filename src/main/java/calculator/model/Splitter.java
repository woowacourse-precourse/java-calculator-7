package calculator.model;
import java.util.regex.Pattern;


public class Splitter {
    public static String[] splitNumbers(FormulaHandler formulaHandler){
        String delimiter = ",|:";
        String numbers = formulaHandler.getNumbersPart();
        String customDelim = formulaHandler.getCustomDelimiter();
        if(customDelim != null){
            delimiter = delimiter + "|" + Pattern.quote(customDelim);
        }
        return numbers.split(delimiter);
    }
}
