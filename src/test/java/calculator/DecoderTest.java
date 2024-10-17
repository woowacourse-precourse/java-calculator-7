package calculator;

import calculator.domain.Decoder;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DecoderTest {

    // 올바른 문자열
    @ValueSource(strings = {"1,2:3", "//;\\n1;2;3", "//:\\n1:2:3", "//.\\n1.2.3", "1:2:3", "1:2,3", "//?\\n?1?2?3",
            "///\\n1/2/3"})
    @ParameterizedTest
    void ableToDecode(String input) {
        Decoder decoder = new Decoder(input);
        Assertions.assertThat(decoder.getDecodedNumbers())
                .isEqualTo(List.of(1, 2, 3));
    }

    // 올바르지 않은 문자열
    @ValueSource(strings = {"1;2;3", "//\\n123", "//;\\n;-1;2;3", "//;1;2;3", "//1\\n11213", "// \\n1 2 3",
            "//?\\n?1?2!3", "//?\\n0.1?0.2?0.34"})
    @ParameterizedTest
    void disableToDecode(String input) {
        Assertions.assertThatThrownBy(() -> new Decoder(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 빈 문자열 입력 시 빈 리스트 반환
    @ValueSource(strings = {"//;\\n", ""})
    @ParameterizedTest
    void emptyDecodedNumbers(String input) {
        Decoder decoder = new Decoder(input);
        Assertions.assertThat(decoder.getDecodedNumbers())
                .isEqualTo(List.of());
    }
}
