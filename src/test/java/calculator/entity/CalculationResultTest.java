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

}
