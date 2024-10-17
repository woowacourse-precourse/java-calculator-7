package delimiter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterTest {
    private final Delimiter delimiter = new Delimiter();

    @Test
    void 기본_구분자_테스트() {
        String[] result = delimiter.split("1,2:3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자_테스트() {
        String[] result = delimiter.split("//;\\n1;2;3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    void 잘못된_커스텀_구분자_형식_테스트() {
        assertThatThrownBy(() -> delimiter.split("//\\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 형식입니다");
    }
}

