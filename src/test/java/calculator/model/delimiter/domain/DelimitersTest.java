package calculator.model.delimiter.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

import static calculator.util.pattern.PatternUtils.SPLIT_DELIMITER;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Delimiters 클래스")
public class DelimitersTest {

    private static List<Delimiter> values;
    private static Delimiters delimiters;

    @BeforeAll
    static void setUp() {
        values = List.of(
                new Delimiter(";"),
                new Delimiter(","),
                new Delimiter("="),
                new Delimiter("a"),
                new Delimiter("<")
        );
        delimiters = new Delimiters(values);
    }

    @Test
    void 구분자로_나누기_위한_문자열을_생성한다() {

        // given
        String expected = String.join(SPLIT_DELIMITER, values.stream().map(Delimiter::value).toList());

        // when
        String actual = delimiters.splitRegex();

        // then
        assertEquals(expected, actual);
    }

    @Test
    void 구분자들을_전부_포함하는_패턴을_생성한다() {

        // given
        String regex = String.join(SPLIT_DELIMITER, values.stream().map(Delimiter::value).toList());
        Pattern expected = Pattern.compile(regex);

        // when
        Pattern actual = delimiters.pattern();

        // then
        assertEquals(expected.pattern(), actual.pattern());
    }
}
