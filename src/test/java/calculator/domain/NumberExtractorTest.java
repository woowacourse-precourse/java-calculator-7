package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberExtractorTest {

    private NumberExtractor numberExtractor;

    @BeforeEach
    void setUp() {
        numberExtractor = new NumberExtractor(
                new StringSplitter(new CustomDelimiterExtractor()));
    }

    @DisplayName("구분자로 나뉜 숫자를 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideInputAndSizeAndNumbers")
    void getNumbersWithoutDelimiters(String stringToAdd, int expectedSize, List<Integer> expectedNumbers) {
        //given
        //when
        List<Integer> numbers = numberExtractor.getNumbers(stringToAdd);
        //then
        assertThat(numbers).hasSize(expectedSize);
        assertThat(numbers).containsExactlyElementsOf(expectedNumbers);
    }

    private static Stream<Arguments> provideInputAndSizeAndNumbers() {
        return Stream.of(
                Arguments.of("1,2,3", 3, List.of(1, 2, 3)),
                Arguments.of("10:20,30:40", 4, List.of(10, 20, 30, 40)),
                Arguments.of("//%\\n1%5,55:40%2,3%7:9", 8, List.of(1, 5, 55, 40, 2, 3, 7, 9))
        );
    }
}