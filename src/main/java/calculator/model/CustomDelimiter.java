package calculator.model;


public class CustomDelimiter {
    private static final String INVALID_CUSTOM_DELIMITER = "커스텀 구분자가 정상적으로 입력되지 않았습니다.";
    
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
        return formula.substring(2, delimiterEndIndex);
    }

    public Integer checkCustomDelimiter(){
        if (formula.startsWith("//")){
            int delimiterEndIndex = formula.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER);
            }
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
