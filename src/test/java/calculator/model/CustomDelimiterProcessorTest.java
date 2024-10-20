package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
    void 커스텀_구분자_앞부분_포맷_예외() {
        assertThatThrownBy(() ->
                customDelimiterProcessor.addCustomDelimiters("/%$\\n5,3", delimiters))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_뒷부분_포맷_예외() {
        assertThatThrownBy(() ->
                customDelimiterProcessor.addCustomDelimiters("//$\\%5,3", delimiters))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_길이_포맷_예외() {
        assertThatThrownBy(() ->
                customDelimiterProcessor.addCustomDelimiters("//%$\\n5,3", delimiters))
                .isInstanceOf(IllegalArgumentException.class);
    }
}