package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.input.BasicInput;
import calculator.domain.input.CustomInput;
import calculator.domain.input.EmptyInput;
import calculator.domain.input.InputTypeSorter;
import calculator.domain.input.OtherInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTypeSorterTest {

    @Test
    void 빈_문자열_입력() {
        assertThat(InputTypeSorter.sort("")).isEqualTo(EmptyInput.from(""));
        assertThat(InputTypeSorter.sort(null)).isEqualTo(EmptyInput.from(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1:2,3"})
    void 기본_구분자_문자열_입력(String input) {
        assertThat(InputTypeSorter.sort(input)).isEqualTo(BasicInput.from(input));
    }

    @Test
    void 커스텀_구분자_문자열_입력() {
        assertThat(InputTypeSorter.sort("//;\\n1;2;3")).isEqualTo(CustomInput.from("//;\\n1;2;3"));
    }

    @Test
    void 문자열_하나_입력() {
        assertThat(InputTypeSorter.sort("123")).isEqualTo(OtherInput.from("123"));
    }
}
