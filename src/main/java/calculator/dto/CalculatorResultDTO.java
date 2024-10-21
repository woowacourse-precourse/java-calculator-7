package calculator.dto;

import java.math.BigDecimal;

public class CalculatorResultDTO<T extends Number> {

    private final T result;

    public CalculatorResultDTO(T result) {
        this.result = result;
    }

    public String getTotal() {
        BigDecimal[] intAndDecimals = new BigDecimal(result.toString()).divideAndRemainder(BigDecimal.ONE);
        BigDecimal integer = intAndDecimals[0];     // 정수부
        BigDecimal decimals = intAndDecimals[1];    // 소수부

        // 계산 결과가 정수인지 확인
        if (decimals.equals(BigDecimal.ZERO)) {
            return integer.toBigInteger().toString();
        }
        return result.toString();
    }
}
