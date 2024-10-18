package calculator.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource( strings = {
            "1=3:2",
            "A,2:1",
            "+1,1:1",
            "-1:1,1",
            "/a\\n1a3a2",
            "//a\\n10a3:2",
            "//a\\n10a3,2",
            "//1a\\n1a01a01a",
            "//12\\n912812612",
            "//ab\\n1ab2ab3ba",
            "//abc\\n1abc6bac",
            "//\\n132",
            "//&\\n1|3&2"
    })
    @DisplayName("잘못된 input 입력 시, 예외 발생")
    void inputException(String input) {
        assertThatThrownBy(() -> InputValidator.validate(input))
                        .isInstanceOf(IllegalArgumentException.class)
                .hasFieldOrPropertyWithValue("message","올바른 형태의 문자열을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource( strings = {
            "1:2,3",
            ":::",
            "1   : 2 ,   3",
            "",
            "1,3,2",
            "//a\\n10a3a2",
            "//abc\\n1abc3",
            "//a\\n1a2a3",
            "// \\n1 2 3",
    })
    @DisplayName("옳은 입력 시, 메서드 정상 종료")
    void correctInput(String input) {
        InputValidator.validate(input);
    }


}