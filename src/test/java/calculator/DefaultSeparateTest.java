package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DefaultSeparateTest {

    @ParameterizedTest
    @ValueSource(chars = {',', ':'})
    void 기본_구분자_리스트를_반환한다(char separate) {
        //given & when
        List<Character> separates = DefaultSeparate.getSeparates();

        //then
        assertThat(separates).contains(separate);
    }

}
