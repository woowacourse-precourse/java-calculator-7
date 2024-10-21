package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterParserTest {

    @Test
    void 문자열에서_커스텀구분자_찾기() {
        DelimiterParser dp = new DelimiterParser();
        String str = "1,2,3//!\\n2:3!4//*\\n";
        String customDelimiter = dp.findCustomDelimiter(str);

        Assertions.assertThat(customDelimiter).isEqualTo("!*");
        Assertions.assertThat(customDelimiter).isNotEqualTo("!*-");
    }

    @Test
    void 커스텀구분자_등록양식_미준수() {
        DelimiterParser dp = new DelimiterParser();
        String str = "1,2,3//!\\n2:3!4//*";
        String str1 = "\n1,2,3//!\\n2:3!4//*";

        Assertions.assertThatThrownBy(() -> dp.findCustomDelimiter(str))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> dp.findCustomDelimiter(str1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}