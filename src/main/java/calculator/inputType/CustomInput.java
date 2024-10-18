package calculator.inputType;

import calculator.constants.StringConst;

public class CustomInput implements InputType {

    public boolean check(String input) {
        if (input.startsWith(StringConst.CUSTOM_START_STRING) && input.contains(StringConst.LINE_SEPARATOR_STRING)) {
            return true;
        }
        return false;
    }


    public String getType() {
        return StringConst.CUSTOM_INPUT;
    }
}
