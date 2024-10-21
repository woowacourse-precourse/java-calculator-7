package calculator;

import static calculator.constants.ExceptionCode.VAILDATION_CUSTOME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SeparatorsTest {

    @Test
    void segregateByInput() {
        // when
        Separators separators = new Separators();

        // given
        String _string = separators.segregateByInput("1,2,3");

        // then
        assertEquals("1,2,3", _string);
    }

    @Test
    void segregateByInputWithCustomSeparators() {
        // when
        Separators separators = new Separators();

        // given
        String _string = separators.segregateByInput("//;\\n1;2;3");

        // then
        assertEquals("1;2;3", _string);
    }

    @Test
    void getRegex() {
        // when
        Separators separators = new Separators();

        // then
        assertEquals(",|:", separators.getRegex());
    }

    @Test
    void getRegexWithCustomSeparators() {
        // when
        Separators separators = new Separators();

        // given
        separators.segregateByInput("//;\\n1;2;3");

        // then
        assertEquals(",|:|;", separators.getRegex());
    }

    @Test
    void segregateByInputWithLongCustomSeparators() {
        // when
        Separators separators = new Separators();

        // given
        // IllegalArgumentException 발생
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String _string = separators.segregateByInput("//~~\\n1~~2~~3");
        });
        assertThat(exception.getMessage()).isEqualTo(VAILDATION_CUSTOME.getMessage());
    }

    
}