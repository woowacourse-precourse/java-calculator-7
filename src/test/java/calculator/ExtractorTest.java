package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.domain.Extractor;
import org.junit.jupiter.api.Test;

class ExtractorTest {

    @Test
    public void 커스텀_구분자의_유무를_안다() {
        //given
        Extractor ex = new Extractor();
        String input = "//+\\n1,2,3";

        //when & then
        assertFalse(ex.isDefaultDelimiterUsed(input));
    }

    @Test
    public void 커스텀_구분자의_유무를_안다2() {
        //given
        Extractor ex = new Extractor();
        String input = "1,2,3";

        //when & then
        assertTrue(ex.isDefaultDelimiterUsed(input));
    }

    @Test
    public void 문자열에서_커스텀_구분자를_추출한다() {
        //given
        Extractor ex = new Extractor();
        String input = "//;\\n1;2;3";

        //when
        String result = ex.extractCustomDelimiter(input);

        //then
        assertThat(result).isEqualTo(";");
    }

    @Test
    public void 커스텀_구분자로_숫자를_추출한다() {
        //given
        Extractor ex = new Extractor();
        String input = "//?\\n1?2?3";

        //when
        String delimiter = ex.extractCustomDelimiter(input);
        int[] result = ex.extractNumbersWithCustomDelimiter(input, delimiter);

        //then
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    public void 커스텀_구분자로_숫자를_추출한다2() {
        //given
        Extractor ex = new Extractor();
        String input = "//[\\n1[2[3";

        //when
        String delimiter = ex.extractCustomDelimiter(input);
        int[] result = ex.extractNumbersWithCustomDelimiter(input, delimiter);

        //then
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    public void 기본_구분자로_숫자를_추출한다() {
        //given
        Extractor extractor = new Extractor();
        String input = "1,2:3";

        //when
        int[] result = extractor.extractNumbersWithDefaultDelimiter(input);

        //then
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    public void 지정된_커스텀_구분자를_사용해야한다() {
        //given
        Extractor ex = new Extractor();
        String input = "//\\n1=2=3=4=5";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> ex.extractCustomDelimiter(input));
    }

    @Test
    public void 지정된_커스텀_구분자를_사용해야한다2() {
        //given
        Extractor ex = new Extractor();
        String input = "//'\\1;2;3";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> ex.extractCustomDelimiter(input));
    }

    @Test
    public void 커스텀_구분자는_정해진_접두사가_있다() {
        //given
        Extractor ex = new Extractor();
        String input = "/\\\\n1\\2\\3\\4";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> ex.extractCustomDelimiter(input));
    }

    @Test
    public void 커스텀_구분자는_정해진_접미사가_있다() {
        //given
        Extractor ex = new Extractor();
        String input = "//?_n1?2?3?4";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> ex.extractCustomDelimiter(input));
    }
}