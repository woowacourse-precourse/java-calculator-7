package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ParserTest {

    Parser parser = new Parser();

    @Test
    void 커스텀_구분자가_존재할_때_추출_테스트() {
        String input = "//;tb=-//++~``\n1;2;3";
        String expected = ";tb=-//++~``";
        String result = parser.extractCustomSeparators(input);

        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자가_존재하지_않을_때_추출_테스트() {
        String input = "1:2,3";
        String expected = null;
        String result = parser.extractCustomSeparators(input);

        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자의_문자만_포함되어_있을_때_테스트() {
        String input = "//;tb=-//++~``\n1;2;3";
        boolean expected = true;
        boolean result = parser.isCustomSeparatorsValid(input);
        assertEquals(expected, result);
    }


    @Test
    void 커스텀_구분자가_1개_존재할때_숫자_추출_테스트() {
        String customSeparators = "-";
        String inputToExtract = "1-2,3:4,5-6-7";
        List<Double> expected = List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0);
        List<Double> result = parser.extractNumbersWithSeparator(customSeparators, inputToExtract);
        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자가_2개_이상_존재할떄_숫자_추출_테스트() {
        String customSeparators = "-_'][,:.;";
        String inputToExtract = "1-2,3_4,5'6,7:8;9[10]11.12";
        List<Double> expected = List.of(
                1.0, 2.0, 3.0, 4.0, 5.0, 6.0,
                7.0, 8.0, 9.0, 10.0, 11.0, 12.0
        );
        List<Double> result = parser.extractNumbersWithSeparator(customSeparators, inputToExtract);
        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자가_존재하지_않을_때_숫자_추출_테스트() {
        String inputToExtract = "1:2:3:4,5,6,7:8,9:10";
        List<Double> expected = List.of(
                1.0, 2.0, 3.0, 4.0, 5.0,
                6.0, 7.0, 8.0, 9.0, 10.0
        );

        List<Double> result = parser.extractNumbersWithSeparator(inputToExtract);
        assertEquals(expected, result);
    }

}
