package calculator;

import calculator.command.DelimiterLine;
import calculator.command.NumbersLine;
import calculator.number.NumbersReader;
import calculator.number.rule.PositiveNumbersRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {
    MyCalculator calculator = new MyCalculator(new NumbersReader(new PositiveNumbersRule()));

    @Test
    @DisplayName("숫자들을 합쳐서 결과 반환")
    void test1() {
        DelimiterLine delimiterLine = DelimiterLine.EMPTY_LINE;
        String numberStr = "1:2,3";

        int result = calculator.calculate(delimiterLine, new NumbersLine(numberStr));

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 문자열은 0을 반환")
    void test2() {
        DelimiterLine delimiterLine = DelimiterLine.EMPTY_LINE;
        String numberStr = "";

        int result = calculator.calculate(delimiterLine, new NumbersLine(numberStr));

        assertThat(result).isEqualTo(0);
    }

}