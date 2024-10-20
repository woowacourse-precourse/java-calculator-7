package calculator.delimiter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CustomDelimiterPatternTest {

    private static CustomDelimiterPattern pattern;

    @BeforeAll
    static void beforeAll() {
        pattern = new CustomDelimiterPattern();
    }

    @ParameterizedTest
    @CsvSource({
            "'//;\\n1;2;3'",
            "'//!\\n'"
    })
    public void 정상적인_상황_성공(String input) {
        assertThat(pattern.validate(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "'//!\\n-1'",
            "'//!\\n0!5'",
            "'//!\\n1!-5'",
            "'//!\\n0'",
    })
    public void 구분자는_정상인데_숫자가_양수가_아닌경우(String input) {
        assertThat(pattern.validate(input)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "'//5\\n'",
            "'//2\\n2'",
            "'//0\\n5'",
    })
    public void 구분자가_숫자일때(String input) {
        assertThat(pattern.validate(input)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "'asd'",
            "'aswe🤪'",
            "'12:안녕하세요'",
            "'1:안,녕:3'"
    })
    public void 아예_패턴에_맞지_않는_경우(String input) {
        assertThat(pattern.validate(input)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "'//;\\n01;2;3'",
            "'//!\\n1!01'"
    })
    public void 숫자앞에_0이_포함될때(String input) {
        assertThat(pattern.validate(input)).isFalse();
    }

    @Test
    void 숫자_갯수가_50개일때() {
        StringBuilder input = new StringBuilder("//;\\n1");
        for (int i = 2; i <= 50; i++) {
            input.append(";").append(i);
        }
        assertThat(pattern.validate(input.toString())).isTrue();
    }

    @Test
    void 숫자_갯수_50개를_넘을때() {
        StringBuilder input = new StringBuilder("//;\\n1");
        for (int i = 2; i <= 51; i++) {
            input.append(";").append(i);
        }
        assertThat(pattern.validate(input.toString())).isFalse();
    }

}
