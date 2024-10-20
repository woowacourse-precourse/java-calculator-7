package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

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

    @Test
    @DisplayName("기본구분자를 활용하는 문자열 포맷 검증 성공테스트")
    void checkDefaultDelimterFormatSuccessTest() {
        //given
        String[] inputString = {"1:2:3", "123,2:3", "12:333,44"};
        //when
        for (String input : inputString){
            boolean result = Validator.checkDefaultDelimterFormat(input);
            //then
            assertThat(result).isTrue();
        }
    }
    @Test
    @DisplayName("기본구분자를 활용하는 문자열 포맷 검증 실패테스트")
    void checkDefaultDelimterFormatFailTest() {
        //given
        String[] inputStrings = {"1:2:", ":1:2","","a:2:3,","#:3,4","   :  3:43"};
        //when
        for (String input : inputStrings){
            boolean result = Validator.checkDefaultDelimterFormat(input);
            //then
            assertThat(result).isFalse();
        }
    }

    @Test
    @DisplayName("커스텀 구분자를 활용하는 문자열 포맷 검증 성공테스트")
    void checkCustomDelimiterFormatSuccessTest() {
        //given
        String[] inputStrings = {"//;\\n", "//;\\n1;2;3", "//;\\nabc", "//;\\n1;2;31f4b."};
        //when
        for (String input : inputStrings){
            boolean result = Validator.checkCustomDelimiterFormat(input);
            //then
            assertThat(result).isTrue();
        }
    }
    @Test
    @DisplayName("커스텀 구분자를 활용하는 문자열 포맷 검증 실패테스트")
    void checkCustomDelimiterFormatFailTest() {
        //given
        String[] inputStrings = {"/;\\n", ";\\n1;2;3", "//;\nabc", "//;\\1;2;31f4b."};
        //when
        for (String input : inputStrings){
            boolean result = Validator.checkCustomDelimiterFormat(input);
            //then
            assertThat(result).isFalse();
        }
    }
    @Test
    @DisplayName("커스텀 구분자를 지정하는 문자열 뒤로 나오는 본 문자열 포맷 검증 성공테스트")
    void checkRemainStringFormatSuccessTest() {
        //given
        String[] inputStrings = {"1#2#3", "123#2#43"};
        //when
        for (String input : inputStrings){
            boolean result = Validator.checkRemainStringFormat(input, "#");
            //then
            assertThat(result).isTrue();
        }
    }
    @Test
    @DisplayName("커스텀 구분자를 지정하는 문자열 뒤로 나오는 본 문자열 포맷 검증 실패테스트")
    void checkRemainStringFormatFailTest() {
        //given
        String[] inputStrings = {"  ", "1;2;", "1;;2;", "abc", "1;2;31f4b."};
        //when
        for (String input : inputStrings){
            boolean result = Validator.checkRemainStringFormat(input, ";");
            //then
            assertThat(result).isFalse();
        }
    }
}
