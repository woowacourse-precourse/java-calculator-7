package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class NumberExtractorTest {

    @DisplayName("구분자와 숫자로 이루어진 계산식이 구분자로 나뉘어 모아진 리스트를 반환하는지 테스트하라")
    @Test
    void test_extractNumbers() {
        NumberExtractor numberExtractor = new NumberExtractor();

        List<Integer> numbers = numberExtractor.extractNumbers(
                new DelimiterAndNumber(";", "1;2;3")
        );

        Assertions.assertThat(numbers).isEqualTo(List.of(1, 2, 3));
    }
}
