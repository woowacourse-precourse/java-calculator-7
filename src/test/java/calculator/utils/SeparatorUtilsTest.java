package calculator.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SeparatorUtilsTest {

    @Test
    void prefix를_제대로_감지하는가_1() {
        String separator = "//d";

        boolean isExist = SeparatorUtils.isSeparator(separator);
        Assertions.assertTrue(isExist);
    }

    @Test
    void prefix를_제대로_감지하는가_2() {
        String separator = "/d";

        boolean isExist = SeparatorUtils.isSeparator(separator);
        Assertions.assertFalse(isExist);
    }

    @Test
    void prefix가_제대로_제거되는가() {
        String separator = "//$";
        String expected = "$";

        String prefixRemovedSeparator = SeparatorUtils.removePrefix(separator);

        Assertions.assertEquals(expected, prefixRemovedSeparator);
    }

    @Test
    void 문자열에서_문자로_변경할때_잘못된_형식의_구분자이면_오류가_제대로_발생하는가() {
        List<String> illegalSeparators = createIllegalSeparators();

        int assertCount = 0;
        int expectedCount = illegalSeparators.size();

        for(String illegalSeparator: illegalSeparators) {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> SeparatorUtils.StringToChar(illegalSeparator));
            assertCount++;
        }

        Assertions.assertEquals(expectedCount, assertCount,"에러가 모든 호출에 대해 발생해야한다");
    }

    private static List<String> createIllegalSeparators() {
        List<String> illegalSeparators = new ArrayList<>();
        illegalSeparators.add("");
        illegalSeparators.add("5");
        illegalSeparators.add("fd");

        return illegalSeparators;
    }
}
