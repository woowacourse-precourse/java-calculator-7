package calculator.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationResultTest {

    @Test
    void getResult_테스트() {
        int expectedResult = 10;
        CalculationResult calculationResult = new CalculationResult(expectedResult);

        int result = calculationResult.getResult();

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void toString_테스트() {
        int result = 6;
        CalculationResult calculationResult = new CalculationResult(result);

        String resultString = calculationResult.toString();

        assertThat(resultString).isEqualTo("결과 : 6");
    }
}
