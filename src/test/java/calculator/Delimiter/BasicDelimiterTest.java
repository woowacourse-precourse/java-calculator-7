package calculator.Delimiter;

import Delimiter.BasicDelimiter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicDelimiterTest {

    @Test
    void 기본_구분자_처리() {
        //given
        String example = "1,2,3:4";
        int[] result = {1, 2, 3, 4};
        //when
        int[] numbers = BasicDelimiter.getNumber(example);
        //then
        Assertions.assertThat(numbers).isEqualTo(result);
    }
    
}
