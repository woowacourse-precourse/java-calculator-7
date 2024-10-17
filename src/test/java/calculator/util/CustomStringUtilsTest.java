package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomStringUtilsTest {

    @DisplayName("문자열 출력 테스트")
    @Test
    void printStringLineFeed() {
        //given
        String str = "print";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        //when
        CustomStringUtils.printStringLineFeed(str);

        //then
        assertThat(outputStream.toString()).isEqualTo(str.concat("\n"));

        //원래의 System.out으로 변경
        System.setOut(originalOut);
    }

    @DisplayName("숫자인지 확인하는 테스트")
    @Test
    void isNumericTrue() {
        //given
        String str = "123";

        //when
        boolean result = CustomStringUtils.isNumeric(str);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("숫자가 아닌지 확인하는 테스트")
    @Test
    void isNumericFalse() {
        //given
        String str = "123as";

        //when
        boolean result = CustomStringUtils.isNumeric(str);

        //then
        assertThat(result).isFalse();
    }
}