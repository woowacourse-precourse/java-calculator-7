package calculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class NumbersTest {

    @Test
    void 숫자_배열로_Numbers_객체_생성() {
        Numbers numbers = Numbers.from(new String[]{"1", "2", "3"});
        assertNotNull(numbers);
    }

    @Test
    void Numbers_객체의_합계_계산() {
        Numbers numbers = Numbers.from(new String[]{"1", "2", "3"});
        assertEquals(Number.from("6"), numbers.sumNumbers());
    }

    @Test
    void 빈_Numbers_객체의_합계는_0() {
        Numbers numbers = Numbers.from(new String[]{});
        assertEquals(Number.from("0"), numbers.sumNumbers());
    }

    @Test
    void 음수를_포함한_Numbers_객체의_합계_계산() {
        Numbers numbers = Numbers.from(new String[]{"-1", "2", "-3"});
        assertEquals(Number.from("-2"), numbers.sumNumbers());
    }

    @Test
    void 큰_숫자를_포함한_Numbers_객체의_합계_계산() {
        Numbers numbers = Numbers.from(new String[]{"1000", "2000", "3000"});
        assertEquals(Number.from("6000"), numbers.sumNumbers());
    }

    @Test
    void 소수를_포함한_Numbers_객체의_합계_계산() {
        Numbers numbers = Numbers.from(new String[]{"1.1", "2.2", "3.3"});
        assertEquals(Number.from("6.6"), numbers.sumNumbers());
    }

    @Test
    void 정수와_소수를_혼합한_Numbers_객체의_합계_계산() {
        Numbers numbers = Numbers.from(new String[]{"1", "2.5", "3.7"});
        assertEquals(Number.from("7.2"), numbers.sumNumbers());
    }

    @Test
    void 다양한_소수점_자리수를_가진_Numbers_객체의_합계_계산() {
        Numbers numbers = Numbers.from(new String[]{"1.23", "2.456", "3.7890"});
        assertEquals(Number.from("7.48"), numbers.sumNumbers());
    }

    @Test
    void 매우_작은_소수를_포함한_Numbers_객체의_합계_계산() {
        Numbers numbers = Numbers.from(new String[]{"0.0001", "0.0002", "0.0003"});
        assertEquals(Number.from("0.0006"), numbers.sumNumbers());
    }
}