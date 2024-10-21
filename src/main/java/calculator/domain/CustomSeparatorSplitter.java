package calculator.domain;

import static calculator.global.constant.Config.END_OF_CUSTOM_SEPARATOR_LETTER;
import static calculator.global.constant.Config.START_OF_CUSTOM_SEPARATOR_LETTER;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorSplitter {

    public String[] extractCustomSeparatorFromLetters(String letters) {
        String regex = Pattern.quote(START_OF_CUSTOM_SEPARATOR_LETTER) + "(.*?)" + Pattern.quote(
                END_OF_CUSTOM_SEPARATOR_LETTER);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(letters);

        List<String> separators = matcher.results()
                .map(result -> result.group(1))
                .toList();

        return separators.toArray(String[]::new);
    }

}
