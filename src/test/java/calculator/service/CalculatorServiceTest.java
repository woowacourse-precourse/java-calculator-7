package calculator.service;

import java.math.BigInteger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    private final CalculatorService calculatorService;

    public CalculatorServiceTest() {
        CalculatorInputParseService calculatorInputParseService = new CalculatorInputParseService();
        this.calculatorService = new CalculatorService(calculatorInputParseService);
    }


    @Test
    @DisplayName("sum은 기본 동작에 대해 정상 작동한다.")
    public void sum_WorksCorrectly() {
        // given
        String input = "1,2,3";
        BigInteger expectedResult = BigInteger.valueOf(6);

        // when
        BigInteger result = calculatorService.sum(input);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("sum은 int type의 overflow를 넘어서는 값에 대해서도 정상 작동한다.")
    public void sum_WithIntOverflow_WorksCorrectly() {
        // given
        String input = Integer.MAX_VALUE + "," + 1;
        BigInteger expectedResult = BigInteger.valueOf(Integer.MAX_VALUE).add(BigInteger.ONE);

        // when
        BigInteger result = calculatorService.sum(input);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("sum은 long type의 overflow를 넘어서는 값에 대해서도 정상 작동한다.")
    public void sum_WithLongOverflow_WorksCorrectly() {
        // given
        String input = Long.MAX_VALUE + "," + 1;
        BigInteger expectedResult = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);

        // when
        BigInteger result = calculatorService.sum(input);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
}
