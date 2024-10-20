package calculator.model.delimiter.factory;

import calculator.model.custom_delimiter.validator.DelimiterValidator;
import calculator.model.delimiter.domain.Delimiter;
import calculator.model.delimiter.domain.Delimiters;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("DefaultDelimiterFactory 클래스")
public class DefaultDelimiterFactoryTest {

    private static final String wrongDelimiter = "a";
    private static final String rightDelimiter = ";";
    private static DefaultDelimiterFactory defaultDelimiterFactory;

    @BeforeAll
    static void setUp() {
        defaultDelimiterFactory = new DefaultDelimiterFactory(new DelimiterValidator() {
            @Override
            public void validate(String delimiterString) {
                if (delimiterString.equals(wrongDelimiter)) {
                    throw new RuntimeException();
                }
            }
        });
    }

    @Test
    void 구분자를_하나_생산한다() {

        // given
        String value = rightDelimiter;

        // when
        Delimiter delimiter = defaultDelimiterFactory.createDelimiter(value);

        // then
        assertEquals(value, delimiter.value());
    }

    @Test
    void 구분자_생성_시_검증이_이루어진다() {
        // when & then
        assertThrows(RuntimeException.class, () -> defaultDelimiterFactory.createDelimiter(wrongDelimiter));
    }

    @Test
    void 매개변수_없이_기본_구분자를_포함한_구분자들을_생산한다() {

        // given
        List<Delimiter> expectedDelimiters = List.copyOf(defaultDelimiterFactory.getDefaultDelimiters());

        // when
        Delimiters delimiters = defaultDelimiterFactory.createDelimiters();

        // then
        assertThat(delimiters.getValues()).containsExactlyInAnyOrderElementsOf(expectedDelimiters);
    }

    @Test
    void 매개변수와_함께_기본_구분자를_포함한_구분자들을_생산한다() {

        // given
        Delimiter additionalDelimiter = new Delimiter(rightDelimiter);
        List<Delimiter> expectedDelimiters = new ArrayList<>(defaultDelimiterFactory.getDefaultDelimiters());
        expectedDelimiters.add(additionalDelimiter);

        // when
        Delimiters delimiters = defaultDelimiterFactory.createDelimiters(additionalDelimiter);

        // then
        assertThat(delimiters.getValues()).containsExactlyInAnyOrderElementsOf(expectedDelimiters);
    }
}
