package calculator;

import java.math.BigDecimal;
import java.util.List;

public class NumberService {

    public List<BigDecimal> processNumbers(List<String> numberStrings) {
        return numberStrings.stream()
                .map(this::convertToBigDecimal)
                .toList();
    }

    private BigDecimal convertToBigDecimal(String numString) {
        if (numString.isEmpty()) {
            return BigDecimal.ZERO; // 빈 문자열일 경우 0 반환
        }

        validateNumberString(numString);

        BigDecimal number = new BigDecimal(numString);

        if (number.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("음수나 0은 허용되지 않습니다.");
        }

        return number;
    }

    private void validateNumberString(String numString) {
        if (numString.isEmpty()) {
            return;
        }

        if (numString.length() > 1 && numString.charAt(0) == '0' && numString.charAt(1) != '.') {
            throw new IllegalArgumentException("숫자에 불필요한 0을 포함하지 않습니다.");
        }

        try {
            new BigDecimal(numString); // BigDecimal로 변환해보고 유효성 검사
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
        }
    }

    public BigDecimal calculateSum(List<BigDecimal> numbers) {
        return numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}