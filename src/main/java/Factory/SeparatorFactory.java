package Factory;

import separator.CustomSeparator;
import separator.CustomSeparatorFormat;
import separator.DefaultSeparator;
import separator.Separator;

import java.util.List;
import java.util.regex.Matcher;

public class SeparatorFactory {
    private final List<String> defaultSeparators;
    private final CustomSeparatorFormat customSeparatorFormat;
    private final String inputData;

    public SeparatorFactory(List<String> defaultSeparators, CustomSeparatorFormat customSeparatorFormat, String inputData) {
        this.defaultSeparators = defaultSeparators;
        this.customSeparatorFormat = customSeparatorFormat;
        this.inputData = inputData;
    }

    public Separator generateSeparators() {
        if (validateStartChar()) return new DefaultSeparator(this.inputData, this.defaultSeparators);

        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        validateCustomSeparatorFormat();
        return new CustomSeparator(inputData, customSeparatorFormat);

    }

    public Boolean validateStartChar() {
        if (inputData.equals(" ")) return true;
        try {
            Integer.parseInt(inputData.substring(0, 1));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void validateCustomSeparatorFormat() {
        Matcher matcher = customSeparatorFormat.getPattern().matcher(inputData);
        if (!matcher.find()) throw new IllegalArgumentException("커스텀구분자 생성형식을 확인해주세요.");
    }

}
