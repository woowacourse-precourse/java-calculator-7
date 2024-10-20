package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    private StringSplitter stringSplitter;

    @BeforeEach
    void setUp() {
        stringSplitter = new StringSplitter(new CustomDelimiterExtractor());
    }

    @DisplayName("구분자에 따라 문자열을 구분한다.")
    @ParameterizedTest
    @MethodSource("provideInputAndSizeAndNumberStrings")
    void splitStringByDelimiter(String stringToAdd, int expectedSize, String[] expectedNumbers) {
        //given
        //when
        String[] numberStrings = stringSplitter.getNumberStringsToAdd(stringToAdd);
        //then
        assertThat(numberStrings.length).isEqualTo(expectedSize);
        assertThat(numberStrings).containsExactly(expectedNumbers);
    }

    private static Stream<Arguments> provideInputAndSizeAndNumberStrings() {
        return Stream.of(
                Arguments.of("4,5:6", 3, new String[]{"4", "5", "6"}),
                Arguments.of("//$\\n40$50$50$60", 4, new String[]{"40", "50", "50", "60"}),
                Arguments.of("//&\\n10&1,2:33&7,5", 6, new String[]{"10", "1", "2", "33", "7", "5"})
        );
    }

}