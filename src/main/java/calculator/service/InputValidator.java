package calculator.service;

import static calculator.common.util.CalculatorUtil.*;

import calculator.common.constant.RegexPatterns;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public Boolean isValidInput(String input) {
        if (isEmptyInput(input)) return false;

        if (isStartOrEndWithWord(input)) return false;

        if (!isOnlyOneCustomDeclare(input)) return false;

        if (isContainInvalidChar(input)) return false;
        return true;
    }

    public Boolean isStartOrEndWithWord(String input) {
        String formattingString = formattingString(input);

        Pattern startPattern = Pattern.compile(RegexPatterns.START_WITH_WORD);
        Pattern endPattern = Pattern.compile(RegexPatterns.END_WITH_WORD);

        Matcher startMatcher = startPattern.matcher(formattingString);
        Matcher endMatcher = endPattern.matcher(formattingString);

        return startMatcher.find() || endMatcher.find();
    }

    public Boolean isEmptyInput(String input) {
        return input.length() == 0;
    }

    public Boolean isOnlyOneCustomDeclare(String inputValue) {

        String formattingString = formattingString(inputValue);

        Pattern pattern = Pattern.compile(RegexPatterns.CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(formattingString);

        return !matcher.find();
    }

    public Boolean isContainInvalidChar(String inputValue) {

        List<String> delimiters = extractDelimiter(inputValue);

        String formattingString = formattingString(inputValue);

        for (String delimiter : delimiters) {
            formattingString = formattingString.replaceAll(Pattern.quote(delimiter), "");
        }

        for (char s : formattingString.toCharArray()) {
            if (!Character.isDigit(s)) return true;
        }
        return false;
    }
}
