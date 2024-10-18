package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InputTypeSorterTest {

    @Test
    void 기본_구분자_문자열_입력() {
        String text = "1,2,3";
        assertThat(InputTypeSorter.sort(text)).isEqualTo(BasicInput.from(text));
    }

    @Test
    void 커스텀_구분자_문자열_입력() {
        String text = "//;\\n1;2;3";
        assertThat(InputTypeSorter.sort(text)).isEqualTo(CustomInput.from(text));
    }

    @Test
    void 문자열_하나_입력() {
        String text = "1";
        assertThat(InputTypeSorter.sort(text)).isEqualTo(DefaultInput.from(text));
    }
}
