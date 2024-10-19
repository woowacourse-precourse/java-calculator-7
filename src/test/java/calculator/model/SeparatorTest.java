package calculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SeparatorTest {


    private Separator separator = new Separator();

    @Test
    void 기본_구분자로_문자열_분리() {
        String[] result = separator.splitByAllSeparators("1,2:3");
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    void 혼합_구분자_입력시_올바른_분리() {
        String[] result = separator.splitByAllSeparators("1,2:3,4:5");
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5"}, result);
    }
}