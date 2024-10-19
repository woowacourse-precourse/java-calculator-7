package calculator;

import java.math.BigDecimal;
import java.util.List;

public class NumberService {
    public List<BigDecimal> processNumbers(List<String> numberStrings) {
        return numberStrings.stream()
                .map(numString -> {
                    try {
                        if (numString.isEmpty()) {
                            throw new IllegalArgumentException("구분자 사이에 값이 없습니다.");
                        }

                        if (numString.charAt(0) == '0' && numString.charAt(1) != '.') {
                            throw new IllegalArgumentException("숫자에 불필요한 0을 포함하지 않습니다.");
                        }

                        BigDecimal number = new BigDecimal(numString);

                        if (number.compareTo(BigDecimal.ZERO) <= 0) {
                            throw new IllegalArgumentException("음수나 0은 허용되지 않습니다.");
                        }

                        return number;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
                    }
                })
                .toList();
    }

    public BigDecimal calculateSum(List<BigDecimal> numbers) {
        return numbers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}