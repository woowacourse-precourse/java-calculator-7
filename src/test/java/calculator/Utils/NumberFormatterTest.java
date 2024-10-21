package calculator.Utils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberFormatterTest {
    @Test
    public void 숫자_포맷팅() {
        //given
        NumberFormatter numberFormatter = new NumberFormatter();

        //when
        String result = numberFormatter.format(1234567890123456.9);

        //then
        Assertions.assertThat(result).isEqualTo("123456789012345.9");
    }
}