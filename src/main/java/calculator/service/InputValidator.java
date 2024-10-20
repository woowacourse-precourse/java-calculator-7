package calculator.service;

import static calculator.common.util.CalculatorUtil.*;

import calculator.common.constants.RegexPatterns;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public Boolean isValidInput(String input) {
        // TODO: 올바른 형식으로 입력했는지 확인합니다.
        /* *
         * 1. 숫자 앞이나 뒤에 문자가 포함되어있는지 확인합니다
         * 2. 공백 input 이면 return false
         * **/

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
        // TODO : 커스텀 구분자 선언부가 1개만 존재하는 지 확인합니다.

        String formattingString = formattingString(inputValue);

        Pattern pattern = Pattern.compile(RegexPatterns.CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(formattingString);

        return !matcher.find();
    }

    public Boolean isContainInvalidChar(String inputValue) {

        // TODO : 추출한 delimiter 외 다른 '문자' 또는 '공백'을 포함하는 지 확인합니다.

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
