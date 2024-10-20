package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("실제 Main 메소드에서 예외를 발생시키는 테스트")
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("정상적인 값이 들어갔을때 실제 코드에서 원하는 값이 출력되어야함")
    void 실제코드_적용_1번() {
        assertSimpleTest(() -> {
            run("//>\\n1::2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("0만 존재할때")
    void 숫자_0() {
        assertSimpleTest(() -> {
            run("0");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("공백으로 이루어진 배열이라도, 정상적으로 0을 리턴한다.")
    void 공백_배열_테스트() {
        assertSimpleTest(() -> {
            run(" , , ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("파이프(|) 기호를 적용할 떄")
    void 파이프_기호_적용() {
        assertSimpleTest(() -> {
            run("//|\\n1|2|3|4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    @DisplayName("메서드에 숫자자리에 문자열이 들어가있을때 에러가 발생되어야함")
    void 문자열이_숫자_자리에_있을때() {
        assertThatThrownBy(() -> {
            run("1,2,three");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("양끝과 숫자사이에 공백이있을때")
    void 양끝_숫자_공백_존재() {
        assertSimpleTest(() -> {
            run(" 1 , 2 : 3 ");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("여러개의 구분자가 붙어있어도, 공백은 0으로 처리해서 정상작동됨")
    void 여러_구분자가_붙어있을때() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3,4,;5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}
