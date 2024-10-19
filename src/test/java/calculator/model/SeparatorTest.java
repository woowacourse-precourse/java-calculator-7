package calculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SeparatorTest {


    private final Separator separator = new Separator();

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

    @Test
    void 음수_포함_문자열_분리() {
        String[] result = separator.splitByAllSeparators("-1,2:-3,4:-5");
        assertArrayEquals(new String[]{"-1", "2", "-3", "4", "-5"}, result);
    }

    @Test
    void 소수_포함_문자열_분리() {
        String[] result = separator.splitByAllSeparators("1.1,2.2:3.3");
        assertArrayEquals(new String[]{"1.1", "2.2", "3.3"}, result);
    }

    @Test
    void 음수와_소수_혼합_문자열_분리() {
        String[] result = separator.splitByAllSeparators("-1.1,2.2:-3.3,4.4:-5.5");
        assertArrayEquals(new String[]{"-1.1", "2.2", "-3.3", "4.4", "-5.5"}, result);
    }

    @Test
    void 다양한_소수점_자리수_포함_문자열_분리() {
        String[] result = separator.splitByAllSeparators("1.23,4.5678:9.0");
        assertArrayEquals(new String[]{"1.23", "4.5678", "9.0"}, result);
    }
}