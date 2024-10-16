package calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ExtractorTest {

    @Test
    public void 기본_구분자로_숫자를_추출한다() {
        //given
        Extractor extractor = new Extractor();
        String input = "1,2,3";

        //when
        int[] result = extractor.extractorNumbers(input);

        //then
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }
}