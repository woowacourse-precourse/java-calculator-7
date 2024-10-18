package calculator.tokenizer;

import calculator.utils.FormatUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomizedString {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*?)\\\\n");

    private Character customDelimiter;
    private String originalString;

    public CustomizedString(String str) {
        detachCustomDelimiter(str);
    }

    private void detachCustomDelimiter(String str) {
        Matcher delimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(str);
        if (!delimiterMatcher.find()) {
            this.originalString = str;
            return;
        }
        this.customDelimiter = toValidDelimiter(delimiterMatcher.group(1));
        this.originalString = removeCustomSetting(str, delimiterMatcher.group(0).length());
    }

    private String removeCustomSetting(String str, int settingLength) {
        if (str.length() == settingLength) {
            return "";
        }
        return str.substring(settingLength);
    }

    private char toValidDelimiter(String delimiter) {
        if (isInvalidDelimiter(delimiter)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 아닌 한 글자로 지정 가능합니다.");
        }
        return delimiter.charAt(0);
    }

    private boolean isInvalidDelimiter(String delimiter) {
        return delimiter.length() != 1 || FormatUtils.isNumeric(delimiter);
    }

    public boolean hasCustomDelimiter() {
        return customDelimiter != null;
    }

    public Character getCustomDelimiter() {
        return customDelimiter;
    }

    public String getOnlyString() {
        return originalString;
    }

}
