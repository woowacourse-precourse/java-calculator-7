package calculator.domain;

import calculator.domain.vo.CustomValues;
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
        CustomValues basicExpectValue = new CustomValues("[,;]");

        // when
        CustomValues result = stringCalculator.extractCustomValue(value);
        CustomValues basicResult = stringCalculator.extractCustomValue(basicValue);

        CustomValues expect = new CustomValues(";");
        CustomValues incorrectExpect = new CustomValues(",");

        // then
        Assertions.assertAll(
                () -> Assertions.assertEquals(expect.value(), result.value()),
                () -> Assertions.assertEquals(basicExpectValue.value(), basicResult.value()),
                () -> Assertions.assertNotEquals(incorrectExpect.value(), result.value())
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
        Assertions.assertEquals(expect, result);
    }

    @Test
    void 배열_테스트() {

        // given
        StringCalculator stringCalculator = new StringCalculator();
        String value = "1;2;3";
        String basicValue = "1,2;3";
        CustomValues customValue = new CustomValues(";");
        CustomValues basicCustomValue = new CustomValues("[,;]");

        // when
        String[] result = stringCalculator.createNewValue(value, customValue.value());
        String[] basicResult = stringCalculator.createNewValue(basicValue, basicCustomValue.value());
        String[] expect = {"1", "2", "3"};

        // then
        Assertions.assertAll(
                () -> Assertions.assertArrayEquals(expect, result),
                () -> Assertions.assertArrayEquals(expect, basicResult)
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
        Assertions.assertEquals(expect, result);
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
                () -> Assertions.assertEquals(expect, result),
                () -> Assertions.assertNotEquals(incorrectExpect, result)
        );
    }
}
