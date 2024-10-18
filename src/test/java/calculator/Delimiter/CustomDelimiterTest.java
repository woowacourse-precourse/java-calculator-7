package calculator.Delimiter;

import static org.assertj.core.api.Assertions.assertThat;

import Delimiter.CustomDelimiter;
import org.junit.jupiter.api.Test;

public class CustomDelimiterTest {

    @Test
    void 커스텀_구분자_처리() {
        //given
        String example = "//;\\n1;2;3";
        int[] result = {1, 2, 3};
        //when
        int[] numbers = CustomDelimiter.getNumber(example);
        //then
        assertThat(numbers).isEqualTo(result);
    }


}
