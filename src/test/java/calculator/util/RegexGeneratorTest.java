package calculator.util;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegexGeneratorTest {

    @Test
    @DisplayName("주어진 문자열을 포함하여 정규식을 생성 - 생성 성공한 경우")
    void generateRegex() {
        //given
        String regex = ",;";
        String expected = "[,;]";

        //when
        String actual = RegexGenerator.generateRegex(regex);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}