package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_사용_colon만() {
        assertSimpleTest(() -> {
            run("1:2:3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 기본_구분자_사용_comma만() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용_혼용사용() {
        assertSimpleTest(() -> {
            run("2,3:4");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 큰_수_입력_테스트() {
        assertSimpleTest(() -> {
            run("10000000000000000000:10000000");
            assertThat(output()).contains("결과 : 10000000000010000000");
        });
    }

    @Test
    void 음수입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_형식오류_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1;2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 구문자_위치오류_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(":1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구문자_중복사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2::3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_및_커스텀_구분자_혼용사용() {
        assertSimpleTest(() -> {
            run("//;\\n1:2;3,4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 성능확인_수_100개_더하기() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5,6,7,8,9,10,"
                    + "11,12,13,14,15,16,17,18,19,20,"
                    + "21,22,23,24,25,26,27,28,29,30,"
                    + "31,32,33,34,35,36,37,38,39,40,"
                    + "41,42,43,44,45,46,47,48,49,50,"
                    + "51,52,53,54,55,56,57,58,59,60,"
                    + "61,62,63,64,65,66,67,68,69,70,"
                    + "71,72,73,74,75,76,77,78,79,80,"
                    + "81,82,83,84,85,86,87,88,89,90,"
                    + "91,92,93,94,95,96,97,98,99,100");
            assertThat(output()).contains("결과 : 5050");
        });
    }

    @Test
    void 성능확인_커스텀_구분자_수_100개_더하기() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3;4;5;6;7;8;9;10;"
                    + "11;12;13;14;15;16;17;18;19;20;"
                    + "21;22;23;24;25;26;27;28;29;30;"
                    + "31;32;33;34;35;36;37;38;39;40;"
                    + "41;42;43;44;45;46;47;48;49;50;"
                    + "51;52;53;54;55;56;57;58;59;60;"
                    + "61;62;63;64;65;66;67;68;69;70;"
                    + "71;72;73;74;75;76;77;78;79;80;"
                    + "81;82;83;84;85;86;87;88;89;90;"
                    + "91;92;93;94;95;96;97;98;99;100");
            assertThat(output()).contains("결과 : 5050");
        });
    }

    @Test
    void 허용하지_않은_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
