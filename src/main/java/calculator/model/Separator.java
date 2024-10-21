package calculator.model;

import calculator.constant.SeparatorConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    private List<Character> separatorList = new ArrayList<>(Arrays.asList(':', ','));

    public void checkCustomSeparator(String expression) {

        if (expression.length() >= 5
                && expression.substring(SeparatorConstant.LEFT_START, SeparatorConstant.LEFT_END)
                .equals(SeparatorConstant.LEFT_SEPARATOR)
                && expression.substring(SeparatorConstant.RIGHT_START, SeparatorConstant.RIGHT_END)
                .equals(SeparatorConstant.RIGHT_SEPARATOR)) {
            separatorList.add(expression.charAt(2));
        }
    }

    public List<Character> getSeparatorList() {
        return separatorList;
    }
}
