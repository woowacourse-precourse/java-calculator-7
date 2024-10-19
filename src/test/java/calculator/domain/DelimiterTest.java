package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    private Delimiter delimiter;

    @BeforeEach
    void setUp() {
        delimiter = new Delimiter();
    }

    @ValueSource(strings = {"", "1", "1,", ":1", "1,2:3", ",|"})
    @ParameterizedTest(name = "\"{0}\"은 기본 구분자")
    @DisplayName("기본 구분자 일치: 빈 문자열, 숫자만 존재, 쉼표(,) 또는 콜론(:)을 사용해 구분")
    void 기본_구분자_일치(String input) {
        assertThat(delimiter.isDefault(input)).isTrue();
    }

    @ValueSource(strings = {"1.", "!1", "1,2:3;4", ",|;"})
    @ParameterizedTest(name = "\"{0}\"은 기본 구분자가 아님")
    @DisplayName("기본 구분자 불일치: 쉼표(,) 또는 콜론(:)외 포함")
    void 기본_구분자_불일치(String input) {
        assertThat(delimiter.isDefault(input)).isFalse();
    }

    @ValueSource(strings = {"//;\\n1;2;3", "// \\n1 2 3", "//;\\n1", "// \\n"})
    @ParameterizedTest(name = "\"{0}\"은 커스텀 구분자")
    @DisplayName("커스텀 구분자 일치: //와 \n 사이에 1개 이상의 문자가 존재")
    void 커스텀_구분자_일치(String input) {
        assertThat(delimiter.isCustom(input)).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자 불일치: 빈 문자열은 커스텀 구분자가 아님")
    void 커스텀_구분자_불일치() {
        assertThat(delimiter.isCustom("//\\n")).isFalse();
    }

    @MethodSource(value = "provideDefaultInputAndNumbers")
    @ParameterizedTest(name = "{0}의 분리 결과는 {1}")
    @DisplayName("기본 구분자 입력 분리")
    void 기본_구분자_분리(String input, List<String> expectedNumbers) {
        assertThat(delimiter.split(input)).isEqualTo(expectedNumbers);
    }

    @MethodSource(value = "provideCustomInputAndNumbers")
    @ParameterizedTest(name = "{0}의 분리 결과는 {1}")
    @DisplayName("커스텀 구분자 입력 분리")
    void 커스텀_구분자_분리(String input, List<String> expectedNumbers) {
        assertThat(delimiter.split(input)).isEqualTo(expectedNumbers);
    }

    @ValueSource(strings = {"1.", "!1", "1,2:3;4", ",|;", "//\n"})
    @ParameterizedTest(name = "{0}은 분리할 수 없습니다")
    @DisplayName("입력 분리 실패: 기본/커스텀 구분자에 속하지 않음")
    void 입력_분리_실패(String input) {
        assertThatThrownBy(() -> delimiter.split(input))
                .isInstanceOf(IllegalArgumentException.class);
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

    static Stream<Arguments> provideCustomInputAndNumbers() {
        return Stream.of(
                Arguments.of("//;\\n1", List.of("1")),
                Arguments.of("//;\\n1;2", List.of("1", "2")),
                Arguments.of("// \\n1 2 3", List.of("1", "2", "3")),
                Arguments.of("// \\n", Collections.emptyList()),
                Arguments.of("// \\n 1", List.of("", "1")),
                Arguments.of("// \\n 1  2 3", List.of("", "1", "", "2", "3"))
        );
    }

}
