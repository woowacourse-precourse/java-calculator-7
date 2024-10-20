package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.util.StringSplitter;
import calculator.validator.InputValidator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringCalculatorServiceTest {

    private StringCalculatorService calculator;

    @BeforeEach
    void setUp() {
        InputValidator inputValidator = new InputValidator();
        StringSplitter stringSplitter = new StringSplitter();
        calculator = new StringCalculatorService(inputValidator, stringSplitter);
    }

    @DisplayName("추가된 기능 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @MethodSource("calculatorTestProvider")
    void checkCalculatorExtendedFeatures(String input, Integer expectedResult,
                                         Class<? extends Exception> expectedException) {
        if (expectedException != null) {
            assertThrows(expectedException, () -> calculator.calculate(input));
        } else {
            assertThat(calculator.calculate(input)).isEqualTo(expectedResult);
        }
    }

    static List<Arguments> calculatorTestProvider() {
        List<Arguments> argumentsList = new ArrayList<>();

        argumentsList.add(Arguments.arguments("", 0, null));
        argumentsList.add(Arguments.arguments(" ", 0, null));
        argumentsList.add(Arguments.arguments("1,2,3", 6, null));
        argumentsList.add(Arguments.arguments("1,,2", 3, null));
        argumentsList.add(Arguments.arguments("1," + "9".repeat(1000), null, IllegalArgumentException.class));
        argumentsList.add(Arguments.arguments("2147483647,1", null, IllegalArgumentException.class));
        argumentsList.add(Arguments.arguments("//abc\n1abc2abc3", 6, null));
        argumentsList.add(Arguments.arguments("//@\n1@2@3", 6, null));

        return argumentsList;
    }
}