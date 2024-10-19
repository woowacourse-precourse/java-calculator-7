package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {

    @Test
    public void 정상_입력_처리() {
        // given
        String[] input = new String[]{"21", "534", "62", "36", "53"};

        // when
        List<Integer> result = Converter.convert(input);
        List<Integer> expected = Arrays.asList(21, 534, 62, 36, 53);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void null_입력시_처리() {
        // given
        String[] input = null;

        // when
        List<Integer> result = Converter.convert(input);
        List<Integer> expected = List.of(0);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void 문자가_포함된_경우() {
        // given
        String[] input = new String[]{"21,", "5_34", "62", "36", "53"};

        // when
        // then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Converter.convert(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 음수가 포함된 경우
    @Test
    public void 음수가_포함된_경우() {
        // given
        String[] input = new String[]{"-21","-6", "36", "53"};

        // when
        // then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Converter.convert(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 0만 있는 경우
    @Test
    public void _0만_있는_경우() {
        // given
        String[] input = new String[]{"0"};

        // when
        List<Integer> result = Converter.convert(input);
        List<Integer> expected = List.of(0);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}
