package calculator.domain;

import java.util.Arrays;
import java.util.List;
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

    @DisplayName("문자열 리스트의 각 문자열을 정수형으로 변환하여 리스트로 반환")
    @Test
    public void convertIntListTest() {
        //given
        String[] numbers = {"1", "2", "3", "4"};

        //when
        List<Integer> convertNumbers = StringParser.convertIntList(numbers);

        //then
        Assertions.assertThat(convertNumbers).isEqualTo(Arrays.asList(1, 2, 3, 4));
    }

}