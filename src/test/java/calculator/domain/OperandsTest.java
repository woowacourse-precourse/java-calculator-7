package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class OperandsTest {

    @Test
    void Check_fail_Throws_IllegalArgumentException_When_operand_is_not_numeric() {
        //given
        Operands operands = Operands.of("123", "234", "abc");

        //when, then
        assertThrows(IllegalArgumentException.class, () -> Operands.check(operands));
    }
}
