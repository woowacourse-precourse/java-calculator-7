package calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 정상적인_커스텀_포멧() {
        String data = "//;\\n";
        assertDoesNotThrow(() -> {
            Validator.checkValidCustomFormat(data);
        });
    }

    @Test
    void 비정상_커스텀_포멧_개행_없음() {
        String data = "//;";
        assertThrows(
                IllegalArgumentException.class, () -> {
                    Validator.checkValidCustomFormat(data);
                }
        );
    }

    @Test
    void 비정상_커스텀_포멧_개행_여러개() {
        String data = "//;\\n\\n\\n";
        assertThrows(
                IllegalArgumentException.class, () -> {
                    Validator.checkValidCustomFormat(data);
                }
        );
    }
}