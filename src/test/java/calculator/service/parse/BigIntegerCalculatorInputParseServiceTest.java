package calculator.service.parse;

import calculator.service.parse.BigIntegerCalculatorInputParseService;
import java.math.BigInteger;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BigIntegerCalculatorInputParseServiceTest {

    private final BigIntegerCalculatorInputParseService bigIntegerCalculatorInputParseService;

    public BigIntegerCalculatorInputParseServiceTest() {
        this.bigIntegerCalculatorInputParseService = new BigIntegerCalculatorInputParseService();
    }

    @Test
    @DisplayName("parseSumInput은 기본 구분자를 이용한 입력에 정상 작동한다.")
    public void parseSumInput_WithDefaultDelimiter_WorksCorrectly() {
        // given
        String input1 = "1,2";
        String input2 = "1,2,3";
        String input3 = "1,2:3";

        List<BigInteger> expectedResult1 = List.of(
                BigInteger.valueOf(1),
                BigInteger.valueOf(2)
        );
        List<BigInteger> expectedResult2 = List.of(
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(3)
        );
        List<BigInteger> expectedResult3 = List.of(
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(3)
        );

        // when
        List<BigInteger> result1 = bigIntegerCalculatorInputParseService.parseSumInput(input1);
        List<BigInteger> result2 = bigIntegerCalculatorInputParseService.parseSumInput(input2);
        List<BigInteger> result3 = bigIntegerCalculatorInputParseService.parseSumInput(input3);

        // then
        Assertions.assertThat(result1).isEqualTo(expectedResult1);
        Assertions.assertThat(result2).isEqualTo(expectedResult2);
        Assertions.assertThat(result3).isEqualTo(expectedResult3);
    }

    @Test
    @DisplayName("parseSumInput은 커스텀 구분자를 이용한 입력에 정상 작동한다.")
    public void parseSumInput_WithCustomDelimiter_WorksCorrectly() {
        // given
        String input = "//;\\n1;2;3";

        List<BigInteger> expectedResult = List.of(
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(3)
        );

        // when
        List<BigInteger> result = bigIntegerCalculatorInputParseService.parseSumInput(input);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("parseSumInput은 정규 표현식이 포함된 커스텀 구분자를 이용한 입력에 정상 작동한다.")
    public void parseSumInput_WithRegexCharacterCustomDelimiter_WorksCorrectly() {
        // given
        String input = "//[\\n1[2[3";

        List<BigInteger> expectedResult = List.of(
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(3)
        );

        // when
        List<BigInteger> result = bigIntegerCalculatorInputParseService.parseSumInput(input);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("parseSumInput은 두개 이상의 커스텀 구분자를 이용한 입력에 정상 작동한다.")
    public void parseSumInput_WithMultipleCustomDelimiter_WorksCorrectly() {
        // given
        String input = "//;.\\n1;2.3";

        List<BigInteger> expectedResult = List.of(
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(3)
        );

        // when
        List<BigInteger> result = bigIntegerCalculatorInputParseService.parseSumInput(input);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("parseSumInput은 커스텀 구분자를 이용한 입력에 기본 구분자에 대해서도 정상 작동한다.")
    public void parseSumInput_WithCustomDelimiterAndDefaultDelimiter_WorksCorrectly() {
        // given
        String input = "//;\\n1;2,3";

        List<BigInteger> expectedResult = List.of(
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(3)
        );

        // when
        List<BigInteger> result = bigIntegerCalculatorInputParseService.parseSumInput(input);

        // then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("parseSumInput은 잘못된 입력에 대해 IllegalArgumentException을 던진다.")
    public void parseSumInput_WithInvalidInput_ThrowsIllegalArgumentException() {
        // given
        String input = "1A,2,3";

        // when & then
        Assertions.assertThatThrownBy(() ->
                bigIntegerCalculatorInputParseService.parseSumInput(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("parseSumInput은 잘못된 구분자 위치에 대해 IllegalArgumentException을 던진다.")
    public void parseSumInput_WithInvalidCustomDelimiterPosition_ThrowsIllegalArgumentException() {
        // given
        String input = "1;2;3//;\\n";

        // when & then
        Assertions.assertThatThrownBy(() ->
                bigIntegerCalculatorInputParseService.parseSumInput(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}