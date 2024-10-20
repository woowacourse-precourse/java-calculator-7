package calculator.Util;

import calculator.util.NumberSeperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberSeperatorTest {
    @Test
    @DisplayName("숫자 리스트 파싱을 성공한다.")
    void parseNumbersFromDelimitedStringSuccess() {
        // given
        Set<String> separator = new HashSet<>(Set.of(",", ":"));
        String input = "1,2:3";

        // when
        List<Integer> result = NumberSeperator.parseNumbersFromDelimitedString(separator, input);

        // then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("리스트에 숫자 값이 비어있는 경우 IllegalArgumentException을 반환한다.")
    void parseNumbersFromDelimitedStringEmptyNumber(){
        //given
        Set<String> separator = new HashSet<>(Set.of(",", ":"));
        String input = "1,,3";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberSeperator.parseNumbersFromDelimitedString(separator, input));
        //then
        assertThat(exception.getMessage()).isEqualTo("숫자 값이 비어있습니다.");
    }


    @Test
    @DisplayName("리스트에 음수가 포함된 경우 IllegalArgumentException을 반환한다.")
    void parseNumbersFromDelimitedStringNegativeNumber(){
        //given
        Set<String> separator = new HashSet<>(Set.of(",", ":"));
        String input = "1,-2,3";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberSeperator.parseNumbersFromDelimitedString(separator, input));
        //then
        assertThat(exception.getMessage()).isEqualTo("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("리스트에 숫자가 아닌 값이 포함된 경우 IllegalArgumentException을 반환한다.")
    void parseNumbersFromDelimitedStringNotNumber(){
        //given
        Set<String> separator = new HashSet<>(Set.of(",", ":"));
        String input = "1,f,3";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberSeperator.parseNumbersFromDelimitedString(separator, input));
        //then
        assertThat(exception.getMessage()).isEqualTo("숫자가 아닌 값이 포함 되어 있습니다.");
    }
}
