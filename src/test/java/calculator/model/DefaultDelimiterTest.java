package calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultDelimiterTest {

    @Test
    void 기본_구분자_존재_확인_1() {
        String input = "1,2";
        Assertions.assertTrue(DefaultDelimiter.hasDefaultDelimiter(input));
    }


    @Test
    void 기본_구분자_존재_확인_2() {
        String input = "1:2";
        Assertions.assertTrue(DefaultDelimiter.hasDefaultDelimiter(input));
    }

    @Test
    void 기본_구분자_존재_확인_3() {
        String input = "";
        Assertions.assertFalse(DefaultDelimiter.hasDefaultDelimiter(input));
    }
}