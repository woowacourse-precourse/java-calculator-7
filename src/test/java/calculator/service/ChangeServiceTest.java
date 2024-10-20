package calculator.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ChangeServiceTest {
    private static ChangeService changeService;

    @BeforeAll
    static void setUp() {
        changeService = new ChangeService();
    }

    @Test
    @DisplayName("빈 문자열에 대해 문자열 0으로 바꾸는 데 성공한다.")
    void blankToZero() {
        // given
        String[] separated = new String[]{ "", "2", "3" };

        // when
        changeService.BlankToZero(separated);

        // then
        assertThat(separated).isEqualTo(new String[]{ "0", "2", "3" });
    }
}