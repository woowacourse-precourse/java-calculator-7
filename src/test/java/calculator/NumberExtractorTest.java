package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class NumberExtractorTest {

    @DisplayName("주어진 문자열과 구분자로 숫자를 추출한다")
    @Test
    void extractNumbers() {
        // given
        NumberExtractor numberExtractor = new NumberExtractor();

        String input = "1;2,3:4";
        String delimiter = ";|,|:";

        // when
        List<Integer> numbers = numberExtractor.extractNumbers(input, delimiter);

        // then
        Assertions.assertThat(numbers).isEqualTo(List.of(1,2,3,4));
    }
}