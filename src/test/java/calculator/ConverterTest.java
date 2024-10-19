package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        List<Integer> expected = Arrays.asList(0);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    // 문자가 포함된 경우

    // 음수가 포함된 경우

    // 0만 있는 경우


}
