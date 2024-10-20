package calculator.domain;

import calculator.infrastructure.InputStringProcessor;
import calculator.infrastructure.SplitStrListValidator;
import java.util.List;
import java.util.Set;

public class StringSeparatorService {

    private final InputStringProcessor inputStringProcessor;
    private final SplitStrListValidator splitStrListValidator;

    public StringSeparatorService() {
        inputStringProcessor = new InputStringProcessor();
        splitStrListValidator = new SplitStrListValidator();
    }

    public List<String> splitStrBySeparators(String inputStr) {
        // 1. 구분자가 있는지 확인한다.
        boolean hasCustomSeparator = inputStringProcessor.checkIfInputStringContainsSeparator(inputStr);
        // 2. 구분자 리스트를 만든다.
        Set<Character> separators = inputStringProcessor.getSeparatorList(hasCustomSeparator, inputStr);
        // 3. 커스텀 구분자가 있는 경우, 앞의 5글자를 제거한다.
        String strRemovedSeparatorForm = inputStringProcessor.removeSeparatorForm(hasCustomSeparator, inputStr);
        // 4. 남은 문자열을 커스텀 구분자를 기준으로 자르고, 리스트로 반환한다.
        return inputStringProcessor.splitStrBySeparator(separators, strRemovedSeparatorForm);
    }

    public List<Long> makeNumberList(List<String> splitStrBySeparators) {
        // 리스트의 각 요소를 검증하고,  Long 타입으로 변환하여 반환한다.
        return splitStrListValidator.makeNumberList(splitStrBySeparators);
    }
}
