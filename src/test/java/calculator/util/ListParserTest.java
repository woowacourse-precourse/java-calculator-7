package calculator.util;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListParserTest {

    @Test
    @DisplayName("문자열 리스트를 숫자 리스트로 변환 - 변환 성공한 경우")
    void parseStringsToLongs() {
        //given
        List<String> strings = Arrays.asList("1", "2", "3");
        List<Long> expected = Arrays.asList(1L, 2L, 3L);

        //when
        List<Long> actual = ListParser.parseStringsToLongs(strings);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("문자열 리스트를 숫자 리스트로 변환 - 빈 문자열이 있어 실패한 경우")
    void parseStringsToLongsWithEmptyString() {
        //given
        List<String> strings = Arrays.asList("1", "2", " ");

        //when
        //then
        Assertions.assertThatThrownBy(() -> ListParser.parseStringsToLongs(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열 리스트를 숫자 리스트로 변환 - 문자가 있어 실패한 경우")
    void parseStringsToLongsWithNotNumber() {
        //given
        List<String> strings = Arrays.asList("1", "2", "a");

        //when
        //then
        Assertions.assertThatThrownBy(() -> ListParser.parseStringsToLongs(strings))
                .isInstanceOf(IllegalArgumentException.class);
    }
}