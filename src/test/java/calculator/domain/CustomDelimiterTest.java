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

class CustomDelimiterTest {

    @DisplayName("커스텀 구분자 일치: //와 \n 사이에 1개 이상, 3개 이하의 문자가 존재")
    @ValueSource(strings = {"//;\\n1;2;3", "// \\n1 2 3", "//;\\n1", "// \\n", "//[+]\\n"})
    @ParameterizedTest(name = "\"{0}\"은 커스텀 구분자")
    void 커스텀_구분자_일치(String input) {
        Delimiter delimiter = new CustomDelimiter(input);

        assertThat(delimiter.matches()).isTrue();
    }

    @DisplayName("커스텀 구분자 불일치: //와 \n 사이에 문자가 존재하지 않거나 세 자리 초과한 문자가 존재")
    @ValueSource(strings = {"//\\n", "// -> \\n"})
    @ParameterizedTest(name = "\"{0}\"은 커스텀 구분자가 아님")
    void 커스텀_구분자_불일치(String input) {
        Delimiter delimiter = new CustomDelimiter(input);

        assertThat(delimiter.matches()).isFalse();
    }

    @DisplayName("커스텀 구분자 입력 분리")
    @MethodSource(value = "provideCustomInputAndNumbers")
    @ParameterizedTest(name = "{0}의 분리 결과는 {1}")
    void 커스텀_구분자_분리(String input, List<String> expectedNumbers) {
        Delimiter delimiter = new CustomDelimiter(input);

        assertThat(delimiter.split()).isEqualTo(expectedNumbers);
    }

    @DisplayName("이모지는 길이가 1인 문자로 커스텀 구분자다")
    @Test
    void 이모지_커스텀_구분자() {
        Delimiter delimiter = new CustomDelimiter("// ➕ \\n1 ➕ 2 ➕ 3");

        List<String> numbers = delimiter.split();

        assertThat(numbers).containsExactly("1", "2", "3");
    }

    static Stream<Arguments> provideCustomInputAndNumbers() {
        return Stream.of(
                Arguments.of("//;\\n", Collections.emptyList()),
                Arguments.of("//;\\n1", List.of("1")),
                Arguments.of("//;\\n1;2", List.of("1", "2")),
                Arguments.of("// \\n1 2 3", List.of("1", "2", "3")),
                Arguments.of("// \\n 1", List.of("", "1")),
                Arguments.of("// \\n 1  2 3", List.of("", "1", "", "2", "3"))
        );
    }

}
