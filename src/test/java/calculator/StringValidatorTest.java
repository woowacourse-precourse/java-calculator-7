package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

@DisplayName("[유닛 테스트] - 문자열 검증")
class StringValidatorTest {

    private final StringValidator stringValidator = new StringValidator();

    @ParameterizedTest
    @ValueSource(strings = {"//\\n1:2:3", "//\\n1,2:3"})
    @DisplayName("커스텀 구분자 선언부에 구분 기호 누락시 예외 발생")
    void missingDelimiterInDeclaration_throwException(String input) {
        //given & when
        Throwable throwable = catchThrowable(() -> stringValidator.validate(input));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("커스텀 구분자 선언부에 구분 기호가 누락되었습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//1\\n1:2:3", "//^2\\n1,2:3"})
    @DisplayName("커스텀 구분자에 숫자 포함시 예외 발생")
    void customDelimiterContainsNumber_throwException(String input) {
        //given & when
        Throwable throwable = catchThrowable(() -> stringValidator.validate(input));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("커스텀 구분자는 숫자를 제외한 문자만 사용 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1)2:3", "//^\n1^2)3"})
    @DisplayName("구분자를 아닌 문자 입력 시 예외 발생")
    void inputNonDelimiterCharacter_throwException(String input) {
        //given & when
        Throwable throwable = catchThrowable(() -> stringValidator.validate(input));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("구분자를 제외한 문자는 포함될 수 없습니다.");
    }
}