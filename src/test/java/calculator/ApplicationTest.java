package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("문자열에서 숫자를 추출한 후 더하기")
    void 숫자_추출_및_더하기() {
        assertSimpleTest(() -> {

            //기본 구분자(쉼표(,), 콜론(:))을 기준으로 숫자를 추출한 후 더하기
            run("1,2:3");
            assertThat(output()).contains("결과 : 6"); //1+2+3=6

            //공백이 있는 상황
            run(" 1 ,3,3 ");
            assertThat(output()).contains("결과 : 7"); //1+3+3=7

            //구분자가 한칸에 두번 사용된 상황
            run("4,,2:3");
            assertThat(output()).contains("결과 : 9"); //4+2+3=9

            //숫자가 하나만 들어간 상황
            run("5");
            assertThat(output()).contains("결과 : 5");

        });
    }

    @Test
    @DisplayName("자료형이 최대 크기를 초과 했을때 예외 처리하기")
    void 자료형_크기_초과_예외() {
        assertSimpleTest(() -> {

            //총합이 최대 크기를 초과하는 상황
            assertThatThrownBy(() -> runException(Integer.MAX_VALUE + ":1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("너무 큰 숫자를 입력했습니다.");

            //입력이 최대 크기를 초과하는 상황
            assertThatThrownBy(() -> runException("2147483648:0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("너무 큰 숫자를 입력했습니다.");

            //총합이 최대 크기가 나오는 상황
            run(Integer.MAX_VALUE + ":0");
            assertThat(output()).contains("결과 : " + Integer.MAX_VALUE); //2147483647+0=2147483647

        });
    }

    @Test
    @DisplayName("빈 문자열을 입력할 경우 예외처리하기")
    void 빈_문자열_예외() {
        assertSimpleTest(() -> {

            //빈 문자열을 입력한 상황
            assertThatThrownBy(() -> runException(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("문자열을 입력하지 않았습니다.");

            //공백을 입력한 상황
            assertThatThrownBy(() -> runException(" "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("문자열을 입력하지 않았습니다.");

        });
    }

    @Test
    @DisplayName("추출한 것이 숫자가 아닐 경우 예외 처리하기")
    void 추출한_자료형_예외() {
        assertSimpleTest(() -> {

            //커스텀 구분자를 잘못 선언한 상황
            assertThatThrownBy(() -> runException("3,4:1//;\\n"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("1//;\\n은(는) 숫자가 아닙니다.");

            //잘못된 구분자를 사용한 경우
            assertThatThrownBy(() -> runException("3'4:6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("3'4은(는) 숫자가 아닙니다.");

            //문자를 더하려는 상황
            assertThatThrownBy(() -> runException("5,2d:1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("2d은(는) 숫자가 아닙니다.");

        });
    }

    @Override
    public void runMain() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}