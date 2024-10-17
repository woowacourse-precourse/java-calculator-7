package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.domain.Addition;
import calculator.domain.Extractor;
import calculator.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


    @Test
    void 계산을_원하는_문자열_입력받기_공백인_경우() {
        //given
        String input = "";
        InputView inputView = new InputView();

        //when & then
        assertThatThrownBy(() -> inputView.hasValue(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("값을 입력해야 합니다.");
    }

    @DisplayName("기본 구분자가 잘못 입력된 경우")
    @Test
    void 문자열에서_숫자_추출하기_기본구분자() {
        //given
        String input = "6;4,0";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 구분자입니다.");
    }

    @DisplayName("커스텀 구분자가 공백인 경우")
    @Test
    void 문자열에서_숫자_추출하기_커스텀구분자() {
        //given
        String input = "//\n34";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 구분자입니다.");
    }

    @DisplayName("기본 구분자와 커스텀 구분자가 동시에 존재할 때 잘못된 구분자를 입력한 경우")
    @Test
    void 문자열에서_숫자_추출하기_기본구분자_커스텀구분자() {
        //given
        String input = "//;\n3;4&5";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumbers)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 구분자입니다.");
    }


    @Test
    void 문자열에서_추출한_숫자_덧셈하기() {
        //given
        List<Integer> numbers = List.of(2, 3, 4);
        Addition addition = new Addition(numbers);

        //when
        int result = addition.addNumber();

        //then
        assertEquals(9, result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
