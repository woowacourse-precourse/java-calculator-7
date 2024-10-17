package calculator.validator.strategies;

import calculator.util.DelimiterUtils;
import calculator.view.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

// 음수를 검증하는 클래스
public class NegativeNumberValidator implements ValidationStrategy {

    @Override
    public void validate(String input) {
        // 입력 문자열을 구분자로 나누고 음수 검증
        String[] numbers = splitInputIntoNumbers(input);
        checkForNegativeNumbers(numbers);
    }

    // 입력 문자열을 구분자로 나누어 숫자 배열을 반환하는 메소드
    private String[] splitInputIntoNumbers(String input) {
        return DelimiterUtils.splitInput(input);
    }

    // 음수 리스트를 확인하고, 음수가 있으면 예외를 발생시키는 메소드
    private void checkForNegativeNumbers(String[] numbers) {
        List<String> negativeNumbers = findNegativeNumbers(numbers);
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NEGATIVE_NUMBER_ERROR.getMessage() + ": " + String.join(", ", negativeNumbers));
        }
    }

    // 숫자 배열에서 음수를 찾아 리스트로 반환
    private List<String> findNegativeNumbers(String[] numbers) {
        List<String> negativeNumbers = new ArrayList<>();
        for (String number : numbers) {
            if (isNegative(number)) {
                negativeNumbers.add(number);
            }
        }
        return negativeNumbers;
    }

    // 주어진 문자열이 음수인지 확인
    private boolean isNegative(String number) {
        try {
            return Integer.parseInt(number) < 0; // 문자열을 정수로 변환하여 음수 여부 확인
        } catch (NumberFormatException e) {
            return false; // 숫자가 아닌 경우 예외 무시
        }
    }

}