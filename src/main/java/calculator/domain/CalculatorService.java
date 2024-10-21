package calculator.domain;

import calculator.infrastructure.InputParser;
import calculator.infrastructure.NumberValidator;
import calculator.infrastructure.SumCalculator;
import java.util.List;
import java.util.Set;

public class CalculatorService {

    private final InputParser inputParser;
    private final NumberValidator numberValidator;
    private final SumCalculator sumCalculator;

    public CalculatorService(InputParser inputParser, NumberValidator numberValidator,
                             SumCalculator sumCalculator) {
        this.inputParser = inputParser;
        this.numberValidator = numberValidator;
        this.sumCalculator = sumCalculator;
    }

    public void validateUserInput(String inputStr) {
        inputParser.validateInputStr(inputStr);
    }

    /*
     * 1. 구분자가 있는지 확인한다.
     * 2. 구분자 리스트를 만든다.
     * 3. 커스텀 구분자가 있는 경우, 앞의 5글자를 제거한다.
     * 4. 남은 문자열을 커스텀 구분자를 기준으로 자르고, 리스트로 반환한다.
     */
    public String[] splitStrBySeparators(String inputStr) {
        boolean hasCustomSeparator = inputParser.checkIfInputStringContainsSeparator(inputStr);
        Set<Character> separators = inputParser.getSeparatorList(hasCustomSeparator, inputStr);
        String strRemovedSeparatorForm = inputParser.removeSeparatorForm(hasCustomSeparator, inputStr);
        return inputParser.splitStrBySeparator(separators, strRemovedSeparatorForm);
    }

    public List<Number> makeNumberList(String[] splitStrBySeparators) {
        // 리스트의 각 요소를 검증하고,  Long 타입으로 변환하여 반환한다.
        return numberValidator.makeNumberList(splitStrBySeparators);
    }

    public long sum(List<Number> numberList) {
        return sumCalculator.addAllNumbers(numberList);
    }
}
