package calculator.inputType;

import calculator.constants.StringConst;

public class DefaultInput implements InputType {

    public boolean check(String input) {
        if (input.contains(StringConst.COMMA) || input.contains(StringConst.COLON)) {
            return true;
        }
        return false;
    }


    public String getType() {
        return StringConst.DEFAULT_INPUT;
    }
}
