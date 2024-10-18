package calculator.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WoowahanTokenizerTest {
    @Test
    void getCustomSeparatorFromInputString() {
        String inputString = "\\\\!\\n0!2!3!4";
        WoowahanTokenizer wt = new WoowahanTokenizer(inputString);

        wt.setCustomSeparator();
        assertEquals("0!2!3!4", wt.getInputString());
        assertEquals("!", wt.getCustomSeparator());
    }

    @Test
    void tokenizeStringTest() {
        String inputString = "\\\\!\\n0!2:3,4";
        WoowahanTokenizer wt = new WoowahanTokenizer(inputString);

        wt.setCustomSeparator();
        List<String> expectedValues = new ArrayList<>();
        expectedValues.add("0");
        expectedValues.add("2");
        expectedValues.add("3");
        expectedValues.add("4");
        assertEquals(expectedValues, wt.tokenizeString());


    }

    @Test
    void emptyInput() {
        String inputString = "";
        WoowahanTokenizer wt = new WoowahanTokenizer(inputString);

        wt.setCustomSeparator();
        assertEquals("", wt.getInputString());
        assertEquals("", wt.getCustomSeparator());
    }
}