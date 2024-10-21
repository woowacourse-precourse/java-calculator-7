package calculator.extractor;

import static calculator.constant.Constants.Regex.*;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCustomSeparatorExtractor implements CustomSeparatorExtractor {

    @Override
    public Optional<String> run(String input) {
        Matcher matcher = getMatcher(input);

        if (haveCustomSeparator(matcher)) {
            String customSeparator = extractCustomSeparator(matcher);
            return Optional.of(customSeparator);
        }

        return Optional.empty();
    }

    private Matcher getMatcher(String input) {
        return Pattern.compile(CUSTOM_SEPARATOR_FORMAT_REGEX)
                .matcher(input);
    }

    private boolean haveCustomSeparator(Matcher matcher) {
        return matcher.matches();
    }

    private String extractCustomSeparator(Matcher matcher) {
        return matcher.group(1);
    }

}
