package calculator.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import calculator.util.convertor.InputStringConvertor;
import calculator.util.convertor.StringConvertor;
import calculator.util.parser.InputStringParser;
import calculator.util.parser.StringParser;
import calculator.util.validator.InputStringValidator;
import calculator.util.validator.StringValidator;
import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private StringParser inputStringParser;
    private StringConvertor<Integer> inputStringConvertor;
    private StringValidator inputStringValidator;

    @BeforeEach
    void setUp() {
        inputStringParser = new InputStringParser();
        inputStringConvertor = new InputStringConvertor();
        inputStringValidator = new InputStringValidator(inputStringParser);
    }

    @Test
    @DisplayName("정수 합 연산")
    void sumIntegerTest() throws Exception {
        //given
        final String inputString1 = "//;\\n1,2;3";
        final String inputString2 = "//;\\n;";
        final String inputString3 = "";
        final BigInteger sum1 = BigInteger.valueOf(6);
        final BigInteger sum2 = BigInteger.ZERO;
        final BigInteger sum3 = BigInteger.ZERO;
        final Numbers<Integer> numbers1 = Numbers.ofInteger(inputString1, inputStringConvertor, inputStringParser,
                inputStringValidator);
        final Numbers<Integer> numbers2 = Numbers.ofInteger(inputString2, inputStringConvertor, inputStringParser,
                inputStringValidator);
        final Numbers<Integer> numbers3 = Numbers.ofInteger(inputString3, inputStringConvertor, inputStringParser,
                inputStringValidator);
        final Calculator calculator = new Calculator();

        //when
        final BigInteger result1 = calculator.sumInteger(numbers1);
        final BigInteger result2 = calculator.sumInteger(numbers2);
        final BigInteger result3 = calculator.sumInteger(numbers3);

        //then
        assertAll(
                () -> assertThat(result1).isEqualTo(sum1),
                () -> assertThat(result2).isEqualTo(sum2),
                () -> assertThat(result3).isEqualTo(sum3)
        );
    }

}