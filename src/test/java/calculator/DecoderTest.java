package calculator;

import calculator.domain.Decoder;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DecoderTest {

    // 올바른 형식 입력 시 숫자 구분 테스트
    @ValueSource(strings = {"1,2:3", "1:2:3", "1:2,3", "//;\\n1;2;3", "//-\\n1-2-3", "//.\\n1.2.3", "//?\\n1?2?3",
            "///\\n1/2/3"})
    @ParameterizedTest
    void extractNumbersTest(String input) {
        Assertions.assertThat(new Decoder(input).getDecodedNumbers())
                .isEqualTo(List.of(1, 2, 3));
    }

    // 입력 내 음수가 있다면 에러를 발생
    @ValueSource(strings = {"-1,-2:-3", "-1,2,3", "//;\\n4;-5;7"})
    @ParameterizedTest
    void negativeNumberTest(String input) {
        Assertions.assertThatThrownBy(() -> new Decoder(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 입력 내 소수가 있다면 에러를 발생
    @ValueSource(strings = {"0.1,0.25:0.5", "//;\\n-0.1;0.2;0.3", "0.3,0.7,0.9"})
    @ParameterizedTest
    void decimalNumberTest(String input) {
        Assertions.assertThatThrownBy(() -> new Decoder(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 커스텀 구분자가 빈칸이면 에러를 발생
    @ValueSource(strings = {"// \\n1 2 3", "//   \\n1   2   3"})
    @ParameterizedTest
    void blankDelimiterTest(String input) {
        Assertions.assertThatThrownBy(() -> new Decoder(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 빈 문자열 테스트
    @ValueSource(strings = {"//;\\n", ""})
    @ParameterizedTest
    void blankInputTest(String input) {
        Assertions.assertThat(new Decoder(input).getDecodedNumbers().isEmpty())
                .isEqualTo(true);
    }
}
