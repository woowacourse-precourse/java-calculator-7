package calculator.calculator;

import calculator.Validator;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomCalculator {

    private static final String META_CHARS = "*+?$^.()|\\{}[";

    public int calculate(String inputString) {
        String targetString = getTargetString(inputString);
        if (isTargetStringEmpty(targetString)) {
            return 0;
        }
        String splitRegex = getSplitRegex(inputString.charAt(2));
        String[] elements = targetString.split(splitRegex);
        int[] intArray = Validator.validateToIntArray(elements);
        Validator.checkHasNotPositive(intArray);
        return Arrays.stream(intArray).sum();
    }

    private String getTargetString(String inputString) {
        Pattern pattern = Pattern.compile("(?<=\\\\n)(.*)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    private boolean isTargetStringEmpty(String targetString) {
        return targetString.isEmpty();
    }

    private String getSplitRegex(Character delimiter) {
        if (delimiter.equals('\\')) {
            return "\\\\";
        }
        if (isMeta(delimiter)) {
            return "\\" + delimiter;
        }
        return Character.toString(delimiter);
    }

    private boolean isMeta(Character separator) {
        return META_CHARS.indexOf(separator) != -1;
    }



}
