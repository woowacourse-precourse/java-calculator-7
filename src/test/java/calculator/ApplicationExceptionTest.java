package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ApplicationExceptionTest extends NsTest {

    static Stream<ExceptionArgument> ms1() {
        return Stream.of(
                ExceptionArgument.of("///;\\n1;2;3", IllegalArgumentException.class),
                ExceptionArgument.of("1//.\\n1.2:3", IllegalArgumentException.class),
                ExceptionArgument.of("a//;\\n1;2;3;4;5", IllegalArgumentException.class),
                ExceptionArgument.of("'//.\\n1.2:3:4:5", IllegalArgumentException.class)
        );
    }

    static Stream<ExceptionArgument> ms2() {
        return Stream.of(
                ExceptionArgument.of("//1\\n1;2;3", IllegalArgumentException.class),
                ExceptionArgument.of("//1a\\n1;2;3", IllegalArgumentException.class),
                ExceptionArgument.of("//a1\\n1;2;3", IllegalArgumentException.class),
                ExceptionArgument.of("//123\\n1;2;3", IllegalArgumentException.class)
        );
    }

    static Stream<ExceptionArgument> ms3() {
        return Stream.of(
                ExceptionArgument.of("//a\\n1;2;3", IllegalArgumentException.class),
                ExceptionArgument.of("//a\\n1;2;3;4;5", IllegalArgumentException.class),
                ExceptionArgument.of("//a\\n1;2;3;4;5;6", IllegalArgumentException.class),
                ExceptionArgument.of("//a\\n1;2;3;4;5;6;7", IllegalArgumentException.class),
                ExceptionArgument.of("1,-8", IllegalArgumentException.class),
                ExceptionArgument.of("-8,1", IllegalArgumentException.class)
        );
    }

    static Stream<ExceptionArgument> ms4() {
        return Stream.of(
                ExceptionArgument.of("//\\a\\n1;2;3", IllegalArgumentException.class),
                ExceptionArgument.of("//\\b\\n1;2;3;4;5", IllegalArgumentException.class),
                ExceptionArgument.of("//\\c\\n1;2;3;4;5;6", IllegalArgumentException.class),
                ExceptionArgument.of("//\\;\\n1;2;3;4;5;6;7", IllegalArgumentException.class)
        );
    }

    static Stream<ExceptionArgument> ms5() {
        return Stream.of(
                ExceptionArgument.of("//\\n;\\n;2;3", IllegalArgumentException.class),
                ExceptionArgument.of("//\\n;\\n1;;3", IllegalArgumentException.class),
                ExceptionArgument.of("//\\n;\\n1;2;", IllegalArgumentException.class),
                ExceptionArgument.of("//\\n;\\n1;2;3;", IllegalArgumentException.class)
        );
    }

    static Stream<ExceptionArgument> ms6() {
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;

        return Stream.of(
                createExceptionArgument((long) maxInt + 1),
                createExceptionArgument((long) minInt - 1),
                createExceptionArgument(maxInt / 2, maxInt / 2, 2),
                createExceptionArgument(minInt / 2, minInt / 2 - 2)
        );
    }

    private static ExceptionArgument createExceptionArgument(long value) {
        return ExceptionArgument.of(String.valueOf(value), IllegalArgumentException.class);
    }

    private static ExceptionArgument createExceptionArgument(int... values) {
        String joinedValues = Arrays.stream(values)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        return ExceptionArgument.of(joinedValues, IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "예외 매개변수: {0}")
    @MethodSource("ms1")
    void 커스텀_구분자가_있는데_커스텀_구분자_앞에_다른_문자가_있는_경우_예외_발생_MS1(ExceptionArgument argument) {
        runParameterizedExceptionTest(argument);
    }

    @ParameterizedTest(name = "예외 매개변수")
    @MethodSource("ms2")
    void 커스텀_구분자_사이_숫자_포함_시_예외_발생_MS2(ExceptionArgument argument) {
        runParameterizedExceptionTest(argument);
    }

    @ParameterizedTest(name = "예외 매개변수: {0}")
    @MethodSource("ms3")
    void 커스텀_구분자로_명시하지_않은_문자_사용_시_예외_발생_MS3(ExceptionArgument argument) {
        runParameterizedExceptionTest(argument);
    }

    @ParameterizedTest(name = "예외 매개변수: {0}")
    @MethodSource("ms4")
    void 커스텀_구분자에_이스케이프_문자가_포함된_경우_예외_발생_MS4(ExceptionArgument argument) {
        runParameterizedExceptionTest(argument);
    }

    @ParameterizedTest(name = "예외 매개변수: {0}")
    @MethodSource("ms5")
    void 커스텀_구분자_내부에_값이_없는_경우_예외_발생_MS5(ExceptionArgument argument) {
        runParameterizedExceptionTest(argument);
    }

    @ParameterizedTest(name = "예외 매개변수: {0}")
    @MethodSource("ms6")
    void 정수의_범위를_벗어나는_경우_예외_발생(ExceptionArgument argument) {
        runParameterizedExceptionTest(argument);
    }

    void runParameterizedExceptionTest(ExceptionArgument argument) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(argument.input))
                        .isInstanceOf(argument.expected)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    private record ExceptionArgument(String input, Class<? extends Exception> expected) {

        public static ExceptionArgument of(String input, Class<? extends Exception> expected) {
            return new ExceptionArgument(input, expected);
        }

        @Override
        public String toString() {
            return "{ input='" + input + "', expected=" + expected + " }";
        }
    }
}
