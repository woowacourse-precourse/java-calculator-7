package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class DelimitersTest {

    Delimiters delimiters = new Delimiters();

    @Test
    void 구분자_추가() {
        delimiters.addCustomDelimiter('%');
        assertThat(delimiters.getDelimiters())
                .isEqualTo(Arrays.asList(new Character[]{',', ':', '%'}));
    }
}
