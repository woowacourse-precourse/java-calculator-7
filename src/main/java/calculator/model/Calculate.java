package calculator.model;

import calculator.exception.CalculateException;
import calculator.util.CalculateCustom;
import calculator.util.CalculateDefault;
import java.util.List;

public class Calculate {

    private final List<String> splitUserInput;

    public Calculate(String userInput) {
        //검증 - 기본 구분자나 커스텀 구분자를 포함하지 않았을 경우
        isValidate(userInput);
        //기본 or 커스텀인지 판단해 분리된 문자열 저장
        this.splitUserInput = createSplitUserInput(userInput);
    }

    public void isValidate(String userInput) {
        CalculateException.catchWrongNumberSeparator(userInput);
    }

    public boolean checkContainCustom(String userInput) {
        return !CalculateCustom.checkNotContainCustom(userInput);
    }

    public List<String> createSplitUserInput(String userInput) {
        if (checkContainCustom(userInput)) {
            return CalculateCustom.splitWithCustomSeparator(userInput);
        }
        return CalculateDefault.splitWithDefaultSeparator(userInput);
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }
}
