package calculator.service;

import calculator.service.parse.BigIntegerCalculatorInputParseService;
import calculator.service.parse.PositiveBigIntegerCalculatorInputParseService;
import java.math.BigInteger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BigIntegerCalculatorServiceTest {

    private final BigIntegerCalculatorService bigIntegerCalculatorService;

    public BigIntegerCalculatorServiceTest() {
        BigIntegerCalculatorInputParseService bigIntegerCalculatorInputParseService
                = new PositiveBigIntegerCalculatorInputParseService();
        this.bigIntegerCalculatorService = new BigIntegerCalculatorService(bigIntegerCalculatorInputParseService);
    }


    @Test
    @DisplayName("sum은 기본 동작에 대해 정상 작동한다.")
    public void sum_WorksCorrectly() {
        // given
        String input = "1,2,3";
        BigInteger expectedResult = BigInteger.valueOf(6);

        // when
        BigInteger result = bigIntegerCalculatorService.sum(input);

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
        BigInteger result = bigIntegerCalculatorService.sum(input);

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
        BigInteger result = bigIntegerCalculatorService.sum(input);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
}
