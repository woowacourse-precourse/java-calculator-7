package calculator;

import java.util.Arrays;

public class CustomCalculator{

    private static final String META_CHARS = "*+?$^.()|\\{}[";

    public int customCalculate(String inputString){
        String targetString = inputString.substring(5);
        if (isTargetStringEmpty(targetString)){
            return 0;
        }
        String[] elements = targetString.split(getSplitRegex(inputString.charAt(2)));
        int[] intArray = Validator.validateToIntArray(elements);
        Validator.checkHasNotPositive(intArray);
        return Arrays.stream(intArray)
                .sum();
    }

    private String getSplitRegex(Character separator) {
        if (separator.equals('\\')) {
            return "\\\\";
        }
        if (isMeta(separator)){
            return "\\" + separator;
        }
        return Character.toString(separator);
    }

    private boolean isMeta(Character separator) {
        return META_CHARS.indexOf(separator) != -1;
    }

    private boolean isTargetStringEmpty(String targetString){
        return targetString.isEmpty();
    }


}
