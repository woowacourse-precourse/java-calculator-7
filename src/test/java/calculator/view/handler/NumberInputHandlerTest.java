package calculator.view.handler;
import calculator.constant.ErrorMessage;
import calculator.sentence.domain.Sentence;
import calculator.view.input.handler.NumberInputHandler;
import calculator.view.input.service.InputService;
import calculator.view.input.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
public class NumberInputHandlerTest {
    @Test
    @DisplayName("커스텀 구분자 안에 공백이 있을 경우 예외")
    void customSeparatorContainBlankTest() {
        String s = "//\\n1";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 발생 형식에 맞지 않는 입력값");
    }

    @Test
    @DisplayName("커스텀 구분자 안에 정수가 있을 경우 예외")
    void customSeparatorContainNumberTest() {
        String s = "//1\\n1";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 발생 형식에 맞지 않는 입력값");
    }

    @Test
    @DisplayName("커스텀 구분자가 앞에 없을 경우")
    void customSeparatorNotAtStartOfStringTest() {
        String s = "n1//;\\";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 발생 형식에 맞지 않는 입력값");
    }
    @Test
    @DisplayName("커스텀 구분자 양식에 맞지 않을 경우")
    void customSeparatorFormatMismatchTest() {
        String s = "//;\n1";
        String s2 = "/;\\n1";
        String s3 = "/;\n1";

        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);

        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s2))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);

        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s3))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }
    @Test
    @DisplayName("커스텀 구분자외에 다른 구분자가 있을 경우")
    void differentSeparatorThanCustomUsedTest() {
        String s = "//;\\n1;2,3";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }
    @Test
    @DisplayName("기본 구분자 외에 다른 구분자가 있을 경우")
    void differentSeparatorThanDefaultUsedTest() {
        String s = "1,2;3";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }
    @Test
    @DisplayName("문자만 있을 경우")
    void onlyTextTest() {
        String s = "n";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);

        String s2 = "//n\\s";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s2))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }

    @Test
    @DisplayName("정수사이에 구분자가 연속으로 나올경우")
    void repeatedSeparatorsBetweenNumbersTest() {
        String s = "1,2,:3";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);

        String s2 = "//n\\n1n2nn3";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s2))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);

    }

    @Test
    @DisplayName("문자열끝에서 구분자로 끝났을 경우")
    void endsWithSeparatorTest() {
        String s = "1,2:3,";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);

        String s2 = "//n\\n12n3n";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s2))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }

    @Test
    @DisplayName("숫자가 Long.MAX_VALUE 보다 클경우")
    void exceedsLongMaxValueTest() {
        String s = "33213213234123321432142";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MAX_VALUE_ERROR);
    }
    @Test
    @DisplayName("0만 있을 경우")
    void zeroTest() {
        String s = "0";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);
    }
    @Test
    @DisplayName("0이 먼저 나올 경우")
    void startsWithZeroTest() {
        String s = "0,2,3";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);

        String s2 = "//s\\n0s2s3";
        assertThatThrownBy(() -> new NumberInputHandler(new InputTest(s2))
                .receive(Sentence::new))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.REGEX_ERROR);


    }
    @Test
    @DisplayName("공백 일 경우")
    void blankTest() {
        String s = "";
        new NumberInputHandler(new InputTest(s)).receive(Sentence::new);
    }
    @Test
    @DisplayName("숫자만 있을 경우")
    void NumberTest() {
        String s = "123";
        new NumberInputHandler(new InputTest(s)).receive(Sentence::new);
    }
    @Test
    @DisplayName("기본 구분자")
    void defaultSeparatorTest() {
        String s = "1,2,3";
        String s2 = "1,2:3";
        String s3 = "1:2,3";
        String s4 = "1:2:3";
        new NumberInputHandler(new InputTest(s)).receive(Sentence::new);
        new NumberInputHandler(new InputTest(s2)).receive(Sentence::new);
        new NumberInputHandler(new InputTest(s3)).receive(Sentence::new);
        new NumberInputHandler(new InputTest(s4)).receive(Sentence::new);
    }
    @Test
    @DisplayName("커스텀 구분자")
    void customSeparatorTest() {
        String s = "//s\\n1s2s3";
        String s2 = "////s\\n\\n1//s\\n2//s\\n3";
        String s3 = "//test\\n1test2test3";
        String s4 = "//;\\n1;2;3";
        new NumberInputHandler(new InputTest(s)).receive(Sentence::new);
        new NumberInputHandler(new InputTest(s2)).receive(Sentence::new);
        new NumberInputHandler(new InputTest(s3)).receive(Sentence::new);
        new NumberInputHandler(new InputTest(s4)).receive(Sentence::new);
    }



}


class InputTest implements InputService {
    private final String sentence;
    public InputTest(String sentence) {
        this.sentence = sentence;
    }
    @Override
    public String input() {
        InputValidator.validator(sentence);
        return sentence;
    }
}
