package calculator.controller;

import static calculator.constant.ErrorType.INVALID_INPUT_FORMAT;
import static calculator.constant.ErrorType.OUT_OF_RANGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorControllerTest extends NsTest {

    @Test
    @DisplayName("사용자가 입력한 문자열 숫자의 합을 성공적으로 출력한다.")
    void successTest() throws Exception {
        //given
        final String RESULT = "결과 : %d";
        final String inputString1 = "10:3:10";
        final String inputString2 = "//;\\n1;2:3,4";
        final String inputString3 = "///\\n6/7:8,9";
        final String inputString4 = "//.\\n.";
        final String inputString5 = "// \\n10 20 30 40";
        final String inputString6 = "//;a.\\\\n50;a.\\60;a.\\70";
        final BigInteger result1 = BigInteger.valueOf(23);
        final BigInteger result2 = BigInteger.valueOf(10);
        final BigInteger result3 = BigInteger.valueOf(30);
        final BigInteger result4 = BigInteger.ZERO;
        final BigInteger result5 = BigInteger.valueOf(100);
        final BigInteger result6 = BigInteger.valueOf(180);
        //when
        //then
        assertAll(
                () -> assertSimpleTest(() -> {
                    run(inputString1);
                    assertThat(output()).contains(String.format(RESULT, result1));
                }),
                () -> assertSimpleTest(() -> {
                    run(inputString2);
                    assertThat(output()).contains(String.format(RESULT, result2));
                }),
                () -> assertSimpleTest(() -> {
                    run(inputString3);
                    assertThat(output()).contains(String.format(RESULT, result3));
                }),
                () -> assertSimpleTest(() -> {
                    run(inputString4);
                    assertThat(output()).contains(String.format(RESULT, result4));
                }),
                () -> assertSimpleTest(() -> {
                    run(inputString5);
                    assertThat(output()).contains(String.format(RESULT, result5));
                }),
                () -> assertSimpleTest(() -> {
                    run(inputString6);
                    assertThat(output()).contains(String.format(RESULT, result6));
                })
        );
    }


    @ParameterizedTest
    @DisplayName("사용자가 올바르지 않은 형식을 입력하여 예외가 발생한다.")
    @ValueSource(strings = {"///;\\n1;2;3", "1;2;3//;\\n", "1;2,3", "-1;2;3", "//;\\n1;2;//;\\n;3"})
    void invalidInputTest(final String inputString) throws Exception {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(inputString))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_INPUT_FORMAT.getMessage())
        );
    }

    @ParameterizedTest
    @DisplayName("사용자가 양의 정수 범위를 벗어난 값을 입력하여 예외가 발생한다.")
    @ValueSource(strings = {"9999999999999999,1,2", "1:2:9999999999999999", "1:0:3"})
    void outOfRangeTest(final String inputString) throws Exception {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(inputString))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(OUT_OF_RANGE.getMessage())
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}