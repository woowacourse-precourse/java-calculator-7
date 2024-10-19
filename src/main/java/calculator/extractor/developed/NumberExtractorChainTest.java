package calculator.extractor.developed;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberExtractorChainTest {
    private final List<DelimitedNumberExtractorTest> extractors;

    public NumberExtractorChainTest(List<DelimitedNumberExtractorTest> extractors) {
        this.extractors = new ArrayList<>(extractors);
    }

    public List<String> extract(String input) {
        for (DelimitedNumberExtractorTest extractor : extractors) {
            ExtractResultTest result = extractor.extract(input);
            if (result.isExtracted()) {
                return result.getNumbers();
            }
        }
        throw new IllegalArgumentException("적용 가능한 구분자가 없습니다");
    }

    public void addExtractor(DelimitedNumberExtractorTest extractor) {
        extractors.add(extractor);
    }

    public void removeExtractor(DelimitedNumberExtractorTest extractor) {
        extractors.remove(extractor);
    }
}

class NumberExtractorChainMethodTest {

    @Test
    @DisplayName("생성자 테스트")
    void constructor() {
        //given
        List<DelimitedNumberExtractorTest> extractors = List.of(new StandardDelimiterNumberExtractorTest());

        Assertions.assertDoesNotThrow(() -> new NumberExtractorChainTest(extractors));
    }

    @Test
    @DisplayName("extract 성공 테스트 - extractor1개")
    void extract_ok() {
        // given
        List<DelimitedNumberExtractorTest> extractors = List.of(new StandardDelimiterNumberExtractorTest());
        NumberExtractorChainTest numberExtractorChain = new NumberExtractorChainTest(extractors);
        // when
        List<String> extract = numberExtractorChain.extract("1,2,3");
        // then
        Assertions.assertEquals(extract.size(), 3);
        Assertions.assertEquals(extract.get(0), "1");
        Assertions.assertEquals(extract.get(1), "2");
        Assertions.assertEquals(extract.get(2), "3");
    }

    @Test
    @DisplayName("extract 테스트- extractor2개")
    void extract_ok_2() {
        // given
        List<DelimitedNumberExtractorTest> extractors = List.of(new StandardDelimiterNumberExtractorTest(),
                new CustomDelimiterNumberExtractorTest());
        NumberExtractorChainTest numberExtractorChain = new NumberExtractorChainTest(extractors);
        // when
        List<String> extract = numberExtractorChain.extract("1,2,3");
        // then
        Assertions.assertEquals(extract.size(), 3);
        Assertions.assertEquals(extract.get(0), "1");
        Assertions.assertEquals(extract.get(1), "2");
        Assertions.assertEquals(extract.get(2), "3");
    }


}