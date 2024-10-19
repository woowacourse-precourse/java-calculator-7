package calculator.splitor;

import calculator.InputString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class SplitorTest {

    @DisplayName("기본 구분자를 기준으로 구분한 문자열 리스트를 반환한다.")
    @Test
    void test1() {
        assertSimpleTest(() -> {
            // given
            InputString inputString = new InputString("1,3:4,23");
            Splitor splitor = new BasicSplitor(inputString);

            // when
            List<String> integerList = splitor.split();

            // then
            assertThat(integerList).isEqualTo(List.of("1", "3", "4", "23"));
        });
    }

    @DisplayName("커스텀 구분자를 기준으로 구분한 문자열 리스트를 반환한다.")
    @Test
    void test2() {
        assertSimpleTest(() -> {
            // given
            InputString inputString = new InputString("//*\\n1*3:4,23");
            Splitor splitor = new CustomSplitor(inputString, inputString.extractCustomSeperator());

            // when
            List<String> integerList = splitor.split();

            // then
            assertThat(integerList).isEqualTo(List.of("1", "3", "4", "23"));
        });
    }


}