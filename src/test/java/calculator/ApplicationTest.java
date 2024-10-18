package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static List<String> customRegexList = List.of("`", "~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")",
            "-", "_", "="
            , "+", "a", "A", "b", "B", "c", "C", "d", "D", "e", "E", "f", "F", "g", "G", "h", "H", "i", "I", "j", "J",
            "k", "K", "l", "L", "m", "M", "n", "N", "o", "O",
            "p", "P", "q", "Q", "r", "R", "s", "S", "t", "T", "u", "U", "v", "V", "w", "W", "x", "X", "y", "Y", "z",
            "Z", "[", "{", "]", "}", "'", "\"", ";", "/", "?", ".", ">", "<", "\\", "ㅜ");


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
    void 커스텀_구분자_사용_일반적인_경우() {
        assertSimpleTest(() -> {
            for (int i = 0; i < customRegexList.size(); i++) {
                run("//" + customRegexList.get(i) + "\\n1:2" + customRegexList.get(i) + "3,4");
                assertThat(output()).contains("결과 : 10");
            }
        });
    }

    @Test
    void 커스텀_구분자_사용_정상_경우_기존구분자_땡() {
        assertSimpleTest(() -> {
            run("//:\\n1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_정상_경우_기존구분자_쉼표() {
        assertSimpleTest(() -> {
            run("//,\\n1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
