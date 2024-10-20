package calculator.domain;

import static calculator.global.constant.Config.*;

import java.util.Arrays;
import java.util.regex.Pattern;


public class LetterManager {

    public String replaceCustomSeparatorToSeparator(String letters, String[] customSeparators) {
        return Arrays.stream(customSeparators)
                .reduce(letters, this::replaceSingleSeparator);
    }

    private String replaceSingleSeparator(String letters, String customSeparator) {
        String regex = Pattern.quote(START_OF_CUSTOM_SEPARATOR_LETTER) +
                Pattern.quote(customSeparator) +
                Pattern.quote(END_OF_CUSTOM_SEPARATOR_LETTER);
        return letters.replaceAll(regex, customSeparator);
    }

}
