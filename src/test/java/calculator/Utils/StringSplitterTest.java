package calculator.Utils;

import static calculator.Constants.DelimiterConstants.BASIC_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.Application;
import calculator.Model.Delimiter;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StringSplitterTest extends NsTest {

    @Test
    @DisplayName("주어진 문자열을 주어진 구분자로 나누는지 테스트합니다.")
    void splitByDelimiterTest() {
        Delimiter delimiter = new Delimiter(BASIC_DELIMITER);
        String UserInput = "1:2,3";

        List<String> result = StringSplitter.splitByDelimiter(UserInput, delimiter);
        List<String> answer = new ArrayList<>(List.of("1", "2", "3"));

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("주어진 문자열에서 커스텀 구분자를 분리 가능한지 확인합니다.")
    void getCustomDelimiterTest() {
        String userInput = "//[\\n1";
        String result = StringSplitter.getCustomDelimiter(userInput);
        String answer = "[";

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("주어진 문자열에서 커스텀 구분자 지시자를 삭제하는지 확인합니다.")
    void deleteIndicatorTest() {
        String userInput = "//[\\n1[2[3";
        String result = StringSplitter.deleteIndicator(userInput);
        String answer = "[1[2[3";

        assertThat(result).isEqualTo(answer);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
