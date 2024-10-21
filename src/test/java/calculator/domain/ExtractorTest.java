package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ExtractorTest {

    @Test
    void 커스텀_구분자_추출하기() {
        Extractor extractor = new Extractor("//;\n1;2;3");
        Separator customSeparator = new Separator(";");
        assertEquals(customSeparator.getSeparator(), extractor.getCustomSeparators().get(0).getSeparator());
    }

    @Test
    void 숫자_추출하기() {
        Extractor extractor = new Extractor("//'\n1:2,3//|\n//;\n4|5");
        List<Number> numbers = extractor.getNumbers();
        List<Number> answer = Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(34),
                new Number(5)
        );
        for (int i = 0; i < 4; i++) {
            assertEquals(numbers.get(i).getNumber(), answer.get(i).getNumber());
        }
    }
}
