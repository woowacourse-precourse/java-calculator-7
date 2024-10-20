package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class DefaultDelimiterTest {

    @ValueSource(strings = {"", "1", "1,", ":1", "1,2:3", ",|"})
    @ParameterizedTest(name = "\"{0}\"은 기본 구분자")
    @DisplayName("기본 구분자 일치: 빈 문자열, 숫자만 존재, 쉼표(,) 또는 콜론(:)을 사용해 구분")
    void 기본_구분자_일치(String input) {
        Delimiter delimiter = new DefaultDelimiter(input);

        assertThat(delimiter.matches()).isTrue();
    }

    @ValueSource(strings = {"1.", "!1", "1,2:3;4", ",|;"})
    @ParameterizedTest(name = "\"{0}\"은 기본 구분자가 아님")
    @DisplayName("기본 구분자 불일치: 쉼표(,) 또는 콜론(:)외 포함")
    void 기본_구분자_불일치(String input) {
        Delimiter delimiter = new DefaultDelimiter(input);

        assertThat(delimiter.matches()).isFalse();
    }

    @MethodSource(value = "provideDefaultInputAndNumbers")
    @ParameterizedTest(name = "{0}의 분리 결과는 {1}")
    @DisplayName("기본 구분자 입력 분리")
    void 기본_구분자_분리(String input, List<String> expectedNumbers) {
        Delimiter delimiter = new DefaultDelimiter(input);

        assertThat(delimiter.split()).isEqualTo(expectedNumbers);
    }

    static Stream<Arguments> provideDefaultInputAndNumbers() {
        return Stream.of(
                Arguments.of("", List.of("")),
                Arguments.of("1", List.of("1")),
                Arguments.of("1,2", List.of("1", "2")),
                Arguments.of("1,2:3", List.of("1", "2", "3")),
                Arguments.of(",2:3", List.of("", "2", "3")),
                Arguments.of(",2:", List.of("", "2")),
                Arguments.of(",:", Collections.emptyList())
        );
    }

}
