package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
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
    void 예외_테스트_커스텀_구분자_누락_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자가 누락되었습니다.")
        );
    }

    @Test
    void 예외_테스트_기본_구분자_외_구분자_입력_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2#3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("기본 구분자 외 구분자가 포함되어있습니다.")
        );
    }

    @Test
    void 예외_테스트_커스텀_구분자_외_구분자_입력_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//#\\n1#2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자 외 구분자가 포함되어있습니다.")
        );
    }

    @Test
    void 커스텀_구분자_추출_테스트(){
        InputView inputView = new InputView();
        Calculator calculator = new Calculator(inputView);
        assertSimpleTest(() -> {
            String division = calculator.extractDivision("//;\\n1");
            assertThat(division).isEqualTo(";");
        });
    }

    @Test
    void 메타_문자_확인_테스트(){
        InputView inputView = new InputView();
        Calculator calculator = new Calculator(inputView);
        assertSimpleTest(() -> {
            assertThat(calculator.checkMetacharacters("*")).isTrue();
        });
    }

    @Test
    void 일반_문자_확인_테스트(){
        InputView inputView = new InputView();
        Calculator calculator = new Calculator(inputView);
        assertSimpleTest(() -> {
            assertThat(calculator.checkMetacharacters("@")).isFalse();
        });
    }

    @Test
    void 문자열_숫자_추출_테스트(){
        InputView inputView = new InputView();
        Calculator calculator = new Calculator(inputView);
        assertSimpleTest(() -> {
            String[] numbers = calculator.splitString("//;\\n1;2;3;4;5", ";");
            assertThat(numbers.length).isEqualTo(5);
        });
    }

    @Test
    void 문자열_숫자_파싱_덧셈_테스트(){
        InputView inputView = new InputView();
        Calculator calculator = new Calculator(inputView);
        String[] numbers = new String[]{"1","2","3","4"};
        assertSimpleTest(() -> {
            int sum = calculator.parsingAndSum(numbers);
            assertThat(sum).isEqualTo(10);
        });
    }

    @Test
    void 커스텀_구분자_결과값_일치_테스트(){
        assertSimpleTest(() -> {
            run("//^\\n1^2^3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_결과값_일치_테스트(){
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
