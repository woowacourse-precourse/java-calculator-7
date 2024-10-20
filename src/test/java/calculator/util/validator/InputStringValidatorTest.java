package calculator.util.validator;

import static calculator.constant.ErrorType.INVALID_INPUT_FORMAT;
import static calculator.constant.ErrorType.OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import calculator.util.parser.InputStringParser;
import calculator.util.parser.StringParser;
import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputStringValidatorTest {

    private StringValidator inputStringValidator;

    @BeforeEach
    void setUp() {
        final StringParser stringParser = new InputStringParser();
        inputStringValidator = new InputStringValidator(stringParser);
    }

    @ParameterizedTest
    @DisplayName("잘못된 문자열로 인해 예외가 발생한다.")
    @ValueSource(strings = {"///;\\n1;2;3", "\\;/n1,2,3", "1;2:3", "-1,2,3", "//;\\n1;2;//;\\n;3", "//\\n1;2;3",
            "//;;\\n;"})
    void validateFormatFailTest(final String input) throws Exception {
        //given
        //when
        //then
        assertThatThrownBy(() -> inputStringValidator.validateFormat(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INVALID_INPUT_FORMAT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("구분자 n개를 포함한 올바른 문자열은 검증을 통과한다.")
    @ValueSource(strings = {"", "//\\\\n1\\2\\3", "//.\\n.", "1,2:3", "//;\\n1;2;3", "//3\\n1:2,3", "//.\\n1:2:3",
            "// \\n1:2:3", "//''..\\n1''..2''..3", "//..\\n.."})
    void validateFormatSuccessTest(final String input) throws Exception {
        //given
        //when
        //then
        assertDoesNotThrow(() -> inputStringValidator.validateFormat(input));
    }


    @ParameterizedTest
    @DisplayName("사용자가 양의 정수 범위를 벗어난 값을 입력하여 예외가 발생한다.")
    @ValueSource(strings = {"999999999999999999:1:2", "1:2,999999999999999999", "1:0:3"})
    void validateRangeFailTest(final String input) throws Exception {
        //given
        final BigInteger min = BigInteger.valueOf(1);
        final BigInteger max = BigInteger.valueOf(Integer.MAX_VALUE);
        //when
        //then
        assertThatThrownBy(() -> inputStringValidator.validateRange(input, min, max)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(OUT_OF_RANGE.getMessage());
    }


}