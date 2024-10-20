package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultParsingStrategyTest {

    private DefaultParsingStrategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new DefaultParsingStrategy();
    }

    @Test
    void 빈_문자열_처리() {
        assertEquals(0, strategy.parse(""));
    }

    @Test
    void 숫자_하나만_있는_경우() {
        assertEquals(1, strategy.parse("1"));
    }

    @Test
    void 쉼표로_구분된_숫자들() {
        assertEquals(6, strategy.parse("1,2,3"));
    }

    @Test
    void 콜론으로_구분된_숫자들() {
        assertEquals(6, strategy.parse("1:2:3"));
    }

    @Test
    void 쉼표와_콜론으로_혼합된_구분자() {
        assertEquals(6, strategy.parse("1,2:3"));
    }

    @Test
    void 연속된_구분자() {
        assertEquals(6, strategy.parse("1,2::3"));
    }

    @Test
    void 공백을_포함한_숫자() {
        assertThrows(IllegalArgumentException.class, () -> {
            strategy.parse(" 1 , 2 : 3 ");
        });
    }

    @Test
    void 잘못된_형식() {
        assertThrows(IllegalArgumentException.class, () -> {
            strategy.parse("1,a,3");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            strategy.parse("1;2,3");
        });
    }
}