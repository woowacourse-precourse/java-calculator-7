package calculator.domain;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringCalculatorTest {

    @Test
    void 구분자_추출_테스트() {

        // given
        StringCalculator stringCalculator = new StringCalculator();
        String value = "//;\\n1;2;3";
        String basicValue = "1,2;3";
        String basicExpectValue = "[,;]";


        // when
        String result = stringCalculator.extractCustomValue(value);
        String basicResult = stringCalculator.extractCustomValue(basicValue);

        String expect = ";";
        String incorrectExpect = ",";

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(result, expect),
                () -> Assertions.assertEquals(basicResult, basicExpectValue),
                () -> Assertions.assertNotEquals(incorrectExpect, result)
        );

    }

    @Test
    void 커스텀_구분자_이후_문자열값_추출_테스트() {

        // given
        StringCalculator stringCalculator = new StringCalculator();
        String value = "//;\\n1;2;3";

        // when
        String result = stringCalculator.removeValue(value);
        String expect = "1;2;3";

        // then

        Assertions.assertEquals(result, expect);

    }

    @Test
    void 배열_테스트() {

        // given
        StringCalculator stringCalculator = new StringCalculator();
        String value = "1;2;3";
        String basicValue = "1,2;3";
        String customValue = ";";
        String basicCustomValue = "[,;]";

        // when
        String[] result = stringCalculator.createNewValue(value, customValue);
        String[] basicResult = stringCalculator.createNewValue(basicValue, basicCustomValue);
        String[] expect = {"1", "2", "3"};

        // then
        Assertions.assertAll(
                () -> Assertions.assertArrayEquals(basicResult, expect),
                () -> Assertions.assertArrayEquals(result, expect)
        );

    }

    @Test
    void 리스트_저장_테스트() {

        // given
        StringCalculator stringCalculator = new StringCalculator();
        String[] value = {"1", "2", "3"};

        // when
        List<Integer> result = stringCalculator.saveValue(value);
        List<Integer> expect = Arrays.asList(1, 2, 3);

        // then
        Assertions.assertEquals(result, expect);

    }

    @Test
    void 합산_테스트() {

        // given
        StringCalculator stringCalculator = new StringCalculator();
        List<Integer> value = Arrays.asList(1, 2, 3);

        // when
        int result = stringCalculator.calculateSum(value);
        int expect = 6;
        int incorrectExpect = 7;

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(result, expect),
                () -> Assertions.assertNotEquals(incorrectExpect, result)
        );
    }
}
