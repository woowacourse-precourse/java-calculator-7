package calculator;

import java.util.regex.Pattern;

public class StringFilter {
    private final String DEFAULT_DELIMITER = "[,:]";
    private final StringValidator validator = new StringValidator();

    //기본 구분자로 문자열 나누기
    public String[] delimiterSplit(String input) {
        if (input.contains("//") && input.contains("\\n")) {
            String[] splitCustomDelimiter = splitCustomDelimiter(input);
            validator.validateString(splitCustomDelimiter);
            validator.validateNegativeNumber(splitCustomDelimiter);
            return splitCustomDelimiter;
        }

        String[] splitDefaultDelimiter = input.split(DEFAULT_DELIMITER);
        validator.validateString(splitDefaultDelimiter);
        validator.validateNegativeNumber(splitDefaultDelimiter);
        return splitDefaultDelimiter;
    }

    private static String[] splitCustomDelimiter(String Input) {
        String joinedString = String.join("", Input);
        String replaceString = joinedString.replace("//", "").replace("\\n", "");
        String customDelimiter = replaceString.substring(0, 1);

        return replaceString.substring(1).split(Pattern.quote(customDelimiter));
    }




}