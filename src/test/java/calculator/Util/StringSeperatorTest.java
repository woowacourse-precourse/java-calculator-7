package calculator.Util;

import calculator.util.StringSeperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringSeperatorTest {
    @Test
    @DisplayName("커스텀 구분자가 없는 경우")
    void noCustomSeparator() {
        // given
        String input = "1,2,3";

        // when
        String result = StringSeperator.parseCustomSeperator(input);

        // then
        assertThat(result).isEqualTo(input);
    }

    @Test
    @DisplayName("커스텀 구분자가 1개이며, 길이가 1인 경우")
    void oneCustomSeparator() {
        // given
        String customSeparator = "//;\n";
        String expression = "1;2,3";

        // when
        String result = StringSeperator.parseCustomSeperator(customSeparator+ expression);

        // then
        assertThat(result).isEqualTo(expression);
    }

    @Test
    @DisplayName("커스텀 구분자가 2개이며, 길이가 1인 경우")
    void  twoCustomSeparator() {
        // given
        String customSeperator = "//;\n//g\n";
        String expression = "1;2g3,4";

        // when
        String result = StringSeperator.parseCustomSeperator(customSeperator+ expression);

        // then
        assertThat(result).isEqualTo(expression);
    }

    @Test
    @DisplayName("커스텀 구분자가 1개 이며, 길이가 2이상인 경우")
    void twoLengthCustomSeparator() {
        // given
        String customSeperator = "//fg\n";
        String expression = "1fg2,5";

        //when
        String result = StringSeperator.parseCustomSeperator(customSeperator + expression);

        //then
        assertThat(result).isEqualTo(expression);
    }

    @Test
    @DisplayName("//로 시작하지만, \n이 없는 경우 IllegalArgumentException을 반환한다.")
    void noNewLine() {
        // given
        String customSeperator = "//;";
        String expression = "1;2,3";

        // when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> StringSeperator.parseCustomSeperator(customSeperator + expression));

        // then
        assertThat(exception.getMessage()).isEqualTo("커스텀 구분자가 잘못 입력되었습니다.");
    }

}
