package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("[유닛 테스트] - 입력 문자열 변환기")
class StringConvertFactoryTest {

    private final StringConvertFactory stringConvertFactory = new StringConvertFactory();

    @ParameterizedTest
    @EmptySource
    @DisplayName("문자열 입력 - 빈 문자열 입력시 0 반환")
    void emptyString_returnZero(String input) {
        //given & when
        String[] result = stringConvertFactory.parseString(input);

        //then
        assertThat(result[0]).isEqualTo("0");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2","100", "122052"})
    @DisplayName("문자열 입력 - 양의 정수 입력 시 입력 값 그대로 반환")
    void positiveInteger_returnInput(String input) {
        //given & when
        String[] result = stringConvertFactory.parseString(input);

        //then
        assertThat(result[0]).isEqualTo(input);
    }
}