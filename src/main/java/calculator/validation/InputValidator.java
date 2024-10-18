package calculator.validation;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


import calculator.model.CustomDelimiter;
import calculator.model.Splitter;

public class InputValidator {
    private static final String NON_NATURAL_NUMBER = "자연수를 입력해주세요.";
    private static final String INVALID_CUSTOM_DELIMITER = "커스텀 구분자가 정상적으로 입력되지 않았습니다.";

    public void mainInputValidator(CustomDelimiter formula){
        if (formula.checkCustomDelimiter()){
            validateCustomDelimiter(formula.getFormula());
        }
        validateNatureNumber(formula);
    }

    private void validateCustomDelimiter(String numbers){
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(numbers);
        if (!numbers.contains("//") || !numbers.contains("\n")){
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER);
        }
        if (matcher.group(1).matches(".*\\d.*")){
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER);
        }
        if (matcher.group(1) == "" || matcher.group(1) == " "){
            throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER);
        }
    }

    private void validateNatureNumber(CustomDelimiter formula){
        String numbers = formula.getFormula();
        numbers = formula.SplitDelimiter();
        if(numbers.isEmpty()){
            throw new IllegalArgumentException(NON_NATURAL_NUMBER);
        }
        Splitter splitter = new Splitter(formula);
        String[] splitedNumbers = splitter.getSplittedNumbers();
        for(String number : splitedNumbers){
            if (!number.matches("\\d+")){
                throw new IllegalArgumentException(NON_NATURAL_NUMBER);
            }
        }
    }

}
