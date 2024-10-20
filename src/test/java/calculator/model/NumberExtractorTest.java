package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class NumberExtractorTest {

    NumberExtractor numberExtractor = new NumberExtractor();
    Delimiters delimiters = new Delimiters();

    @Test
    void 구분자_기준_숫자_추출() {
        delimiters.addCustomDelimiter('&');
        delimiters.addCustomDelimiter('+');
        Numbers numbers = numberExtractor.extractNumber("2+13,9:4&4", delimiters);
        assertThat(numbers.getNumbers())
                .isEqualTo(Arrays.asList(new Long[]{2L, 13L, 9L, 4L, 4L}));
    }

    @Test
    void 숫자_아닌_문자_시작시_예외() {
        assertThatThrownBy(() ->
                numberExtractor.extractNumber(",5,3", delimiters))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자_숫자_제외한_문자_포함시_예외() {
        assertThatThrownBy(() ->
                numberExtractor.extractNumber("5+5,13-3", delimiters))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
