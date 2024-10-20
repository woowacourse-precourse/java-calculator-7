package calculator.service;

import static calculator.util.CalculatorUtil.*;

import calculator.util.CalculatorUtil;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public Boolean isValidInput(String input) {
        if (!isOnlyOneCustomDeclare(input)) return false;

        if (isContainInvalidChar(input)) return false;
        return true;
    }

    public Boolean isOnlyOneCustomDeclare(String inputValue) {
        // TODO : 커스텀 구분자 선언부가 1개만 존재하는 지 확인합니다.

        String formattingString = formattingString(inputValue);

        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
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
