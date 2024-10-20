package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("DigitParser 는")
class DigitParserTest {

    DigitParser dp = new DigitParser();

    @ParameterizedTest
    @DisplayName("기본 구분자(',', ':')를 적용할 수 있다")
    @ValueSource(strings = {
        "1,2:3",
        "1,2,3",
        "1:2:3,:",
        ",,:2,:3,1"
    })
    void should_ParseWithBasicDelimiter(String input) {
        List<Integer> result = dp.parse(input);

        assertThat(result).containsOnly(1, 2, 3);
    }

    @ParameterizedTest(name = "{0} 은 올바른 커스텀 구분자로 파싱된다")
    @DisplayName("커스텀 구분자를 적용할 수 있다")
    @ValueSource(strings = {
        "//;\\n1;2;3",
        "//efi\\n1efi2efi3efiefi",
        "//||\\n1||2||3"
    })
    void should_ParseWithCustomDelimiter(String input) {
        List<Integer> result = dp.parse(input);

        assertThat(result).containsOnly(1, 2, 3);
    }

    @ParameterizedTest(name = "{0} 은 잘못된 입력에 대해 예외가 발생한다.")
    @DisplayName("잘못된 입력에 대해 예외가 발생한다.")
    @ValueSource(strings = {
        "[1[2[3",
        "//!!\1!!2!!3",
        "1,2,3:[",
        "-1,2,3",
        ".1,2,3"
    })
    void should_ThrowIllegalArgumentException_WhenParseWithBasicDelimiter(String input) {
        assertThatThrownBy(() -> dp.parse(input))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

}
