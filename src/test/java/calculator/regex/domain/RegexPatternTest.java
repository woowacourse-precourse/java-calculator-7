package calculator.regex.domain;
import calculator.validator.constant.ErrorMessage;
import calculator.sentence.dto.Sentence;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class RegexPatternTest {
    @Test
    void extractNumberTest() {
        String s = "1,2,3";
        String s2 = "//;\\n1;2;3"; List<String> excepted = List.of("1","2","3");
        String s3 = "";

        assertThat(RegexPattern.extractNumberProcess(s)).isEqualTo(excepted);
        assertThat(RegexPattern.extractNumberProcess(s2)).isEqualTo(excepted);
        assertThat(RegexPattern.extractNumberProcess(s3)).isEqualTo(List.of(""));
    }
    @Test
    void customSeparatorDouble() {
        Sentence sentence = new Sentence("//s\\n7.0s0.1231s0.21312s0.2134");
        assertThat(RegexPattern.getRegexPattern(sentence)).isEqualTo(RegexPattern.CUSTOM_SEPARATOR_DOUBLE);

        Sentence exceptionSentence = new Sentence("//;\\n0;0");
        assertThatThrownBy(() -> RegexPattern.getRegexPattern(exceptionSentence))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNEXPECTED_ERROR);

    }
    @Test
    void customSeparator() {
        Sentence sentence = new Sentence("//.\\n10.12310.213120.2134");
        assertThat(RegexPattern.getRegexPattern(sentence)).isEqualTo(RegexPattern.CUSTOM_SEPARATOR);

        Sentence exceptionSentence = new Sentence("//s\\n0s0");
        assertThatThrownBy(() -> RegexPattern.getRegexPattern(exceptionSentence))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNEXPECTED_ERROR);

    }
    @Test
    void defaultSeparator() {
        Sentence sentence = new Sentence("1:2,3");
        assertThat(RegexPattern.getRegexPattern(sentence)).isEqualTo(RegexPattern.DEFAULT_SEPARATOR);

        Sentence exceptionSentence = new Sentence("0,1:2");
        assertThatThrownBy(() -> RegexPattern.getRegexPattern(exceptionSentence))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNEXPECTED_ERROR);
    }
    @Test
    void defaultSeparatorDouble() {
        Sentence sentence = new Sentence("7.123,0.12321:312.3123");
        assertThat(RegexPattern.getRegexPattern(sentence)).isEqualTo(RegexPattern.DEFAULT_DOUBLE_SEPARATOR);

        Sentence exceptionSentence = new Sentence("0.0");
        assertThatThrownBy(() -> RegexPattern.getRegexPattern(exceptionSentence))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNEXPECTED_ERROR);

    }
    @Test
    void blank() {
        Sentence sentence = new Sentence("");
        assertThat(RegexPattern.getRegexPattern(sentence)).isEqualTo(RegexPattern.BLANK);

    }
}
