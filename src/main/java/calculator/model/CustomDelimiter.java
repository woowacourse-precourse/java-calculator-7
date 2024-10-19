package calculator.model;

import calculator.validation.Validator;

public class CustomDelimiter {
    
    private String formula;

    public CustomDelimiter(String formula){
        this.formula = formula.replace("\\n", "\n");
    }

    public String getFormula(){
        return this.formula;
    }

    public String getCustomDelimiter(){
        Integer delimiterEndIndex = checkCustomDelimiter();
        if (delimiterEndIndex == null) {
            return null;
        }
        String customDelimiter = formula.substring(2, delimiterEndIndex);
        Validator.isValidDelimiter(customDelimiter);
        return customDelimiter;
    }


    public Integer checkCustomDelimiter(){
        if (formula.startsWith("//")){
            int delimiterEndIndex = formula.indexOf("\n");
            Validator.isThereSeparator(delimiterEndIndex);
            return delimiterEndIndex;
        }
        return null;
    }

    public String getNumbersPart(){
        Integer delimiterEndIndex = checkCustomDelimiter();
        if (delimiterEndIndex != null) {
            return formula.substring(delimiterEndIndex + 1);
        }
        return formula;
    }
}
