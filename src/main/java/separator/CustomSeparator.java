package separator;

import exception.ExceptionMessage;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class CustomSeparator implements Separator {
    private final String inputData;
    private final List<String> customSeparators;
    private final CustomSeparatorFormat customSeparatorFormat;

    public CustomSeparator(String inputData, CustomSeparatorFormat customSeparatorFormat) {
        this.inputData = inputData;
        this.customSeparatorFormat = customSeparatorFormat;
        this.customSeparators = List.of(findSeparator());
    }

    public CustomSeparator(String inputData, List<String> customSeparators, CustomSeparatorFormat customSeparatorFormat) {
        this.inputData = inputData;
        this.customSeparatorFormat = customSeparatorFormat;
        this.customSeparators = customSeparators;
    }
    public String findSeparator() {
        validateCustomSeparatorFormat();
        Matcher matcher = customSeparatorFormat.getPattern().matcher(inputData);
        if (matcher.find()) {
            return matcher.group(1);
        }

        throw new IllegalArgumentException(ExceptionMessage.CUSTOM_SEPARATOR_NOT_FOUND.getMessage());

    }

    public void validateCustomSeparatorFormat() {
        // TODO validate 책임 나누기
        Pattern pattern = Pattern.compile("//+(.*?)\\\\n");
        Matcher inputMatcher = customSeparatorFormat.getPattern().matcher(inputData);
        Matcher separatorMatcher = pattern.matcher(inputData);
        if (separatorMatcher.find()) {
            if (separatorMatcher.group(1).contains("\\")) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CUSTOM_SEPARATOR_CONTAINS_BACKSPACE.getMessage());
            }
        }
        String firstSeparatorChar = inputData.substring(2, 3);
        try {
            Integer.parseInt(firstSeparatorChar);
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CUSTOM_SEPARATOR_CONTAINS_NUMBER.getMessage());
        } catch (NumberFormatException ignored) {

        }
        if (!inputMatcher.find())
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CUSTOM_SEPARATOR_FORMAT.getMessage());
    }

    @Override
    public List<String> getSeparator() {
        return customSeparators;
    }

    @Override
    public String[] splitInputDataBySeparator() {
        Matcher matcher = customSeparatorFormat.getPattern().matcher(inputData);
        String group = findGroupOrThrow(matcher);
        return splitGroupByCustomSeparator(group);
    }

    private String[] splitGroupByCustomSeparator(String group) {
        if (isEmptyCustomSeparate()) {
            return new String[]{group};
        }
        try {
            return group.split(customSeparators.get(0));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(ExceptionMessage.CUSTOM_SEPARATOR_NOT_FOUND.getMessage());
        }
    }

    private static String findGroupOrThrow(Matcher matcher) {
        String group;
        if (matcher.find()) {
            group = matcher.group(2);
        } else {
            throw new IllegalArgumentException(ExceptionMessage.CUSTOM_SEPARATOR_NOT_FOUND.getMessage());
        }
        return group;
    }

    private boolean isEmptyCustomSeparate() {
        return customSeparators.get(0).isEmpty();
    }

    @Override
    public String getInputData() {
        return inputData;
    }


}
