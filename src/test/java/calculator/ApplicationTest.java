package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    //아래 부터는 내가 만든 테스트
    @Test
    void 커스텀_구분자_사용_알파벳() {
        assertSimpleTest(() -> {
            run("//wq\\n1wq2wq3wq");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_알파벳과_숫자() {
        assertSimpleTest(() -> {
            run("//1q\\n11q21q3");
            assertThat(output()).contains("결과 : 6");
        });

    }

    @Test
    void 커스텀_구분자_한글() {
        assertSimpleTest(() -> {
            run("//ㅇ\\n11ㅇ21ㅇ3");
            assertThat(output()).contains("결과 : 35");
        });

    }

    @Test
    void 빈값이_입력으로_주어질_때() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자가_맨_앞에_올_때() {
        assertSimpleTest(() -> {
            run("//wq\\nwq3:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자가_이스케이프_문자일_때() {
        assertSimpleTest(() -> {
            run("//*\\n*3*3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1q\\n11eq21q3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
