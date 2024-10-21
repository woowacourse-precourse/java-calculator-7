package calculator.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SentenceUtilTest {
    @Test
    @DisplayName("구분된 문자열 추출")
    public void extractSentenceTest() {
        //given
        String input = "//m\\n1m2;3,4";
        String expect = "1m2;3,4";

        //then
        assertEquals(SentenceUtil.extractSentence(input), expect);
    }

    @Test
    @DisplayName("입력된 값이 올바른지 확인")
    public void validNumbersTest() {
        //given
        List<String> list = new ArrayList<>();
        list.add("11.1");
        list.add("k");
        list.add("13");
        //then

        assertThrows(IllegalArgumentException.class,
                () -> SentenceUtil.validNumbers(list)
        );
    }
}
