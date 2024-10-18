package calculator.unit.validationRule;

import static calculator.util.Message.잘못된_커스텀_구분자_형식입니다;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.validationRule.CustomTokenFormatValidationRule;
import calculator.validationRule.ValidationRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CustomTokenFormatValidationRuleTest {
    private final ValidationRule rule = new CustomTokenFormatValidationRule();


    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {
        @ParameterizedTest
        @ValueSource(strings = {"//;\n1;2;3", "//,\n1,2,3", "//:\n1:2:3", "///\n1/2/3"})
        @DisplayName("유효한 커스텀 구분자 입력 테스트")
        void validCustomDelimiterInputTest(String input) {
            assertThatNoException().isThrownBy(() -> rule.validate(input));
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {
        @ParameterizedTest
        @ValueSource(strings = {
                "//\n1;2;3",    // 커스텀 구분자가 없음
                "///\n1;2;3",     // 커스텀 구분자가 두 글자
                "//;\n1,2,3",     // 커스텀 구분자와 다른 구분자 사용
                "//;\n1;2;-3",    // 음수 포함
                "//;\n1;;2;3",   // 연속된 구분자
                "//;\n1;2;3;",    // 끝에 구분자
                "//;\n;1;2;3",   // 시작에 구분자
                "//;\n-1,2,3"   // 테스트 예제

        })
        @DisplayName("잘못된 커스텀 구분자 입력 테스트")
        void invalidCustomDelimiterInputTest(String input) {
            assertThatThrownBy(() -> rule.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(잘못된_커스텀_구분자_형식입니다);
        }
    }


}