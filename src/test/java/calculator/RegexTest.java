package calculator;

import calculator.domain.InputtedString;
import calculator.domain.delimiters.Delimiters;
import calculator.domain.delimiters.DelimitersFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegexTest {

    DelimitersFactory creator = new DelimitersFactory();

    @Test
    void test() {
        String line = "1,2";
        Delimiters delimiters = creator.getFromStringAfterValidate(new InputtedString(line));
        assertEquals(delimiters.getRegex(), "(\\Q,\\E)|(\\Q:\\E)");
    }


}
