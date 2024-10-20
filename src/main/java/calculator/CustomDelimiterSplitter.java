package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterSplitter {

    public List<String> split(String value) {
        Pattern compile = Pattern.compile("//(.+)\\n(.*)");
        Matcher matcher = compile.matcher(value);
        boolean matches = matcher.matches();
        String delimiter = matcher.group(1);
        String target = matcher.group(2);

        return toList(target.split(Pattern.quote(delimiter)));
    }

    private List<String> toList(String[] value) {
        return Arrays.asList(value);
    }
}
