package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.model.delimiter.DefaultDelimiter;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
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
    void 기본_구분자_추출() {
        assertSimpleTest(() -> {
            List<String> expectedDelimiter = List.of(":", ",");
            List<String> resultDelimiter = DefaultDelimiter.getDefaultDelimiters();
            if (!expectedDelimiter.equals(resultDelimiter)) {
                throw new Exception("기본 구분자가 다릅니다!");
            }
        });
    }


    @Test
    void 커스텀_구분자_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\n0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_형식이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("&\\n0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_중복_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//..\\n1.2.3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_메타문자_입력() {
        assertSimpleTest(() -> {
            run("//[]\\n1[2]3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_알파벳_입력() {
        assertSimpleTest(() -> {
            run("//n\\n1n2n3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자_여러개_입력() {
        assertSimpleTest(() -> {
            run("//n%i\\n1n2%3i4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자만_입력() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 기본_구분자_계산() {
        assertSimpleTest(() -> {
            run("//[\\n1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
