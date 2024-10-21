package calculator.validator;

import calculator.constants.StringConst;
import calculator.inputType.InputType;
import calculator.inputType.InputTypeProvider;
import calculator.utils.ExceptionUtils;
import java.util.List;

public class ValidatorImpl implements Validator {


    public String canParseToNumber(String input) {
        List<InputType> inputTypelist = InputTypeProvider.provideInputTypelist();
        InputType customInput = inputTypelist.get(0);
        String customInputName = customInput.getType();
        InputType defaultInput = inputTypelist.get(1);
        String defaultInputName = defaultInput.getType();
        if (customInput.check(input) && customInputName.equals(StringConst.CUSTOM_INPUT)) {
            return StringConst.CUSTOM_INPUT;
        }
        if (defaultInput.check(input) && defaultInputName.equals(StringConst.DEFAULT_INPUT)) {
            return StringConst.DEFAULT_INPUT;
        }

        ExceptionUtils.throwInvalidFormatException();
        return null;
    }

    public boolean isDelimiterNullOrBlank(String delimiter) {
        if (delimiter == null || delimiter.isBlank()) {
            ExceptionUtils.throwCustomDelimiterCanNotBeBlankException();
        }
        return true;

    }


    public boolean isNotNumeric(String escapeDelimiter) {

        try {
            Long.parseLong(escapeDelimiter);
            ExceptionUtils.throwDelimiterCanNotBeNumberException();
        } catch (NumberFormatException e) {

        }
        return true;

    }


    public boolean isDelimiterLengthOne(String delimiter) {
        if (delimiter.length() != 1) {
            ExceptionUtils.throwCustomDelimiterLengthMustBeOneException();
        }
        return true;

    }


    public boolean isNotCustomEqualDefault(String delimiter) {
        if (delimiter.equals(StringConst.COMMA) || delimiter.equals(StringConst.COLON)) {
            ExceptionUtils.throwCustomCanNotBeDefaultDelimiterException();
        }
        return true;

    }


}
