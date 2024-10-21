package calculator;

import calculator.model.CalculationModel;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
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
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    //본 구분자와 커스텀 구분자 혼합 처리
    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run("//=\\n1,2=4");
            assertThat(output()).contains("결과 : 7");
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
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //공백 예외 처리
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //커스텀 닫기 예외 처리
    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    //커스텀 구분자 입력 예외 처리
    @Test
    void 예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1}2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    private void runException(String input) {
        CalculationModel model = new CalculationModel();
        OutputView outputView = new OutputView();
        try {
            outputView.printInput();
            model.parseInput(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage()); // 예외 메시지 출력
            throw e; // 예외 다시 던지기
        }
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}