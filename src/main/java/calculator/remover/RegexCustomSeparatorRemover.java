package calculator.remover;

import static calculator.constant.Constants.Regex.CUSTOM_SEPARATOR_FORMAT_REGEX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCustomSeparatorRemover implements CustomSeparatorRemover {
    @Override
    public String run(String input) {
        Matcher matcher = getMatcher(input);
        if (!haveCustomSeparator(matcher)) {
            return input;
        }

        return removeCustomSeparator(matcher);
    }

    private Matcher getMatcher(String input) {
        return Pattern.compile(CUSTOM_SEPARATOR_FORMAT_REGEX)
                .matcher(input);
    }

    private String removeCustomSeparator(Matcher matcher) {
        return matcher.group(2);
    }

    private boolean haveCustomSeparator(Matcher matcher) {
        return matcher.matches();
    }
}
