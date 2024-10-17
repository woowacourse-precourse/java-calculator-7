package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputConverterTest {

    @Test
    @DisplayName("커스텀 구분자 없을 때 공백인 경우")
    void testIsBlankWithDefaultDelimiter(){
        String extractedInput = ",|: ";
        List<Integer> expectDelimiterAndInput = InputConverter.convert(extractedInput);

        assertThat(expectDelimiterAndInput).hasSize(0);
    }

    @Test
    @DisplayName("커스텀 구분자 있을 때 공백인 경우")
    void testIsBlankWithCustomDelimiter(){
        String extractedInput = ",|:|@ ";
        List<Integer> expectDelimiterAndInput = InputConverter.convert(extractedInput);

        assertThat(expectDelimiterAndInput).hasSize(0);
    }

    @Test
    @DisplayName("기본 구분자로 문자열 분리 후 숫자 리스트 리턴")
    void testConvertNumberWithDefaultDelimiter(){
        String extractedInput = ",|: 1,2:3,4:5";
        List<Integer> expectDelimiterAndInput = InputConverter.convert(extractedInput);

        assertThat(expectDelimiterAndInput).hasSize(5).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("커스텀 구분자 포함 문자열 분리 후 숫자 리스트 리턴")
    void testConvertNumberWithCustomDelimiter(){
        String extractedInput = ",|:|@ 1,2:3,4:5@6";
        List<Integer> expectDelimiterAndInput = InputConverter.convert(extractedInput);

        assertThat(expectDelimiterAndInput).hasSize(6).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("분리된 문자열에 기본 또는 커스텀 구분자가 아닌 문자가 있는 경우")
    void testIsContainOtherLetter(){
        String extractedInput = ",|:|# 1,2:3,4:5#6@7";

        assertThatThrownBy(() -> InputConverter.convert(extractedInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("분리된 문자열에 양수가 아닌 0 또는 음수가 있는 경우")
    void testIsContainNotPositiveNumber(){
        String extractedInput = ",|:|# 1,2:3,-1:5#6";

        assertThatThrownBy(() -> InputConverter.convert(extractedInput))
                .isInstanceOf(IllegalArgumentException.class);
    }



}