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

        ExceptionUtils.throwCanNotParseToNumberException();
        return null;
    }

}
