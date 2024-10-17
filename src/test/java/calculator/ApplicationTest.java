package calculator;

import calculator.number.Number;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자를 사용할 경우 커스텀 구분자와 기본 구분자 외의 특수문자가 사용되면 예외를 발생한다.")
    void inputExceptionTest1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//?\\n1?2.3.4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자에 해당 되지 않는 특수문자를 사용하면 예외를 발생한다.")
    void inputExceptionTest2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1/3/4/5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자 사용시 맨 앞에 입력하지 않으면 예외를 발생한다.")
    void inputExceptionTest3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1?2?3?4//?\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력에 영어가 입력되면 예외를 발생한다.")
    void inputExceptionTest4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,4,a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력에 0이 입력되면 예외를 발생한다.")
    void inputExceptionTest5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,4,0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력에 한글이 입력되면 예외를 발생한다.")
    void inputExceptionTest6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,4,가"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력에 특수문자가 입력되면 예외를 발생한다.")
    void inputExceptionTest7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,4,?"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자 사용 시 // 또는 \\n 둘 중 하나라도 사용하지 않으면 예외를 발생한다.")
    void inputExceptionTest8() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//?1?2?3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("영어만 입력이 들어오면 예외를 발생한다.")
    void inputExceptionTest9() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("특수문자만 입력이 들어오면 예외를 발생한다.")
    void inputExceptionTest10() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("&^%"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자의 순서가 잘못 되면 예외를 발생한다.")
    void inputExceptionTest11() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\\n?//1?23?4?5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력에 공백이 들어오면 0을 반환한다.")
    void inputTest1() {
        String userInput = "";
        calculator.number.Number number = new Number(userInput);

        int result = number.getResult();

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("구분자 없이 양수만 들어오면 해당 양수값을 반환한다.")
    void inputTest2() {
        String userInput = "123";
        calculator.number.Number number = new Number(userInput);

        int result = number.getResult();

        assertThat(result).isEqualTo(123);
    }

    @Test
    @DisplayName("기본 구분자들을 통해 숫자를 구분한 뒤 결과값을 반환한다.")
    void inputTest3() {
        String userInput = "1,2,3:4";
        calculator.number.Number number = new Number(userInput);

        int result = number.getResult();

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("커스텀 구분자를 통해 숫자를 구분한 뒤 결과값을 반환한다.")
    void inputTest4() {
        String userInput = "//?\\n1?2?3?4";
        calculator.number.Number number = new Number(userInput);

        int result = number.getResult();

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자를 통해 숫자를 구분한 뒤 결과값을 반환한다.")
    void inputTest5() {
        String userInput = "//?\\n1?2,3:4";
        calculator.number.Number number = new Number(userInput);

        int result = number.getResult();

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용하더라도 기본 구분자를 통해 숫자를 구분한 뒤 결과값을 반환한다.")
    void inputTest6() {
        String userInput = "//?\\n1,2,3,4";
        calculator.number.Number number = new Number(userInput);

        int result = number.getResult();

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("기본 구분자를 통해 숫자를 구분한 뒤 결과값을 반환한다.")
    void inputTest7() {
        String userInput = "1,2,3,4";
        calculator.number.Number number = new Number(userInput);

        int result = number.getResult();

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("기본 구분자를 통해 숫자를 구분한 뒤 결과값을 반환한다.")
    void inputTest8() {
        String userInput = "1  ,  2   ,   3   ,  4";
        calculator.number.Number number = new Number(userInput);

        int result = number.getResult();

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("커스텀 구분자가 여러 개일 경우 해당 커스텀 구분자들을 통해 숫자를 구분한 뒤 결과값을 반환한다.")
    void inputTest9() {
        String userInput = "//?.\\n1?2?3.4";
        calculator.number.Number number = new Number(userInput);

        int result = number.getResult();

        assertThat(result).isEqualTo(10);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
