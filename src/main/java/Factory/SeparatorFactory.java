package Factory;

import exception.ExceptionMessage;
import separator.CustomSeparator;
import separator.CustomSeparatorFormat;
import separator.DefaultSeparator;
import separator.Separator;

import java.util.List;


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
        String replaceInput = normalizeInputData();
        if (isDefaultSeparator(replaceInput)) {
            return new DefaultSeparator(replaceInput, this.defaultSeparators);
        }
        return new CustomSeparator(replaceInput, customSeparatorFormat);
    }

    public String normalizeInputData() {
        String replaceInput = inputData.replace(" ", "");
        replaceInput = replaceBlankOrEmptyWithDefault(replaceInput);
        return replaceInput;
    }

    public String replaceBlankOrEmptyWithDefault(String replaceInput) {
        if(replaceInput.isBlank() || replaceInput.isEmpty()){
            replaceInput ="0";
        }
        return replaceInput;
    }

    public Boolean isDefaultSeparator(String replaceInput) {
        try {
            Integer.parseInt(replaceInput.substring(0, 1));
            return true;
        } catch (NumberFormatException e) {
            if(!replaceInput.substring(0,2).contains("//")){
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CUSTOM_SEPARATOR_FORMAT.getMessage());
            }
            return false;
        }
    }
}
