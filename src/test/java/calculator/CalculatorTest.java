package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class CalculatorTest {

    static Stream<Arguments> getInputTestCases() {
        return Stream.of(
                Arguments.of("1,2,3"),
                Arguments.of("//@\\n1@2@3"),
                Arguments.of("//@\\n//@\\n1@2@3")
        );
    }

    @ParameterizedTest
    @MethodSource("getInputTestCases")
    void getInputTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String result = Calculator.getInput();
        System.out.println(result);
        assertSimpleTest(() ->
                assertThat(result).isEqualTo(input)
        );
    }

    static Stream<Arguments> parseTestCases() {
        return Stream.of(
                Arguments.of("1,2,3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                Arguments.of("", new ArrayList<Integer>()),
                Arguments.of("//@\\n1@2@3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                Arguments.of("//@\\n1@2,3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                Arguments.of("//@\\n1@2:3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                Arguments.of("//@\\n//@\\n1@2,3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                Arguments.of("//@\\n//;\\n1;2@3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                Arguments.of("//@\\n1@2@3", new ArrayList<Integer>(Arrays.asList(1, 2, 3)))
        );
    }


    //parse 정상입력 테스트
    @ParameterizedTest
    @MethodSource("parseTestCases")
    void parseTest(String input, ArrayList<Integer> expected) {
        assertThat(Calculator.parse(input)).isEqualTo(expected);
    }

    static Stream<Arguments> parseExceptionTestCases() {
        return Stream.of(
                Arguments.of("-1,2,3"),
                Arguments.of("1,a,3"),
                Arguments.of("asdf"),
                Arguments.of("1@2@3"),
                Arguments.of("//@1@2@3"),
                Arguments.of("//@\\n//1,2,3")
        );
    }

    //parse 비정상입력 테스트
    @ParameterizedTest
    @MethodSource("parseExceptionTestCases")
    void parseExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> Calculator.parse(input));
    }

    static Stream<Arguments> addTestCases() {
        return Stream.of(
                Arguments.of(Calculator.parse("1,2,3"), 6),
                Arguments.of(Calculator.parse(""), 0),
                Arguments.of(Calculator.parse("//@\\n1@2@3"), 6),
                Arguments.of(Calculator.parse("//@\\n1@2,3"), 6),
                Arguments.of(Calculator.parse("//@\\n1@2:3"), 6),
                Arguments.of(Calculator.parse("//@\\n//@\\n1@2,3"), 6),
                Arguments.of(Calculator.parse("//@\\n//;\\n1;2@3"), 6),
                Arguments.of(Calculator.parse("//@\\n1@2@3"), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("addTestCases")
    void addTest(ArrayList<Integer> input, int expected) {
        assertThat(Calculator.add(input)).isEqualTo(expected);
    }

}
