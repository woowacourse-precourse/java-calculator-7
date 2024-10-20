package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ExtractorTest {

    Extractor extractor = new Extractor();

    @Test
    void 커스텀_구분자_설정_영역_추출_성공_테스트() {
        String input = "//;tb=-//++~``\n1;2;3";
        String expected = "//;tb=-//++~``\n";
        String result = extractor.extractOptionField(input);

        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자_설정_영역_추출_실패_테스트() {
        String input = "//;tb=-//++~``\n1;2;3";
        String expected = "//;tb=-//++~`\n";    // 마지막 `(백틱) 미포함
        String result = extractor.extractOptionField(input);

        assertNotEquals(expected, result);
    }

    @Test
    void 숫자_포함_영역_추출_성공_테스트() {
        String input = "//;tb=-//++~``\n1;2;3t45b7";
        String expected = "1;2;3t45b7";
        String result = extractor.extractTargetField(input);

        assertEquals(expected, result);
    }

    @Test
    void 숫자_포함_영역_추출_실패_테스트() {
        String input = "//;tb=-//++~``\n1;2;3t45b7";
        String expected = "1;2;3t45c7";    // b가 아닌 c 문자 포함 되어 오류
        String result = extractor.extractTargetField(input);

        assertNotEquals(expected, result);
    }



    @Test
    void 커스텀_구분자가_1개_존재할때_숫자_추출_테스트() {
        String customSeparators = "-";
        String inputToExtract = "1-2,3:4,5-6-7";
        List<Double> expected = List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0);
        List<Double> result = extractor.extractNumbersWithSeparator(customSeparators, inputToExtract);
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
        List<Double> result = extractor.extractNumbersWithSeparator(customSeparators, inputToExtract);
        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자가_존재하지_않을_때_숫자_추출_테스트() {
        String inputToExtract = "1:2:3:4,5,6,7:8,9:10";
        String customSeparators = "";
        List<Double> expected = List.of(
                1.0, 2.0, 3.0, 4.0, 5.0,
                6.0, 7.0, 8.0, 9.0, 10.0
        );

        List<Double> result = extractor.extractNumbersWithSeparator(customSeparators, inputToExtract);
        assertEquals(expected, result);
    }
}
