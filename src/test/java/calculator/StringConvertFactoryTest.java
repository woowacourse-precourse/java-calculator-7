package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[유닛 테스트] - 입력 문자열 변환기")
class StringConvertFactoryTest {

    private final NumberParserFactory stringConvertFactory = new NumberParserFactory();

    @ParameterizedTest
    @EmptySource
    @DisplayName("빈 문자열 - 빈 문자열 입력시 0 반환")
    void emptyString_returnZero(String input) {
        //given & when
        String[] result = stringConvertFactory.parseString(input);

        //then
        assertThat(result[0]).isEqualTo("0");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "100", "122052"})
    @DisplayName("정수 문자열 - 양의 정수 입력 시 입력 값 그대로 반환")
    void positiveInteger_returnInput(String input) {
        //given & when
        String[] result = stringConvertFactory.parseString(input);

        //then
        assertThat(result[0]).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1:2:3", "1,2,3"})
    @DisplayName("구분자 선언 포함 - 구분자 선언이 없는 문자열의 경우 기본 구분자로 분할")
    void noDelimiterDeclaration_splitByDefaultDelimiter(String input) {
        //given & when
        String[] result = stringConvertFactory.parseString(input);

        //then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//^\\n1^2^3", "//)\\n1)2:3", "//*\\n1,2*3"})
    @DisplayName("구분자 선언 미포함 - 구분자 선언이 있는 문자열의 경우 커스텀 구분자를 포함한 패턴으로 분할")
    void containsDelimiterDeclaration_splitByCustomDelimiterAndDefaultDelimiter(String input) {
        //given & when
        String[] result = stringConvertFactory.parseString(input);

        //then
        assertThat(result).containsExactly("1", "2", "3");
    }
}