package calculator.domain.vo.delimiter;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Delimiters 테스트")
class DelimitersTest {

    @Test
    void 기본_Delimiters가_정상적으로_생성() {
        // given
        String input = "1,2,3";

        // when
        Delimiters delimiters = Delimiters.from(input);

        // then
        assertThat(delimiters.getDelimiterRegex()).isEqualTo(",|:");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//#\n1#2#3", "//*\n1*2*3"})
    void Custom_Delimiter가_정상적으로_파싱(String input) {

        // given & when
        Delimiters delimiters = Delimiters.from(input);

        // then
        assertThat(delimiters.getDelimiterRegex()).containsAnyOf(";", "#", "*");
    }
}