package calculator.extractor;

import calculator.domain.Number;
import calculator.dto.SeparatorsResult;

public class NumbersExtractor {
    public void extractNumbers(SeparatorsResult separatorsResult) {
        StringBuilder currentNumber = new StringBuilder();

        for (char tmp : separatorsResult.input().toCharArray()) {
            if (separatorsResult.separators().contains(tmp)) {
                Number number = Number.createByString(currentNumber.toString());
            }
        }
    }
}
