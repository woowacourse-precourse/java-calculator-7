package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    public StringProcessor(String readString) {
        String[] stringArray = splitString(readString);
    }

    private String[] splitString(String readString) {
        String basic = ",:";
        String custom =  "//(.*)\\\\n";;
        Pattern pattern = Pattern.compile(custom);
        Matcher matcher = pattern.matcher(readString);
        if (matcher.find()){
            custom =  "//\\\\n" + matcher.group(1);
            return readString.split("["+basic+custom+"]");
        }
        return readString.split("["+basic+"]");
    }
}
