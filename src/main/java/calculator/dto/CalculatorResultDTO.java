package calculator.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CalculatorResultDTO<T extends Number> {

    private final T result;

    public CalculatorResultDTO(T result) {
        this.result = result;
    }

    public String getTotal() {
        BigDecimal totalValue = new BigDecimal(result.toString());
        BigDecimal integer = totalValue.divideAndRemainder(BigDecimal.ONE)[0];     // 정수부
        BigDecimal decimals = totalValue.divideAndRemainder(BigDecimal.ONE)[1];    // 소수부

        // 계산 결과가 정수인지 확인
        if (decimals.equals(BigDecimal.ZERO)) {
            return integer.toPlainString();
        }
        return totalValue.toPlainString();
    }
}
