package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.IllegalInputException;
import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 문자열에서_숫자_추출하기_기본생성자_예외처리() {
        //given
        String input = "6;4,0";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumber)
                .isInstanceOf(IllegalInputException.class)
                .hasMessageContaining("잘못된 구분자입니다.");
    }

    @Test
    void 문자열에서_숫자_추출하기_커스텀생성자_예외처리() {
        //given
        String input = "//\n34";
        Extractor extractor = new Extractor(input);
    
        //when
        assertThatThrownBy(extractor::extractNumber)
                .isInstanceOf(IllegalInputException.class)
                .hasMessageContaining("잘못된 구분자입니다.");

        //then
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
