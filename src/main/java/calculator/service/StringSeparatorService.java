package calculator.service;

import calculator.InputStringProcessor;
import java.util.Set;

public class StringSeparatorService {

    private final InputStringProcessor inputStringProcessor;

    public StringSeparatorService() {
        inputStringProcessor = new InputStringProcessor();
    }

    public String removeSeparator(String inputStr) {
        // 1. 구분자가 있는지 확인한다.
        boolean hasCustomSeparator = inputStringProcessor.checkIfInputStringContainsSeparator(inputStr);
        // 2. 구분자 리스트를 만든다.
        Set<Character> separatorList = inputStringProcessor.getSeparatorList(hasCustomSeparator, inputStr);
        // 3. 커스텀 구분자가 있는 경우, 앞의 5글자를 제거한다.
        String strRemovedSeparatorForm = inputStringProcessor.removeSeparatorForm(hasCustomSeparator, inputStr);
        // 4. 남은 문자열에서 커스텀 구분자를 모두 제거하여 반환한다.
        return "";
    }
}
