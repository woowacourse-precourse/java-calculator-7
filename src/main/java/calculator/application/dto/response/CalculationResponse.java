package calculator.application.dto.response;

import java.math.BigInteger;

public record CalculationResponse(BigInteger result) implements Response{

    public CalculationResponse {
        if (result == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.format("결과 : %s", result);
    }
}
