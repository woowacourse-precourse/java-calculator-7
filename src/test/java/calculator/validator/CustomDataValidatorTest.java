package calculator.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomDataValidatorTest {

    @Test
    void 커스텀_포멧_검증_정상_테스트() {
        String inputData = "//:\\n1:2:3:";

        assertDoesNotThrow(() -> {
            CustomDataValidator.checkValidCustomFormat(inputData);
        });
    }

    @Test
    void 커스텀_포멧_개행_여러개_검증_테스트() {
        String inputData = "//:\\n\\n\\n1:2:3:";

        assertThrows(IllegalArgumentException.class, () -> {
            CustomDataValidator.checkValidCustomFormat(inputData);
        });
    }

    @Test
    void 커스텀_구분자_숫자만_존재_테스트() {
        String inputData = ",1,2;3;4";
        String separators = ":,;";

        assertDoesNotThrow(() -> {
            CustomDataValidator.checkValidContents(inputData, separators);
        });
    }

    @Test
    void 커스텀_구분자_숫자만_존재_안함_테스트() {
        String inputData = ",1,2;[3];4";
        String separators = ":,;";

        assertThrows(IllegalArgumentException.class, () -> {
            CustomDataValidator.checkValidContents(inputData, separators);
        });
    }
}