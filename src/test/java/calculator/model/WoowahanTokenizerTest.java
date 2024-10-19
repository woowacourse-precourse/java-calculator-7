package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WoowahanTokenizerTest {
    @Test
    void 커스텀_구분자_포함한_덧셈_문자열_입력() {
        String inputString = "//!\n0!2!3!4";
        WoowahanTokenizer wt = new WoowahanTokenizer(inputString);

        assertEquals("0!2!3!4", wt.getInputString());
        assertEquals("!", wt.getCustomSeparator());
    }

    @Test
    void 구분자들로_문자열_정상_분리_여부_테스트() {
        String inputString = "//!\n0!2:3,4";
        WoowahanTokenizer wt = new WoowahanTokenizer(inputString);

        List<String> expectedValues = new ArrayList<>();
        expectedValues.add("0");
        expectedValues.add("2");
        expectedValues.add("3");
        expectedValues.add("4");
        assertEquals(expectedValues, wt.getStringTokens());


    }

    @Test
    void 아무_입력도_주어지지_않았을_때() {
        String inputString = "";
        WoowahanTokenizer wt = new WoowahanTokenizer(inputString);

        assertEquals("", wt.getInputString());
        assertEquals("", wt.getCustomSeparator());
    }

    @Test
    void 커스텀_구분자만_문자열로_주어졌을_때() {
        String inputString = "//!\n";
        WoowahanTokenizer wt = new WoowahanTokenizer(inputString);

        assertEquals("", wt.getInputString());
        assertEquals("!", wt.getCustomSeparator());
    }

    @Test
    void 연속된_구분자가_포함된_문자열() {
        assertThrows(IllegalArgumentException.class, 
            ()->{
                WoowahanTokenizer wt = new WoowahanTokenizer("1::2");
            });
        assertThrows(IllegalArgumentException.class, 
            ()->{
                WoowahanTokenizer wt = new WoowahanTokenizer("//?\n1::2?3???4");
            });
    }
}