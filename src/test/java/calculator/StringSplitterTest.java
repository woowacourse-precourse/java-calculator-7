package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitterTest {

    @Test
    @DisplayName("기본 구분자를 활용하여 분리하는 기능 성공 테스트")
    void splitbyDefaultDelimiterSuccessTest() {
        //given
        String inputString = "1:2,3";
        String[] expectString = {"1","2","3"};
        List<String> expectList = Arrays.asList(expectString);
        //when
        List<String> splitValues = StringSplitter.SplitbyDefaultDelimiter(inputString);

        //then
        assertThat(splitValues).isEqualTo(expectList);
    }
    @Test
    @DisplayName("커스텀 구분자를 활용하여 분리하는 기능 성공 테스트")
    void splitbyCustomDelimiterSuccessTest() {
        //given
        String inputString = "//#\\n12#13#14";
        String[] expectString = {"12","13","14"};
        List<String> expectList = Arrays.asList(expectString);
        //when
        List<String> splitValues = StringSplitter.SplitbyCustomDelimiter(inputString);
        //then
        assertThat(splitValues).isEqualTo(expectList);
    }
}