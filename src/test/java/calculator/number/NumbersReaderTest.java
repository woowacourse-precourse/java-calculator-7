package calculator.number;

import calculator.command.DelimiterLine;
import calculator.command.NumbersLine;
import calculator.delimiter.DelimiterRegex;
import calculator.number.rule.NumbersRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersReaderTest {

    NumbersReader numbersReader;

    @BeforeEach
    void beforeEach() {
        NumbersRule alwaysValid = (numbers) -> false;
        numbersReader = new NumbersReader(alwaysValid);
    }

    @Test
    @DisplayName("구분자를 통해 숫자 구분")
    void test1() {
        NumbersLine numbersLine = new NumbersLine("1:2:3");
        DelimiterRegex delimiterRegex = createDelimiter(":");

        assertArrayEquals(numbersReader.readNumbers(numbersLine, delimiterRegex), new int[]{1,2,3});
    }

    @Test
    @DisplayName("잘못된 형식의 숫자는 예외")
    void test2() {
        NumbersLine numbersLine = new NumbersLine("1:a:3");
        DelimiterRegex delimiterRegex = createDelimiter(":");

        assertThrows(IllegalArgumentException.class, () -> numbersReader.readNumbers(numbersLine, delimiterRegex));
    }

    @Test
    @DisplayName("Rule에서 invalid를 반환하면 예외처리")
    void test3() {
        NumbersRule invalid = (numbers) -> true;
        numbersReader = new NumbersReader(invalid);

        NumbersLine numbersLine = new NumbersLine("1:2:-3");
        DelimiterRegex delimiterRegex = createDelimiter(":");

        assertThrows(IllegalArgumentException.class, () -> numbersReader.readNumbers(numbersLine, delimiterRegex));
    }

    private static DelimiterRegex createDelimiter(String value) {
        return DelimiterRegex.create(new DelimiterLine(value));
    }
}