package calculator.utils;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListConverterUtilTest {

    @Test
    public void 문자열_리스트를_정수_리스트로_변환() throws Exception {
        //given
        List<String> strings = Arrays.asList("3", "2", "1");

        //when
        List<Integer> integers = ListConverterUtil.convertToPositiveIntegers(strings);

        //then
        assertThat(integers).isEqualTo(Arrays.asList(3, 2, 1));
    }
}