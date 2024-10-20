package calculator.util.convertor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputStringConvertorTest {

    @Test
    @DisplayName("문자열을 구분자를 사용하여 정수형 리스트로 변환한다.")
    void convertToListWithDelimiter() throws Exception {
        //given
        final String delimiter = "[;: .,]";
        final String str = "1;2:3 4.5,6";
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final StringConvertor<Integer> inputStringConvertor = new InputStringConvertor();
        //when
        final List<Integer> convertedStr = inputStringConvertor.convertToListWithDelimiter(str, delimiter);
        //then
        assertThat(convertedStr).isEqualTo(numbers);

    }

}