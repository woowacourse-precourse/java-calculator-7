package calculator.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DefaultDataValidatorTest {

    @Test
    void 올바른_기본_데이터_검증_테스트1() {
        String inputData = ",1,:2:3,";
        assertDoesNotThrow(() -> {
                DefaultDataValidator.checkValidContents(inputData);
            }
        );
    }

    @Test
    void 비정상_기본_데이터_검증_테스트() {
        String inputData = ",1,[:2:;;;;;3,";
        assertThrows(IllegalArgumentException.class, () -> {
            DefaultDataValidator.checkValidContents(inputData);
        });
    }

}