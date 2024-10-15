package calculator.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {


    @Test
    void 커스텀_구분자_추출_테스트() {

        // given
        StringCalculator stringCalculator = new StringCalculator();
        String value = "//;\\n1;2;3";

        // when
        String result = stringCalculator.extractCustom(value);
        String expect = ";";
        String incorrectExpect = ",";

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(result, expect),
                () -> Assertions.assertNotEquals(incorrectExpect, result)
        );

    }
}
