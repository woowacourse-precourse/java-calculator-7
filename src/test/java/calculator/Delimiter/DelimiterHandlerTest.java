package calculator.Delimiter;

import Delimiter.DelimiterHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DelimiterHandlerTest {

    @Test
    void 구분자_유형_구별_기본_구분자() {
        //given
        String input = "1,2,:3,4";
        //when
        String result = DelimiterHandler.detectDelimiterType(input);
        //then
        Assertions.assertThat(result).isEqualTo("Basic");
    }

    @Test
    void 구분자_유형_구별_커스텀_구분자() {
        //given
        String input = "//;\n1;2,3";
        //when
        String result = DelimiterHandler.detectDelimiterType(input);
        //then
        Assertions.assertThat(result).isEqualTo("Custom");
    }
}
