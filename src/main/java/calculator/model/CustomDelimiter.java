package calculator.model;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CustomDelimiter {
    private String formula;

    public CustomDelimiter(String formula){
        this.formula = formula;
    }

    public String getFormula(){
        return this.formula;
    }

    public String getCustomDelimiter(){
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(formula);
        return matcher.group(1);
    }

    public boolean checkCustomDelimiter(){
        String[] splitedNumbers = formula.split("[,;]");
        String engraftedNumbers = String.join("", splitedNumbers);  
        if (!engraftedNumbers.matches("\\d+")){
            return true;
        }
        return false;
    }

    public String SplitDelimiter(){
        String[] splitedNumbers = formula.split("\n");
        return splitedNumbers[1];
    }
}
