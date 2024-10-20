package calculator.converter;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberConverterImplTest {

    private final NumberConverterImpl numberConverter = new NumberConverterImpl();

    @Test
    void 정상적인_숫자_입력() {
        String[] input = {"1", "2", "3", "4"};
        int[] expected = {1, 2, 3, 4};

        int[] result = numberConverter.convert(input);

        assertThat(result).containsExactly(expected);
    }

    @Test
    void 음수_입력() {
        String[] input = {"1", "-2", "3"};

        assertThatThrownBy(() -> numberConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수만 입력할 수 있습니다: -2");
    }

    @Test
    void 빈문자열_입력() {
        String[] input = {""};
        int[] expected = {0};

        int[] result = numberConverter.convert(input);

        assertThat(result).containsExactly(expected);
    }

    @Test
    void 잘못된_숫자_형식() {
        String[] input = {"1", "2a", "3"};

        assertThatThrownBy(() -> numberConverter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 숫자 형식입니다: 2a");
    }
}
