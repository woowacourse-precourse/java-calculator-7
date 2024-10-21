package calculator.utils;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.enums.CustomExceptionMessage;
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


    @Test
    public void 정수가_아닌_문자열_리스트를_정수_리스트로_변환() throws Exception {
        //given
        List<String> strings = Arrays.asList("3", "b", "c");

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ListConverterUtil.convertToPositiveIntegers(strings);
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(
                CustomExceptionMessage.FIND_NOT_INTEGER.getMessage()
        );
    }


    @Test
    public void 양의_정수가_아닌_문자열_리스트를_정수_리스트로_변환() throws Exception {
        //given
        List<String> strings = Arrays.asList("3", "-2", "1");

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ListConverterUtil.convertToPositiveIntegers(strings);
        });

        //then
        assertThat(exception.getMessage()).isEqualTo(
                CustomExceptionMessage.FIND_NEGATIVE_INTEGER.getMessage()
        );
    }
}