package calculator.util.patterns;

import calculator.util.pattern.PatternUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static calculator.util.pattern.PatternUtils.ESCAPE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("PatternUtils 클래스")
public class PatternUtilsTest {

    static Stream<Arguments> provideJoiningInput() {
        return Stream.of(
                Arguments.of(",", List.of("a", "b", "c"), "a,b,c"),
                Arguments.of(";", List.of("a", "b", "c", "d"), "a;b;c;d"),
                Arguments.of("[", List.of("a"), "a"),
                Arguments.of(",", List.of(), "")
        );
    }

    static Stream<Arguments> provideMatchesWithDelimitersIgnoringNumbersInput() {
        return Stream.of(
                Arguments.of("1,2,3", Pattern.compile(","), true),
                Arguments.of("1;2;3", Pattern.compile(","), false),
                Arguments.of("1,2,3", Pattern.compile(";"), false),
                Arguments.of("1+2*3", Pattern.compile("[+*]"), true),
                Arguments.of("1-2*3", Pattern.compile("[+*]"), false),
                Arguments.of("1-2*3", Pattern.compile("[-*]"), true)
        );
    }

    @ParameterizedTest(name = "구분자: {0}, 문자열 리스트: {1}, 기대값: {2}")
    @MethodSource("provideJoiningInput")
    void 구분자를_통해_문자열을_조인한다(String delimiter, List<String> input, String expected) {

        // when
        String actual = PatternUtils.join(delimiter, input);

        // then
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "문자열: {0}, 패턴: {1}, 기대값: {2}")
    @MethodSource("provideMatchesWithDelimitersIgnoringNumbersInput")
    void 숫자인_문자를_제외하고_패턴_매칭을_수행한다(String value, Pattern delimiterPattern, boolean expected) {

        // when
        boolean actual = PatternUtils.matchesWithDelimitersIgnoringNumbers(value, delimiterPattern);

        // then
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "문자열: {0}")
    @ValueSource(strings = {".", "*", "+", "?", "^", "$", "[", "]", "{", "}", "(", ")", "|"})
    void 정규식에_사용되는_특수문자를_이스케이프한다(String specialCharacter) {

        // when
        String result = PatternUtils.escapeSpecialCharacters(specialCharacter);

        // then
        assertEquals(ESCAPE + specialCharacter, result);
    }
}
