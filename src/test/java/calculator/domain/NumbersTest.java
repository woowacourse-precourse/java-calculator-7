package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.util.convertor.InputStringConvertor;
import calculator.util.convertor.StringConvertor;
import calculator.util.parser.InputStringParser;
import calculator.util.parser.StringParser;
import calculator.util.validator.InputStringValidator;
import calculator.util.validator.StringValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

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
    @DisplayName("숫자 배열 사이즈 반환")
    void getSizeTest() throws Exception {
        //given
        final String inputString = "1,20,3";
        final int size = 3;
        final Numbers<Integer> numbers = Numbers.ofInteger(inputString, inputStringConvertor, inputStringParser,
                inputStringValidator);

        //when
        //then
        assertThat(numbers.getSize()).isEqualTo(size);

    }

    @Test
    @DisplayName("인덱스에 따른 숫자 반환")
    void getNumberTest() throws Exception {
        //given
        final String inputString = "30,1,2";
        final int idx = 0;
        final int number = 30;
        final Numbers<Integer> numbers = Numbers.ofInteger(inputString, inputStringConvertor, inputStringParser,
                inputStringValidator);

        //when
        //then
        assertThat(numbers.getNumber(idx)).isEqualTo(number);

    }

}