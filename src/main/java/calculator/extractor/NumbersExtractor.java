package calculator.extractor;

import calculator.dto.SeparatorsResult;
import java.math.BigDecimal;

public class NumbersExtractor {
    public void extractNumbers(SeparatorsResult separatorsResult) {
        StringBuilder currentNumber = new StringBuilder();

        for (char tmp : separatorsResult.input().toCharArray()) {
            if (separatorsResult.separators().contains(tmp)) {
                BigDecimal bigDecimal = new BigDecimal(currentNumber.toString());
            }
        }
    }

}
