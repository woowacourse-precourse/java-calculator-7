package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingUtils {

    public static List<String> parsingUserInput(String userInput){
        String pattern = "//.*\\n";

        Matcher matcher = Pattern.compile(pattern).matcher(userInput);

        List<String> paringUserInput = new ArrayList<>();
        if(matcher.find()){
            String customDelimiter = userInput.substring(2, userInput.lastIndexOf("\n"));
            paringUserInput.add(customDelimiter);

            String numberString = userInput.substring(userInput.lastIndexOf("\n") + 1);
            paringUserInput.add(numberString);
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
