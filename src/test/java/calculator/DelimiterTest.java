package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DelimiterTest {

    @Test
    void 커스텀_구분자를_지정한다() {
        // given
        String input = "//;\n1;2;3";
        
        // when
        Delimiter delimiter = Delimiter.createCustomDelimiter(input);
        
        // then
        assertThat(delimiter).isEqualTo(new Delimiter(";"));
    }
}
