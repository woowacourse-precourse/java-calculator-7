package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    Validator validator = new Validator("[,:]", "//", "\\n");

    @Test
    void 커스텀_구분자_형식에_벗어날때_예외처리(){
        String value = "//\n1,2,3";
        assertThatThrownBy(() -> validator.validateDelimiter(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
