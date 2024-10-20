package calculator.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.common.exception.InvalidInputStrException;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    void setUp() {
        inputParser = new InputParser();
    }

    @ParameterizedTest
    @CsvSource({
            " 1 3",
            "123 5",
            "'        '",
            "12345 '"
    })
    void 잘못된_사용자_입력이_들어왔을때_예외를_발생시키는_테스트(String inputStr) {
        assertThatThrownBy(() -> inputParser.validateInputStr(inputStr))
                .isInstanceOf(InvalidInputStrException.class);
    }


    @ParameterizedTest
    @MethodSource("provideInputStrAndIfContainsCustomSeparator")
    void 문자열에_커스텀_구분자가_존재하는지_확인하는_테스트(String inputStr, boolean hasCustomSeparator) {
        assertThat(inputParser.checkIfInputStringContainsSeparator(inputStr)).isEqualTo(hasCustomSeparator);
    }

    private static Stream<Arguments> provideInputStrAndIfContainsCustomSeparator() {
        return Stream.of(
                Arguments.of("12345", false),
                Arguments.of("123", false),
                Arguments.of("//12345", false),
                Arguments.of("123\n:,5", false),
                Arguments.of("//+\1234:,", false),
                Arguments.of("//,\\n12,3+4:5", true),
                Arguments.of("//:\\n12,3+4:5", true),
                Arguments.of("//+\\n12,3+4:5", true),
                Arguments.of("//-\\n12,3+4:5", true),
                Arguments.of("//;\\n1", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputStrAndExpectedSeparators")
    void 구분자_리스트를_만드는_테스트(String inputStr, boolean hasCustomSeparator, Set<Character> expectedSeparators) {
        assertThat(inputParser.getSeparatorList(hasCustomSeparator, inputStr)).isEqualTo(expectedSeparators);
    }

    private static Stream<Arguments> provideInputStrAndExpectedSeparators() {
        Set<Character> defaultSeparators = Set.of(':', ',');
        return Stream.of(
                Arguments.of("12345", false, defaultSeparators),
                Arguments.of("123", false, defaultSeparators),
                Arguments.of("//12345", false, defaultSeparators),
                Arguments.of("123\n:,5", false, defaultSeparators),
                Arguments.of("//+\1234:,", false, defaultSeparators),
                Arguments.of("//:\\n12,3+4:5", true, defaultSeparators),
                Arguments.of("//,\\n12,3+4:5", true, defaultSeparators),
                Arguments.of("//+\\n12,3+4:5", true, Set.of(':', ',', '+')),
                Arguments.of("//-\\n12,3+4:5", true, Set.of(':', ',', '-'))
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputStrAndExpectedSlicedStr")
    void 커스텀_문자열을_포함하는_경우_이를_제거하고_그렇지_않다면_문자열을_그대로_반환하는_테스트(String inputStr, boolean hasCustomSeparator,
                                                            String slicedStr) {
        assertThat(inputParser.removeSeparatorForm(hasCustomSeparator, inputStr)).isEqualTo(slicedStr);
    }

    private static Stream<Arguments> provideInputStrAndExpectedSlicedStr() {
        return Stream.of(
                Arguments.of("12345", false, "12345"),
                Arguments.of("123", false, "123"),
                Arguments.of("//12345", false, "//12345"),
                Arguments.of("123\n:,5", false, "123\n:,5"),
                Arguments.of("//+\1234:,", false, "//+\1234:,"),
                Arguments.of("//;\\n1", true, "1"),
                Arguments.of("//:\\n12,3+4:5", true, "12,3+4:5"),
                Arguments.of("//,\\n12,3+4:5", true, "12,3+4:5"),
                Arguments.of("//+\\n12,3+4:5", true, "12,3+4:5"),
                Arguments.of("//-\\n12,3+4:5", true, "12,3+4:5")
        );
    }

    @ParameterizedTest
    @MethodSource("provideSlicedStrAndSplitStrList")
    void 문자열에서_구분자를_기준으로_자르는_테스트(String slicedStr, Set<Character> separators, String[] strList) {
        assertThat(inputParser.splitStrBySeparator(separators, slicedStr)).isEqualTo(strList);
    }

    private static Stream<Arguments> provideSlicedStrAndSplitStrList() {
        Set<Character> defaultSeparators = Set.of(':', ',');
        return Stream.of(
                Arguments.of("12345", defaultSeparators, new String[]{"12345"}),
                Arguments.of("123", defaultSeparators, new String[]{"123"}),
                Arguments.of("//12345", defaultSeparators, new String[]{"//12345"}),
                Arguments.of("123\n:,5", defaultSeparators, new String[]{"123\n", "5"}),
                Arguments.of("//+\1234:,", defaultSeparators, new String[]{"//+\1234"}),
                Arguments.of("12,3-4:5", defaultSeparators, new String[]{"12", "3-4", "5"}),
                Arguments.of("1-234-", Set.of(':', ',', '-'), new String[]{"1", "234"}),
                Arguments.of("1+234+", Set.of(':', ',', '+'), new String[]{"1", "234"}),
                Arguments.of("1+-234-5+6", Set.of(':', ',', '-'), new String[]{"1+", "234", "5+6"}),
                Arguments.of("12,3+4:5", Set.of(':', ',', '+'), new String[]{"12", "3", "4", "5"})
        );
    }

}