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

    @Test
    @DisplayName("입력값의 수식 부분만 분리 - 커스텀 구분자 등록 부분이 있는 경우")
    void separateToFormulaPartWithCustomDelimiter() {
        //given
        String input = "//.\\n1,2:3;4";
        String expected = "1,2:3;4";

        //when
        String actual = separator.separateToFormulaPart(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력값의 수식 부분만 분리 - 커스텀 구분자 등록 부분이 없는 경우")
    void separateToFormulaPartWithNoCustomDelimiter() {
        //given
        String input = "1,2:3;4";
        String expected = "1,2:3;4";

        //when
        String actual = separator.separateToFormulaPart(input);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}