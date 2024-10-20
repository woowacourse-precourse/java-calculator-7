package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.contains;

class ApplicationTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    
    @Test
    void 커스텀_구분자_사용_case1() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }
    
    @Test
    void 커스텀_구분자_사용_case2() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Test
    void 커스텀_구분자_사용_case3() {
        assertSimpleTest(() -> {
            run("//*\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }
    @Test
    void 커스텀_구분자_사용_case4() {
        assertSimpleTest(() -> {
            run("//*\\n1*2*3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    /* 직접 테스트코드를 작성해보자.
     * test code는 given, where, then으로 나뉨
     * given : 테스트 실행 준비, where : 테스트 진행, then : 테스트 검증
     */
    @Test
    void 기본_구분자_사용() {
    	assertSimpleTest(()->{
    		run("1,2,3");
    		assertThat(output()).contains("결과 : 6");
    	});
    }
    
    @Test
    void 공백처리_case1() {
    	assertSimpleTest(()->{
    		run("\n");
    		assertThat(output()).contains("결과 : 0");
    	});
    }
    
    @Test
    void 공백처리_case2() {
    	assertSimpleTest(()->{
    		run("1,2,,3");
    		assertThat(output()).contains("결과 : 6");
    	});
    }
    
    @Test
    void 공백처리_case3() {
    	assertSimpleTest(()->{
    		run("//;\\n1;;2;7");
    		assertThat(output()).contains("결과 : 10");
    	});
    }

    @Test
    void 예외_테스트_음수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 예외_테스트_기본_구분자_문자열_case1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("ㅇ,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 예외_테스트_커스텀_구분자_문자열_case1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\n1;h;1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    void 예외_테스트_커스텀_구분자_문자열_case2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\\\n1;h;1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 예외_테스트_커스텀_구분자_구분자_설정오류_case1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//1\\n"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
    void 예외_테스트_커스텀_구분자_음수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\n1;2;-3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    

}
