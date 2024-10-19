package calculator;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultSeparatorTest {

    @ParameterizedTest
    @ValueSource(chars = {',', ':'})
    void 기본_구분자_리스트를_반환한다(char separator) {
        //given & when
        List<Character> separators = DefaultSeparator.getSeparators();

        //then
        assertThat(separators).contains(separator);
    }

}
