package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SeparatorTest {

    private static final String DEFAULT_SEPARATOR1 = ",";
    private static final String DEFAULT_SEPARATOR2 = ":";
    private static final Set<String> DEFAULT_SEPARATORS = Set.of(DEFAULT_SEPARATOR1, DEFAULT_SEPARATOR2);
    private static final String REGEX = "^//(.*)\\\\n";

    @Test
    void 디폴트_구분자_조회() {
        Separator separator = new Separator(DEFAULT_SEPARATORS);
        assertThat(separator.getSeparators()).isEqualTo(DEFAULT_SEPARATORS);
    }

    @MethodSource("testData")
    @ParameterizedTest
    void 커스텀_구분자_추가(String input, Set<String> output) {
        Separator separator = new Separator(DEFAULT_SEPARATORS);
        separator.addCustomSeparator(input, REGEX);
        assertThat(separator.getSeparators()).isEqualTo(output);
    }

    @MethodSource("testData")
    @Test
    void 디폴트와_중복된_커스텀_구분자_추가() {
        Separator separator = new Separator(DEFAULT_SEPARATORS);
        separator.addCustomSeparator("//:\\n1:2", REGEX);
        assertThat(separator.getSeparators()).isEqualTo(DEFAULT_SEPARATORS);
    }

    @MethodSource("errorTestData")
    @Test
    void 커스텀_구분자_추가_실패() {
        Separator separator = new Separator(DEFAULT_SEPARATORS);
        assertThatThrownBy(() -> separator.addCustomSeparator("//\\n12;3", REGEX))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.arguments("//;\\n1", Set.of(DEFAULT_SEPARATOR1, DEFAULT_SEPARATOR2, ";")),
                Arguments.arguments("//!\\n1", Set.of(DEFAULT_SEPARATOR1, DEFAULT_SEPARATOR2, "!")),
                Arguments.arguments("//~\\n1", Set.of(DEFAULT_SEPARATOR1, DEFAULT_SEPARATOR2, "~"))
        );
    }
}
