package calculator;

import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void 커스텀_구분자_추가_테스트() {
        Delimiter delimiter = new Delimiter();

        delimiter.addCustomDelimiter("!'/@");

        assertThat(delimiter.isContain("!")).isTrue();
        assertThat(delimiter.isContain("'")).isTrue();
        assertThat(delimiter.isContain("@")).isTrue();
        assertThat(delimiter.isContain("/")).isTrue();
        assertThat(delimiter.isContain("*")).isFalse();
        assertThat(delimiter.isContain("+")).isFalse();
    }
}