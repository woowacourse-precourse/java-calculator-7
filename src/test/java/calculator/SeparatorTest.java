package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorTest {
    @Test
    @DisplayName("getNumber 테스트")
    public void getNumbersTest() throws Exception{
        Separator separator = new Separator();
        String testString = "//;\\n1;2";
        Numbers numbers1 = separator.getNumbers(testString);

        assertThat(numbers1.getSum()).isEqualTo(3.0);
    }
}