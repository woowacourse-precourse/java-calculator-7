package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StringPreprocessorTest {

    @DisplayName("사용자 입력에서 커스텀구분자를 표시하는 문자열을 제외하고 반환한다.")
    @Test
    void stringPreprocessorTest() {
        StringPreprocessor stringPreprocessor = new StringPreprocessor();

        // given
        String input = "//;\\n1;2,3:4";

        // when
        String numbersPart = stringPreprocessor.removeDelimiterPart(input);

        // then
        assertThat(numbersPart).isEqualTo("1;2,3:4");
    }

    @DisplayName("사용자 입력에서 기본구분자를 표시하는 문자열을 제외하고 반환한다.")
    @Test
    void stringPreprocessorTest2() {
        StringPreprocessor stringPreprocessor = new StringPreprocessor();

        // given
        String input = "//;\\n1;2;3";

        // when
        String numbersPart = stringPreprocessor.removeDelimiterPart(input);

        // then
        assertThat(numbersPart).isEqualTo("1;2;3");
    }
}