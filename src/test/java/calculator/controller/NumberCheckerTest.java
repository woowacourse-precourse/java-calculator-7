package calculator.controller;

import org.junit.jupiter.api.Test;

import static calculator.controller.NumberChecker.isNumber;
import static org.junit.jupiter.api.Assertions.*;

public class NumberCheckerTest {

    @Test
    void isNumber_숫자_test(){
        assertTrue(isNumber("1"));
    }

    @Test
    void isNumber_문자_test(){
        assertFalse(isNumber(","));
    }
}
