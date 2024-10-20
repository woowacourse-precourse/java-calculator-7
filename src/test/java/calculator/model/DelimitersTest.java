package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @Test
    void 추가하는_구분자_숫자면_예외() {
        assertThatThrownBy(() ->
                delimiters.addCustomDelimiter('5'))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
