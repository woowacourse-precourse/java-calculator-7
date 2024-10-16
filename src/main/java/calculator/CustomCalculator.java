package calculator;

import calculator.utils.CalculatorUtils;

import java.util.Arrays;

public class CustomCalculator implements Calculator{

    private static final String META_CHARS = "*+?$^.()|\\{}[";

    @Override
    public int calculate(String inputString){
        String targetString = inputString.substring(5);
        if (isTargetStringEmpty(targetString)){
            return 0;
        }
        String[] split = targetString.split(getSplitRegex(inputString.charAt(2)));
        return CalculatorUtils.sumSplitArray(split);
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
