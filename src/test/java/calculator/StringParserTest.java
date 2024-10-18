package calculator;

import calculator.numberExtractor.NumberExtractorImpl;
import calculator.separatorProvider.SeparatorProviderImpl;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringParserTest {

    @Test
    void 커스텀구분자를_지정하지_않고_parse한다() {
        //given
        SeparatorProviderImpl separatorExtractor = new SeparatorProviderImpl();
        NumberExtractorImpl numberExtractor = new NumberExtractorImpl();

        StringParser sut = new StringParser(separatorExtractor, numberExtractor);

        //when
        List<Integer> result = sut.parse("", "1:2:3,4");

        //then
        Assertions.assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    void 커스텀구분자를_지정하고_parse한다() {
        //given
        SeparatorProviderImpl separatorExtractor = new SeparatorProviderImpl();
        NumberExtractorImpl numberExtractor = new NumberExtractorImpl();

        StringParser sut = new StringParser(separatorExtractor, numberExtractor);

        //when
        List<Integer> result = sut.parse(";", "1:2;3,4");

        //then
        Assertions.assertThat(result).containsExactly(1, 2, 3, 4);
    }
}