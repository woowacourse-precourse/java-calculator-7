package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {

    @Test
    void 공백이_존재하면_예외처리_공백이_존재하는_경우(){
        // given
        String inputWithBlank = "input test";

        //when & then
        assertThrows(IllegalArgumentException.class, () ->{
            Application.checkBlankExist(inputWithBlank);
        });
    }

    @Test
    void 공백이_존재하면_예외처리_공백이_존재하지_않는_경우(){
        // given
        String inputWithBlank = "inputtest";
        //when & then
        Application.checkBlankExist(inputWithBlank);
    }

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
}
