package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class NumberExtractorTest {
    @Test
    void 구분자_기준_숫자_추출() {
        NumberExtractor numberExtractor = new NumberExtractor();
        Delimiters delimiters = new Delimiters();
        delimiters.addCustomDelimiter('&');
        delimiters.addCustomDelimiter('+');
        Numbers numbers = numberExtractor.extractNumber("2+13,9:4&4", delimiters);
        assertThat(numbers.getNumbers())
                .isEqualTo(Arrays.asList(new Long[]{2L, 13L, 9L, 4L, 4L}));
    }
}
