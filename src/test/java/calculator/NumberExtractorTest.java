package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NumberExtractorTest {

    @Test
    void 문자열에_숫자가_없으면_0을_반환한다() {
        String basicDelimiterRegex = ",|:";
        String input = "";

        NumberExtractor numberExtractor = new NumberExtractor(input);
        List<Double> maybeZero = numberExtractor.extract(basicDelimiterRegex);

        List<Double> expected = Collections.singletonList(0.0);
        boolean maybeTrue = Arrays.equals(expected.toArray(), maybeZero.toArray());
        assertTrue(maybeTrue);
    }

    @Test
    void 커스텀_구분자_문자열에서_숫자를_추출한다() {
        String customDelimiterRegex = ";";
        String input = "//;\n4;5;6";

        input = input.split("\n")[1];
        NumberExtractor numberExtractor = new NumberExtractor(input);
        List<Double> numberLeft = numberExtractor.extract(customDelimiterRegex);

        List<Double> expected = Arrays.asList(4.0, 5.0, 6.0);
        boolean maybeTrue = Arrays.equals(expected.toArray(), numberLeft.toArray());
        assertTrue(maybeTrue);

    }

    @Test
    void 기본_구분자_문자열에서_숫자를_추출한다() {
        String basicDelimiterRegex = ",|:";
        String input = "1,2:3";

        NumberExtractor numberExtractor = new NumberExtractor(input);
        List<Double> numberLeft = numberExtractor.extract(basicDelimiterRegex);

        List<Double> expected = Arrays.asList(1.0, 2.0, 3.0);
        boolean maybeTrue = Arrays.equals(expected.toArray(), numberLeft.toArray());
        assertTrue(maybeTrue);
    }
}
