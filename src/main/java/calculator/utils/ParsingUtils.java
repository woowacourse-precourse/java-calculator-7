package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.constant.UtilsConstant.REGEX;

public class ParsingUtils {

    public static List<String> splitUserInputTowPart(String userInput){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(userInput);

        List<String> twoPartUserInput = new ArrayList<>();
        if(matcher.find()){
            twoPartUserInput.add(matcher.group(1));
            twoPartUserInput.add(matcher.group(2));
        }
        else{
            twoPartUserInput.add(userInput);
        }
        return twoPartUserInput;
    }

    public static String buildMultiDelimiterFromSet(Set<String> delimiters) {
        StringBuilder regex = new StringBuilder();
        regex.append("[");
        for (String delimiter : delimiters) {
            regex.append("\\").append(delimiter);
        }
        regex.append("]");
        return regex.toString();
    }
}
