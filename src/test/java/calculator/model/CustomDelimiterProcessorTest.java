package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.constant.ExceptionMessage;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CustomDelimiterProcessorTest {

    CustomDelimiterProcessor customDelimiterProcessor = new CustomDelimiterProcessor();
    Delimiters delimiters = new Delimiters();

    @Test
    void 커스텀_구분자_추가() {
        customDelimiterProcessor.addCustomDelimiters("//%\\n//#\\n1%2", delimiters);
        assertThat(delimiters.getDelimiters()).
                isEqualTo(Arrays.asList(new Character[]{',', ':', '%', '#'}));
    }

    @Test
    void 커스텀_구분자_지정하지_않는_경우() {
        String inputString = "5,3:2";
        assertThat(inputString)
                .isEqualTo(customDelimiterProcessor.addCustomDelimiters("5,3:2", delimiters));
        assertThat(delimiters.getDelimiters()).
                isEqualTo(Arrays.asList(new Character[]{',', ':'}));
    }

    @Test
    void 남아있는_문자열이_충분하지_않으면_예외() {
        assertThatThrownBy(() ->
                customDelimiterProcessor.addCustomDelimiters("//$n", delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CUSTOM_DELIMITER_FORMAT_LENGTH_EXCEPTION);
    }

    @Test
    void 커스텀_구분자_앞부분_포맷_예외() {
        assertThatThrownBy(() ->
                customDelimiterProcessor.addCustomDelimiters("/%$\\n5,3", delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CUSTOM_DELIMITER_FIRST_FORMAT_EXCEPTION);
    }

    @Test
    void 커스텀_구분자_뒷부분_포맷_예외() {
        assertThatThrownBy(() ->
                customDelimiterProcessor.addCustomDelimiters("//$\\%5,3", delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CUSTOM_DELIMITER_LAST_FORMAT_EXCEPTION);
    }
}