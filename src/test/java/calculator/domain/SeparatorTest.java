package calculator.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeparatorTest {

    private final Separator separator = new Separator();

    @Test
    @DisplayName("구분자로 수식을 숫자로 분리 - 분리 성공한 경우")
    void separateByDelimiter() {
        //given
        String input = "1,2:3;4";
        String delimiter = ",:;";
        List<String> expected = Arrays.asList("1", "2", "3", "4");

        //when
        List<String> actual = separator.separateByDelimiter(input, delimiter);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}