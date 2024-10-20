package calculator.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputStringProcessorTest {


    @ParameterizedTest
    @MethodSource("provideInputStrAndIfContainsCustomSeparator")
    void 문자열에_커스텀_구분자가_존재하는지_확인하는_테스트(String inputStr, boolean hasCustomSeparator) {
        InputStringProcessor inputStringProcessor = new InputStringProcessor();
        assertThat(inputStringProcessor.checkIfInputStringContainsSeparator(inputStr)).isEqualTo(hasCustomSeparator);
    }

    private static Stream<Arguments> provideInputStrAndIfContainsCustomSeparator() {
        return Stream.of(
                Arguments.of("12345", false),
                Arguments.of("123", false),
                Arguments.of("//12345", false),
                Arguments.of("123\n:,5", false),
                Arguments.of("//+\1234:,", false),
                Arguments.of("//,\n12,3+4:5", true),
                Arguments.of("//:\n12,3+4:5", true),
                Arguments.of("//+\n12,3+4:5", true),
                Arguments.of("//-\n12,3+4:5", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputStrAndExpectedSeparators")
    void 구분자_리스트를_만드는_테스트(String inputStr, boolean hasCustomSeparator, Set<Character> expectedSeparators) {
        InputStringProcessor inputStringProcessor = new InputStringProcessor();
        assertThat(inputStringProcessor.getSeparatorList(hasCustomSeparator, inputStr)).isEqualTo(expectedSeparators);
    }

    private static Stream<Arguments> provideInputStrAndExpectedSeparators() {
        Set<Character> defaultSeparators = Set.of(':', ',');
        return Stream.of(
                Arguments.of("12345", false, defaultSeparators),
                Arguments.of("123", false, defaultSeparators),
                Arguments.of("//12345", false, defaultSeparators),
                Arguments.of("123\n:,5", false, defaultSeparators),
                Arguments.of("//+\1234:,", false, defaultSeparators),
                Arguments.of("//:\n12,3+4:5", true, defaultSeparators),
                Arguments.of("//,\n12,3+4:5", true, defaultSeparators),
                Arguments.of("//+\n12,3+4:5", true, Set.of(':', ',', '+')),
                Arguments.of("//-\n12,3+4:5", true, Set.of(':', ',', '-'))
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputStrAndExpectedSlicedStr")
    void 커스텀_문자열을_포함하는_경우_이를_제거하고_그렇지_않다면_문자열을_그대로_반환하는_테스트(String inputStr, boolean hasCustomSeparator,
                                                            String slicedStr) {
        InputStringProcessor inputStringProcessor = new InputStringProcessor();
        assertThat(inputStringProcessor.removeSeparatorForm(hasCustomSeparator, inputStr)).isEqualTo(slicedStr);
    }

    private static Stream<Arguments> provideInputStrAndExpectedSlicedStr() {
        return Stream.of(
                Arguments.of("12345", false, "12345"),
                Arguments.of("123", false, "123"),
                Arguments.of("//12345", false, "//12345"),
                Arguments.of("123\n:,5", false, "123\n:,5"),
                Arguments.of("//+\1234:,", false, "//+\1234:,"),
                Arguments.of("//:\n12,3+4:5", true, "12,3+4:5"),
                Arguments.of("//,\n12,3+4:5", true, "12,3+4:5"),
                Arguments.of("//+\n12,3+4:5", true, "12,3+4:5"),
                Arguments.of("//-\n12,3+4:5", true, "12,3+4:5")
        );
    }

    @ParameterizedTest
    @MethodSource("provideSlicedStrAndSplitStrList")
    void 문자열에서_구분자를_기준으로_잘라서_리스트를_반환하는_테스트(String slicedStr, Set<Character> separators, List<String> strList) {
        InputStringProcessor inputStringProcessor = new InputStringProcessor();
        assertThat(inputStringProcessor.splitStrBySeparator(separators, slicedStr)).isEqualTo(strList);
    }

    private static Stream<Arguments> provideSlicedStrAndSplitStrList() {
        Set<Character> defaultSeparators = Set.of(':', ',');
        return Stream.of(
                Arguments.of("12345", defaultSeparators, List.of("12345")),
                Arguments.of("123", defaultSeparators, List.of("123")),
                Arguments.of("//12345", defaultSeparators, List.of("//12345")),
                Arguments.of("123\n:,5", defaultSeparators, List.of("123\n", "5")),
                Arguments.of("//+\1234:,", defaultSeparators, List.of("//+\1234")),
                Arguments.of("12,3-4:5", defaultSeparators, List.of("12", "3-4", "5")),
                Arguments.of("12,!@3#4$53+4:590", Set.of(':', ',', '!', '@', '#', '+', '$'),
                        List.of("12", "3", "4", "53", "4", "590")),
                Arguments.of("12,3+4:5", Set.of(':', ',', '+'), List.of("12", "3", "4", "5")),
                Arguments.of("2,3+-`1=-09*()&%$4:5", Set.of(':', ',', '+', '-', '`', '=', '*', '(', ')', '&', '%', '$'),
                        List.of("2", "3", "1", "09", "4", "5"))
        );
    }

}