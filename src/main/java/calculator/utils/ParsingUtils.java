package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingUtils {

    public static List<String> parsingUserInput(String userInput){
        String regex = "//(.*)\\\\n(.*)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userInput);

        List<String> paringUserInput = new ArrayList<>();
        if(matcher.find()){
            paringUserInput.add(matcher.group(1));
            paringUserInput.add(matcher.group(2));
        }
        else{
            paringUserInput.add(userInput);
        }
        return paringUserInput;
    }

    public static String buildRegexFromSet(Set<String> delimiters) {
        StringBuilder regex = new StringBuilder();
        regex.append("[");
        for (String delimiter : delimiters) {
            regex.append("\\").append(delimiter);
        }
        regex.append("]");
        return regex.toString();
    }
}
