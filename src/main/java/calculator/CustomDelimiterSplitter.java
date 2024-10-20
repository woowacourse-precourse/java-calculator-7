package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterSplitter extends AbstractDelimiterSplitter {

    private static final Pattern compile = Pattern.compile("//(.+)\\n(.*)");

    @Override
    protected boolean splitValue(Container container, String value) {
        Matcher matcher = compile.matcher(value);
        if (isNotMatch(matcher)) {
            return false;
        }

        String delimiter = matcher.group(1);
        String target = matcher.group(2);
        container.contain(target.split(Pattern.quote(delimiter)));
        return true;
    }

    private boolean isNotMatch(Matcher matcher) {
        return !matcher.matches();
    }

}
