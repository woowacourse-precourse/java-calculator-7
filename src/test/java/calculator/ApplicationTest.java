package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

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
