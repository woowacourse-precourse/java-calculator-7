package calculator.logic;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Delimiter {
    public static String[] execution(String str, boolean isCustom) {

        if(isCustom) {
            return doCustomDelimiter(str);
        } else {
            return  doNormalDelimiter(str);
        }
    }

    public static String[] doNormalDelimiter(String str) {
        String delimiter = ",|:";
        return str.split(delimiter);
    }

    public static String[] doCustomDelimiter(String str) {
        String delimiter = CustomChecker.getCustom(str);
        String adjustedStr = str.substring(delimiter.length()+4);
        return adjustedStr.split(Pattern.quote(delimiter));
    }
}
