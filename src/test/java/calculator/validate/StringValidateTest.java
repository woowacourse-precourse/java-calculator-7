package calculator.validate;

import static calculator.validate.StringValidate.validateBackString;
import static calculator.validate.StringValidate.validateInput;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringValidateTest {
    @Test
    @DisplayName("유효한 입력 테스트")
    void validInput() {
        String input1 = "//\n123";
        String input2 = "//test\n12test";

        String result1 = validateInput(input1);
        String result2 = validateInput(input2);
        assertEquals(input1, result1);
        assertEquals(input2, result2);
    }

    @Test
    @DisplayName("null 입력 테스트")
    void inputWithNull() {
        assertThrows(IllegalArgumentException.class, () -> validateInput(null));
    }

    @Test
    @DisplayName("빈 입력 테스트")
    void inputWithEmpty() {
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> validateInput(input));
    }

    @Test
    @DisplayName("'//'로 시작하지 않는 문자열 테스트")
    void startWithoutSlash() {
        String input = "test//";

        assertThrows(IllegalArgumentException.class, () -> validateInput(input));
    }

    @Test
    @DisplayName("'\\n'이 없는 문자열 테스트")
    void inputWithoutEndLine() {
        String input = "//test";

        assertThrows(IllegalArgumentException.class, () -> validateInput(input));
    }

    @Test
    @DisplayName("계산해야 하는 문자열에 숫자, 구분자 외 다른 문자가 있으면 IllegalArgumentException가 발생한다.")
    void otherCharInBackString() {
        String string = "1a2B3c";
        String seperator = "abc";

        assertThrows(IllegalArgumentException.class, () -> validateBackString(string, seperator));
    }

    @Test
    @DisplayName("계산해야 하는 문자열에 숫자만 있는 경우")
    void onlyNumberInBackString() {
        String string = "123456";
        String seperator = "abc";

        assertTrue(validateBackString(string, seperator));
    }

    @Test
    @DisplayName("계산해야 하는 문자열에 구분자만 있는 경우")
    void onlySeperatorInBackString() {
        String string = "abcabc";
        String seperator = "abc";

        assertTrue(validateBackString(string, seperator));
    }

    @Test
    @DisplayName("계산해야 하는 문자열이 빈 문자열인 경우")
    void emptyBackString() {
        String string = "";
        String seperator = "abc";

        assertTrue(validateBackString(string, seperator));
    }

    @Test
    @DisplayName("구분자가 없는 경우")
    void emptySeperator() {
        String string = "1234";
        String seperator = "";

        assertTrue(validateBackString(string, seperator));
    }
}