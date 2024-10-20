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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_255자_이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123;123;123;123;123;123;123;123;123;123,123,123," +
                        "123,12,31,23,123,1,23,123,2,32,32,2,2,2,,3,23,23,2,3,2,3,2,,3,1,23,1,23,123,1,23," +
                        "1,23,12312;12;31;23;123;123;12;3;123;1;23;12;3;12;3;12;3;123;1;23;1;23;123;1;23;1;" +
                        "23;12;3;12;3;123;1;23;12;31;23;12;31;2;31;23;1;23;12;3;12;31;2;31;2;31;2;31;2;31;2;31" +
                        ";2;31;23;1;23;12;3;12312;31;231;2;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_구분자를_가진_문자열을_위한_최소길이_미충족() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 예외_테스트_커스텀_구분자를_가진_문자열_올바르지않은_형식(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;n6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 예외_테스트_커스텀_구분자가_숫자일_경우(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//4\\n6"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 예외_테스트_덧셈_결과값이_10억_이상일_경우(){
        //Todo: 덧셈 결과값이 10억 이상일 경우 예외처리
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("500000000:500000001:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 예외_테스트_입력한_숫자가_10억_이상일_경우(){
        //Todo: 입력한 숫자가 10억 이상일 경우 예외처리
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000000000:500000001:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
