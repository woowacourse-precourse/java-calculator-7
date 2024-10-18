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
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "//@\\n1@2@3", "//@\\n//@\\n1@2@3"})
    void get_input_test(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String result = Calculator.get_input();
        System.out.println(result);
        assertSimpleTest(() ->
                assertThat(result).isEqualTo(input)
        );
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> parseTestCases() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("1,2,3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                org.junit.jupiter.params.provider.Arguments.of("", new ArrayList<Integer>()),
                org.junit.jupiter.params.provider.Arguments.of(
                        "//@\n1@2@3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                org.junit.jupiter.params.provider.Arguments.of(
                        "//@\n1@2,3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                org.junit.jupiter.params.provider.Arguments.of(
                        "//@\n1@2:3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                org.junit.jupiter.params.provider.Arguments.of(
                        "//@\n//@\n1@2,3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                org.junit.jupiter.params.provider.Arguments.of(
                        "//@\n//;\n1;2@3", new ArrayList<Integer>(Arrays.asList(1, 2, 3))),
                org.junit.jupiter.params.provider.Arguments.of(
                        "//@\n1@2@3", new ArrayList<Integer>(Arrays.asList(1, 2, 3)))
        );
    }


    //parse 정상입력 테스트
    @ParameterizedTest
    @MethodSource("parseTestCases")
    void parse_test(String input, ArrayList<Integer> expected) {
        assertThat(Calculator.parse(input)).isEqualTo(expected);
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> parseExceptionTestCases() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("-1,2,3"),
                org.junit.jupiter.params.provider.Arguments.of("1,a,3"),
                org.junit.jupiter.params.provider.Arguments.of("asdf"),
                org.junit.jupiter.params.provider.Arguments.of("1@2@3"),
                org.junit.jupiter.params.provider.Arguments.of("//@1@2@3"),
                org.junit.jupiter.params.provider.Arguments.of("//@\n//1,2,3")
        );
    }

    //parse 비정상입력 테스트
    @ParameterizedTest
    @MethodSource("parseExceptionTestCases")
    void parse_ExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> Calculator.parse(input));
    }

}
