package calculator.model.delimiter.factory;

import calculator.model.delimiter.domain.Delimiter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("DefaultDelimiterFactory 클래스")
public class DefaultDelimiterFactoryTest {

    private static final String rightDelimiter = ";";
    private static final String wrongDelimiter = "a";
    private static DefaultDelimiterFactory defaultDelimiterFactory;

    @BeforeAll
    static void setUp() {
        defaultDelimiterFactory = new DefaultDelimiterFactory(delimiterString -> {
            if (delimiterString.equals(wrongDelimiter)) {
                throw new RuntimeException();
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


}
