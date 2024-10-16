package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 유효성_체크_실패_테스트() {
        String[] errorInput = {"///;\\n1",
                "//;\n1",
                "//;\\\\n1",
                "//;;\\n1",
                "1;2;3//;\\n1",
                "1;2;3//;\\n",
                "//;\\n1:2:3", //커스텀 구분자 설정시 기본 구분자 사용 불가능
                "//\\n1:2:3",
                "//,\\n1,2:3",
                "//1\\n1:2:3", //숫자 구분자 사용 불가능
                "-1"
        };
        for(String input : errorInput){
            assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                    .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    void 유효성_체크_성공_테스트(){
        String[] successInput = {"1,2",
                "0,1",
                "0",
                "0,0,0",
                "//;\\n1;2;3",
                "//,\\n1,2,3",
                "1,2:3"
        };
        for(String input : successInput){
                assertSimpleTest(() -> {
                    run(input);
                    assertThat(output()).contains("결과");
                });

        }
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
