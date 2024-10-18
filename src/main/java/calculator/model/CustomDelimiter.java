package calculator.model;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CustomDelimiter {
    private static final String INVALID_CUSTOM_DELIMITER = "커스텀 구분자가 정상적으로 입력되지 않았습니다.";
    private static final String NO_INPUT_NUMBERS = "숫자가 입력되지 않았습니다.";
    private String formula;

    public CustomDelimiter(String formula){
        this.formula = formula;
    }

    public String getFormula(){
        return this.formula;
    }

    public String getCustomDelimiter(){
        if (!checkCustomDelimiter()) {
            return null;
        }
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(formula);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER);
        }
    }

    public boolean checkCustomDelimiter(){
        return formula.startsWith("//");
    }

    public String getNumbersPart(){
        if (checkCustomDelimiter()) {
            String[] splitedNumbers = formula.split("\n", 2);
            if (splitedNumbers.length > 1) {
                return splitedNumbers[1];
            } else {
                throw new IllegalArgumentException(NO_INPUT_NUMBERS);
            }
        } else {
            return formula;
        }
    }
}
