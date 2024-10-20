package separator;

import exception.ExceptionMessage;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        return "";
    }

    public void validateCustomSeparatorFormat() {
        Pattern pattern = Pattern.compile("//+(.*?)\\\\n");
        Matcher inputMatcher = customSeparatorFormat.getPattern().matcher(inputData);
        Matcher separatorMatcher = pattern.matcher(inputData);

        //구분자 안에 포함된 백스페이스 검증
        validateSeparatorDoesNotContainBackslash(separatorMatcher);

        // 커스텀구분자에 포함된 숫자검증
        String firstSeparatorChar = inputData.substring(2, 3);
        validateSeparatorDoesNotContainNumber(firstSeparatorChar);

        //커스텀 구분자 형식 검증
        if (!inputMatcher.find()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CUSTOM_SEPARATOR_FORMAT.getMessage());
        } ;
    }

    private void validateSeparatorDoesNotContainNumber(String firstSeparatorChar) {
        try {
            Integer.parseInt(firstSeparatorChar);
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CUSTOM_SEPARATOR_CONTAINS_NUMBER.getMessage());
        } catch (NumberFormatException ignored) {

        }
    }

    private void validateSeparatorDoesNotContainBackslash(Matcher separatorMatcher) {
        if (separatorMatcher.find()) {
            if (separatorMatcher.group(1).contains("\\")) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CUSTOM_SEPARATOR_CONTAINS_BACKSPACE.getMessage());
            }
        }
    }

    @Override
    public List<String> getSeparator() {
        return customSeparators;
    }

    @Override
    public String[] splitInputDataBySeparator() {
        Matcher matcher = customSeparatorFormat.getPattern().matcher(inputData);
        String group = findGroupOrDefault(matcher);
        return splitGroupByCustomSeparator(group);
    }

    public String[] splitGroupByCustomSeparator(String group) {
        if (isEmptyCustomSeparate()) {
            return new String[]{group};
        }
        return group.split(customSeparators.get(0));

    }

    public String findGroupOrDefault(Matcher matcher) {
        String group = "";
        if (matcher.find()) {
            group = matcher.group(2);
        }
        if (group.isEmpty()) {
            group = "0";
        }

        return group;
    }

    public boolean isEmptyCustomSeparate() {
        return customSeparators.get(0).isEmpty();
    }

    @Override
    public String getInputData() {
        return inputData;
    }
}
