package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CustomDelimiterProcessorTest {

    @Test
    void 커스텀_구분자_추가() {
        CustomDelimiterProcessor customDelimiterProcessor = new CustomDelimiterProcessor();
        Delimiters delimiters = new Delimiters();
        customDelimiterProcessor.addCustomDelimiters("//%\\n//#\\n1%2", delimiters);
        assertThat(delimiters.getDelimiters()).
                isEqualTo(Arrays.asList(new Character[]{',', ':', '%', '#'}));
    }
}