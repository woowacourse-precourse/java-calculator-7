package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "11,2,45", "11:22:33"})
    void 기본_구분자를_기준으로_분리한다(String input) {
        //given
        DelimiterParser parser = new DelimiterParser();

        //when
        String[] result = parser.parseFromInput(input);

        //then
        Assertions.assertThat(result.length).isEqualTo(3);
    }
}
