package calculator.validator.strategies;

import calculator.util.DelimiterUtils;
import calculator.view.ErrorMessage;
import java.util.List;
import java.util.stream.Collectors;

// 음수를 검증하는 클래스
public class NegativeNumberValidator implements ValidationStrategy {

    @Override
    public void validate(String input) {
        List<String> numbers = parseNumbers(input);
        throwIfNegativeNumbersExist(numbers);  // 음수가 있으면 예외를 던짐
    }

    // 입력 문자열을 구분자로 나누어 숫자 리스트를 반환하는 메소드
    private List<String> parseNumbers(String input) {  // 간결하고 목적이 명확한 이름
        return List.of(DelimiterUtils.splitByDelimiter(input));
    }

    // 음수 리스트를 확인하고, 음수가 있으면 예외를 발생시키는 메소드
    private void throwIfNegativeNumbersExist(List<String> numbers) {
        List<String> negativeNumbers = findNegativeNumbers(numbers);
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NEGATIVE_NUMBER_ERROR.getMessage() + ": " + String.join(", ", negativeNumbers));
        }
    }

    // 숫자 리스트에서 음수를 찾아 리스트로 반환
    private List<String> findNegativeNumbers(List<String> numbers) {
        return numbers.stream()
                .filter(this::isNegative)
                .collect(Collectors.toList());
    }

    // 주어진 문자열이 음수인지 확인
    private boolean isNegative(String number) {
        try {
            return Integer.parseInt(number) < 0;  // 문자열을 정수로 변환하여 음수 여부 확인
        } catch (NumberFormatException e) {
            return false;  // 숫자가 아닌 경우
        }
    }
}