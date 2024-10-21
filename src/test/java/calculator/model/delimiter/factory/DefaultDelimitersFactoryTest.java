package calculator.model.delimiter.factory;

import calculator.model.delimiter.domain.Delimiter;
import calculator.model.delimiter.domain.Delimiters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DefaultDelimitersFactory 클래스")
public class DefaultDelimitersFactoryTest {

    private static final String rightDelimiter = ";";
    private static final DefaultDelimitersFactory defaultDelimitersFactory = new DefaultDelimitersFactory();

    @Test
    void 매개변수_없이_기본_구분자를_포함한_구분자들을_생산한다() {

        // given
        List<Delimiter> expectedDelimiters = List.copyOf(defaultDelimitersFactory.getDefaultDelimiters());

        // when
        Delimiters delimiters = defaultDelimitersFactory.createDelimiters();

        // then
        assertThat(delimiters.getValues()).containsExactlyInAnyOrderElementsOf(expectedDelimiters);
    }

    @Test
    void 매개변수와_함께_기본_구분자를_포함한_구분자들을_생산한다() {

        // given
        Delimiter additionalDelimiter = new Delimiter(rightDelimiter);
        List<Delimiter> expectedDelimiters = new ArrayList<>(defaultDelimitersFactory.getDefaultDelimiters());
        expectedDelimiters.add(additionalDelimiter);

        // when
        Delimiters delimiters = defaultDelimitersFactory.createDelimiters(additionalDelimiter);

        // then
        assertThat(delimiters.getValues()).containsExactlyInAnyOrderElementsOf(expectedDelimiters);
    }
}
