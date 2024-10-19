package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SeparatorTest {
    @Test
    @DisplayName("getNumber 테스트")
    public void getNumbersTest(){
        Separator separator = new Separator();
        String testString = "//;\\n1;2";
        Numbers numbers1 = separator.getNumbers(testString);

        assertThat(numbers1.getSum()).isEqualTo(3.0);
    }

    @Test
    @DisplayName("커스텀 구분자 여부 검증")
    public void hasCustomSeparatorTest(){
        Separator separator1 = new Separator();
        String testString1 = "//;\\n1;2";
        Separator separator2 = new Separator();
        String testString2 = "1,2";

        assertThat(separator1.hasCustomSeparator(testString1)).isTrue();
        assertThat(separator2.hasCustomSeparator(testString2)).isFalse();
    }
}