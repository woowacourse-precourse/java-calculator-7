package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParserTest {

    @DisplayName("일반 구분자를 사용하여 문자열을 변환")
    @Test
    public void splitInputTest() {
        //given
        String input = "1,2,3,4";

        //when
        String[] numbers = StringParser.splitCustomInput(input);

        //then
        Assertions.assertThat(numbers).isEqualTo(new String[]{"1", "2", "3", "4"});
    }

    @DisplayName("커스텀 구분자를 사용하여 문자열을 변환")
    @Test
    public void splitCustomInputTest() {
        //given
        String input = "//#\n1#2#4";

        //when
        String[] numbers = StringParser.splitCustomInput(input);

        //then
        Assertions.assertThat(numbers).isEqualTo(new String[]{"1", "2", "4"});
    }

}