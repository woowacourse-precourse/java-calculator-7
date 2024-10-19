package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separators {
    private List<String> separator;

    public Separators() {
        this.separator = new ArrayList<>();
        separator.add(",");
        separator.add(":");
    }

    public void getCustomSeparator(String rawString) {
        Matcher matcher = Pattern.compile("(?<=//)(.*?)(?=\n)").matcher(rawString);
        while (matcher.find()) {
            separator.add(matcher.group());
        }
    }
}
