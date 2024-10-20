package calculator;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringIntegerConverterTest {

    @DisplayName("문자열에서 정수로 변환")
    @Test
    void convertTest() {
        // given
        StringIntegerConverter converter = new StringIntegerConverter();
        List<String> strings = Arrays.asList("1", "2", "3");

        // when
        List<Integer> list = converter.convert(strings);

        // then
        Assertions.assertEquals(list, Arrays.asList(1, 2, 3));
    }

    @DisplayName("문자열에서 정수로 변환 실패 시")
    @Test
    void convertTest_failure() {
        StringIntegerConverter converter = new StringIntegerConverter();
        List<String> strings = Arrays.asList("1", "2", "3", ";");
        Assertions.assertThrows(IllegalArgumentException.class, () -> converter.convert(strings));
    }

}