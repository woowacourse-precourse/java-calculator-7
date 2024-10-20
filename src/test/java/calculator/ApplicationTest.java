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
            "Z", "[", "{", "]", "}", "'", "\"", ";", "/", "?", ".", ">", "<", "\\", "ㅜ", "|");


    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_미사용_정상경우() {
        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("양수만 입력이 가능합니다")
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

    @Test
    void 커스텀_구분자_비정상_사용_이스케이프_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n\\n1\\n2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("올바른 형식이 아니거나 이스케이프 문자가 포함되어 있습니다"));
    }

    @Test
    void 커스텀_구분자_비정상_사용_여러개일때() {
        assertSimpleTest(() -> {

            assertThatThrownBy(() -> {

                for (int i = 0; i < customRegexList.size(); i++) {
                    runException("//" + customRegexList.get(i) + customRegexList.get(i) + "\\n1:2"
                            + customRegexList.get(i) + customRegexList.get(i) + "3,4");
                }

            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("올바른 형식이 아니거나 이스케이프 문자가 포함되어 있습니다");
        });
    }

    @Test
    void 커스텀_구분자_형식_하나만_존재_POST() {
        assertSimpleTest(() -> {

            assertThatThrownBy(() -> {

                for (int i = 0; i < customRegexList.size(); i++) {
                    runException(customRegexList.get(i) + "\\n1:2"
                            + customRegexList.get(i) + "3,4");
                }

            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("올바른 형식이 아니거나 이스케이프 문자가 포함되어 있습니다");
        });
    }

    @Test
    void 커스텀_구분자_형식_하나만_존재_RPE() {
        assertSimpleTest(() -> {

            assertThatThrownBy(() -> {

                for (int i = 0; i < customRegexList.size(); i++) {
                    runException("//" + customRegexList.get(i) + "1:2"
                            + customRegexList.get(i) + "3,4");
                }

            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("올바른 형식이 아니거나 이스케이프 문자가 포함되어 있습니다");
        });
    }

    @Test
    void 커스텀_구분자_숫자() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//3\\n1:235"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자 형식은 구분자로 사용할 수 없습니다"));
    }

    @Test
    void 커스텀_구분자_사용_정상_경우_숫자없이_커스텀_구분자만() {
        assertSimpleTest(() -> {
            run("//,\\n,,,,");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_사용_정상_경우_숫자일부와함께_커스텀_구분자() {
        assertSimpleTest(() -> {
            run("//,\\n,,3,,5");
            assertThat(output()).contains("결과 : 8");
        });
    }

    @Test
    void 커스텀_구분자_사용_정상_경우_입력X() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_integer_형식_정상적인_경우() {
        assertSimpleTest(() -> {
            run("//,\\n2147483647,1");
            assertThat(output()).contains("결과 : 2147483648");
        });
    }

    @Test
    void 숫자_integer_형식_초과하는_경우() {

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//,\\n2147483648,1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자 int 형식으로 전환되지 못했습니다"));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
