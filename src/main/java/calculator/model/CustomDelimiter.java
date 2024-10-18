package calculator.model;

import calculator.util.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter extends Delimiter {
    public CustomDelimiter(String delimiter) {
        super(delimiter);
    }

    @Override
    public void validate() {
        Matcher inValidDelimiter = createMatcher("[0-9\\-\\\\/]");

        if (delimiter.length() > 3) {
            throw new IllegalArgumentException("[ERROR][R0001] 커스텀 구분자는 최대 3개까지 등록 가능합니다.");
        }

        if (inValidDelimiter.find()) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_FORMAT.getError());
        }
    }

    private Matcher createMatcher(String regex) {
        Pattern customDelimiterPattern = Pattern.compile(regex);
        return customDelimiterPattern.matcher(delimiter);
    }
}
