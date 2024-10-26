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
    void 특수_커스텀_구분자_사용() {
    	assertSimpleTest(() -> {
            run("//.\\n1.2.3.4.5");
            assertThat(output()).contains("결과 : 15");
        });
    }
    
    @Test
    void 기본_구분자_2개_사용() {
    	assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Test
    void 기본_구분자_1개_사용() {
    	assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Test
    void 숫자만_사용() {
    	assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 올바른_구분자와_올바르지_않은_구분자_예외_테스트2() {
    	assertSimpleTest(() ->
	        assertThatThrownBy(() -> runException("1,2*3"))
	            .isInstanceOf(IllegalArgumentException.class)
	    );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
