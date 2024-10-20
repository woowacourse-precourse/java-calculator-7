package calculator.calculate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculateServiceTest {

    private CalculateService calculateService;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateServiceImpl();
    }

    @Test
    void 숫자_배열_합계_계산() {
        // given
        int[] numbers = {1, 2, 3, 4};

        // when
        int result = calculateService.calculateSum(numbers);

        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 문자열_배열을_정수_배열로_변환_성공() {
        // given
        String[] inputStrings = {"1", "2", "3"};

        // when
        int[] result = calculateService.parseIntArray(inputStrings);

        // then
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void 유효하지_않은_숫자_입력시_예외() {
        // given
        String[] inputStrings = {"1", "a", "3"};

        // when & then
        assertThatThrownBy(() -> calculateService.parseIntArray(inputStrings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 숫자 형식입니다: a");
    }

    @Test
    void 음수_입력시_예외() {
        // given
        String[] inputStrings = {"1", "-2", "3"};

        // when & then
        assertThatThrownBy(() -> calculateService.parseIntArray(inputStrings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 또는 음수는 입력할 수 없습니다: -2");
    }

    @Test
    void 숫자_0_입력시_예외() {
        // given
        String[] inputStrings = {"1", "0", "3"};

        // when & then
        assertThatThrownBy(() -> calculateService.parseIntArray(inputStrings))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 또는 음수는 입력할 수 없습니다: 0");
    }
}
