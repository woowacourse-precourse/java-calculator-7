package calculator.domain.calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

    @Nested
    @DisplayName("객체 생성 및 유효성 검증 테스트")
    class CreationAndValidationTests {

        @ParameterizedTest
        @ValueSource(strings = {
                "1,2,3",
                "//;\\n1;2;3",
                "1:2:3",
                "//@\\n1@2@3",
                "//#\\n1#2#3",
                "//!\\n1!2!3",
                "//$\\n1$2$3"
        })
        @DisplayName("문자열 계산기 객체를 정상적으로 생성한다.")
        void createStringCalculator(String input) {
            assertNotNull(StringCalculator.of(input));
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {" ", "  "})
        @DisplayName("빈 문자열이나 공백 입력 시 '0'으로 처리한다.")
        void handleEmptyOrBlankInput(String input) {
            StringCalculator calculator = StringCalculator.of(input);
            assertEquals("0", calculator.getInput());
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "//;\\n1;2;3",
                "//,\\n1,2,3",
                "//@\\n1@2@3",
                "//#\\n1#2#3",
                "//!\\n1!2!3",
                "//$\\n1$2$3"
        })
        @DisplayName("커스텀 구분자를 포함한 입력을 정상적으로 처리한다.")
        void handleCustomDelimiter(String input) {
            StringCalculator calculator = StringCalculator.of(input);
            assertFalse(calculator.getInput().contains("//"));
            assertFalse(calculator.getInput().contains("\\n"));
        }
    }
}