package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class InputExtractorTest {
    private static InputExtractor extractor;

    @BeforeAll
    static void beforeAll() {
        extractor = new InputExtractor();
    }

    @Test
    void 기본_구분자_패턴에서_숫자를_추출한다() {
        String input = "1,2:3";
        List<Integer> result = extractor.extractNumbers(input);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void 기본_구분_패턴에서_빈문자열일때_빈리스트를_반환한다() {
        String input = "";
        List<Integer> result = extractor.extractNumbers(input);
        assertThat(result).isEmpty();
    }

    @Test
    void 커스텀_구분_패턴에서_숫자를_추출한다() {
        String input = "//;\\n1;2;3";
        List<Integer> result = extractor.extractNumbers(input);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void 커스텀_구분_패턴에서_숫자가_없을시_빈리스트를_반환한다() {
        String input = "//;\\n";
        List<Integer> result = extractor.extractNumbers(input);
        assertThat(result).isEmpty();
    }
}
