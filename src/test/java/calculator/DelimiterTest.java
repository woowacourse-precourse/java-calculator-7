package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class DelimiterTest {

    @Test
    void 기본_구분자_확인_테스트() {
        Delimiter delimiter = new Delimiter();

        assertThat(delimiter.isContain(",")).isTrue();
        assertThat(delimiter.isContain(":")).isTrue();
        assertThat(delimiter.isContain("!")).isFalse();
    }

}