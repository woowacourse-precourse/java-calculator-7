package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomParsingStrategyTest {

    private CustomParsingStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new CustomParsingStrategy();
    }

    @Test
    void 정상적인_커스텀_구분자() {
        assertEquals(6, strategy.parse("//;\n1;2;3"));
    }

    @Test
    void 커스텀_및_기본_구분자_혼합() {
        assertEquals(6, strategy.parse("//;\n1,2:1;2"));
    }

    @Test
    void 숫자_구분자_사용_에러() {
        assertThrows(IllegalArgumentException.class, () -> strategy.parse("//3\n1,2,3"));
    }

    @Test
    void 숫자만_포함된_여러_글자_구분자_에러() {
        assertThrows(IllegalArgumentException.class, () -> strategy.parse("//123\n1,2,3"));
    }

    @Test
    void 숫자_포함_구분자() {
        assertEquals(6, strategy.parse("//a1\n1a12a13"));
    }

    @Test
    void 구분자가_공백인_경우() {
        assertEquals(6, strategy.parse("// \n1 2 3"));
    }

    @Test
    void 빈_문자열_구분자_에러() {
        assertThrows(IllegalArgumentException.class, () -> strategy.parse("//\n123"));
    }

    @Test
    void 연속된_구분자_빈칸_처리() {
        assertEquals(6, strategy.parse("//,\n1,,2,,3"));
    }

    @Test
    void 음수_포함_입력_에러() {
        assertThrows(IllegalArgumentException.class, () -> strategy.parse("//;\n1;-2;3"));
    }

    @Test
    void 음수_구분자() {
        assertEquals(6, strategy.parse("//-\n1-2:3"));
    }
}