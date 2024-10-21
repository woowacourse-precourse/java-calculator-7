package calculator;

import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.Delimiter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomDelimiterTest {

    @Test
    void specifyCustomDelimiter1() {
        String line = "//a\\n";
        Delimiter delimiter = CustomDelimiter.getFromLineAfterValidateElseNull(line);
        assertEquals("a", delimiter.getSymbol());
    }

    @Test
    void specifyCustomDelimiter2() {
        String line = "//aa\\n";
        Delimiter delimiter = CustomDelimiter.getFromLineAfterValidateElseNull(line);
        assertEquals("aa", delimiter.getSymbol());
    }

    @Test
    void specifyCustomDelimiter3() {
        String line = "////\\n";
        Delimiter delimiter = CustomDelimiter.getFromLineAfterValidateElseNull(line);
        assertEquals("//", delimiter.getSymbol());
    }

    @Test
    void specifyCustomDelimiter4() {
        String line = "//\\n\\n";
        Delimiter delimiter = CustomDelimiter.getFromLineAfterValidateElseNull(line);
        assertEquals("\\n", delimiter.getSymbol());
    }

    @Test
    void specifyCustomDelimiter5() {
        String line = "////\\n\\n";
        Delimiter delimiter = CustomDelimiter.getFromLineAfterValidateElseNull(line);
        assertEquals("//\\n", delimiter.getSymbol());
    }

    @Test
    void specifyCustomDelimiter6() {
        String line = "////**\\n\\n";
        Delimiter delimiter = CustomDelimiter.getFromLineAfterValidateElseNull(line);
        assertEquals("//**\\n", delimiter.getSymbol());
    }

    @Test
    void specifyCustomDelimiter7() {
        String line = "////*\\n\\n";
        Delimiter delimiter = CustomDelimiter.getFromLineAfterValidateElseNull(line);
        assertEquals("//*\\n", delimiter.getSymbol());
    }

    @Test
    void specifyCustomDelimiter8() {
        String line = "////*a\\n\\n";
        Delimiter delimiter = CustomDelimiter.getFromLineAfterValidateElseNull(line);
        assertEquals("//*a\\n", delimiter.getSymbol());
    }

    @Test
    void specifyCustomDelimiter9() {
        String line1 = "////\\n1//2//3";

        Delimiter delimiter1 = CustomDelimiter.getFromLineAfterValidateElseNull(line1);

        assertEquals("//", delimiter1.getSymbol());
    }

    @Test
    void specifyCustomDelimiter10() {
        String line1 = "//s\\n1s2,3";
        Delimiter delimiter1 = CustomDelimiter.getFromLineAfterValidateElseNull(line1);
        assertEquals("s", delimiter1.getSymbol());

        String line2 = "//s\\ns1s2,3";
        Delimiter delimiter2 = CustomDelimiter.getFromLineAfterValidateElseNull(line2);
        assertEquals("s", delimiter2.getSymbol());

        String line3 = "//**\\n1:2**3";
        Delimiter delimiter3 = CustomDelimiter.getFromLineAfterValidateElseNull(line3);
        assertEquals("**", delimiter3.getSymbol());

        String line4 = "// \\n1 2 3";
        Delimiter delimiter4 = CustomDelimiter.getFromLineAfterValidateElseNull(line4);
        assertEquals(" ", delimiter4.getSymbol());

        String line5 = "// # \\n1 # 2 # 3";
        Delimiter delimiter5 = CustomDelimiter.getFromLineAfterValidateElseNull(line5);
        assertEquals(" # ", delimiter5.getSymbol());
    }

}

