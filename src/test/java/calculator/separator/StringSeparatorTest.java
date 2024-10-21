package calculator.separator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class StringSeparatorTest {

    StringSeparator stringSeparator;

    @Test
    public void 커스텀_구분자_지정을_확인() throws Exception {
        //given
        String inputString = "//?\\n3?2:4";
        stringSeparator = new StringSeparator(inputString);

        //when
        boolean isCustomDelimiters = stringSeparator.validCustomDelimiters();

        //then
        assertThat(isCustomDelimiters).isTrue();
    }

    @Test
    public void 커스텀_구분자_추출() throws Exception {
        //given
        String inputString = "//?\\n3?2:4";
        stringSeparator = new StringSeparator(inputString);

        //when
        String extractedCustomDelimiters = stringSeparator.extractCustomDelimiters();

        //then
        assertThat(extractedCustomDelimiters).isEqualTo("?");
    }


    @Test
    public void 추출된_커스텀_구분자를_기본_구분자에_추가() throws Exception {
        //given
        stringSeparator = new StringSeparator();
        String customDelimiters = "?";

        //when
        String delimiters = stringSeparator.addCustomDelimiters(customDelimiters);

        //then
        assertThat(delimiters).contains(customDelimiters);
    }


    @Test
    public void 입력_문자열에서_커스텀_구분자_분리() throws Exception {
        //given
        String calculatableString = "3?2:4";
        String inputString = "//?\\n" + calculatableString;
        stringSeparator = new StringSeparator(inputString);

        //when
        String resultCalculatableString = stringSeparator.splitCustomDelimiters();

        //then
        assertThat(resultCalculatableString).isEqualTo(calculatableString);
    }


    @Test
    public void 커스텀_구분자_사용() throws Exception {
        //given
        String calculatableString = "3?2:4";
        String inputString = "//?\\n" + calculatableString;
        stringSeparator = new StringSeparator(inputString);

        //when
        String resultCalculatableString = stringSeparator.separateCustomDelimiter();

        //then
        assertThat(resultCalculatableString).isEqualTo(calculatableString);
    }


    @Test
    public void 입력된_문자열을_지정된_구분자를_기준으로_분리() throws Exception {
        //given
        List<String> strings = Arrays.asList("3", "4", "2");
        String inputString = "3:4,2";
        stringSeparator = new StringSeparator(inputString);

        //when
        List<String> result = stringSeparator.splitBasicStringWithDelimiters();

        //then
        assertThat(result).isEqualTo(strings);
    }

}