package calculator.extractor;

import calculator.domain.Number;
import calculator.domain.Numbers;
import calculator.dto.SeparatorsResult;

public class NumbersExtractor {
    public void extractNumbers(SeparatorsResult separatorsResult) {
        StringBuilder currentNumber = new StringBuilder();
        Numbers numbers = new Numbers();

        for (char tmp : separatorsResult.input().toCharArray()) {
            if (separatorsResult.separators().contains(tmp)) {
                addNumber(currentNumber, numbers);
                continue;
            }
            currentNumber.append(tmp);
        }

        // 마지막 남은 숫자를 추가
        addNumber(currentNumber, numbers);
    }

    private void addNumber(StringBuilder currentNumber, Numbers numbers) {
        if (currentNumber.isEmpty()) {
            return;
        }
        Number number = Number.createByString(currentNumber.toString());
        numbers.add(number);
        currentNumber.setLength(0);  // StringBuilder 초기화
    }
}
