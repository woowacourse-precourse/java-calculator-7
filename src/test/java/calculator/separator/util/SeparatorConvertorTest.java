package calculator.separator.util;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class SeparatorConvertorTest {
    @Test
    void createCustomConvertorTest() {
        String input = "//s\\n1s2s3s4";
        String input2 = "////\\n\\n1//\\n2//\\n3//\\n4";
        String input3 = "//sad\\n1sad2sad3sad4";

        String separator = SeparatorConvertor.createCustomSeparator(input);
        String separator2 = SeparatorConvertor.createCustomSeparator(input2);
        String separator3 = SeparatorConvertor.createCustomSeparator(input3);

        assertThat(separator).isEqualTo("s");
        assertThat(separator2).isEqualTo("//\\n");
        assertThat(separator3).isEqualTo("sad");
    }

    @Test
    void createNumberTest() {
        String input = "//s\\n1s2s3s4";
        String input2 = "////\\n\\n1//\\n2//\\n3//\\n4";
        String input3 = "//sad\\n1sad2sad3sad4";

        String number = SeparatorConvertor.createNumber(input);
        String number2 = SeparatorConvertor.createNumber(input2);
        String number3 = SeparatorConvertor.createNumber(input3);

        assertThat(number).isEqualTo("1s2s3s4");
        assertThat(number2).isEqualTo("1//\\n2//\\n3//\\n4");
        assertThat(number3).isEqualTo("1sad2sad3sad4");
    }

}
