package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest extends NsTest {
    @DisplayName("기본 구분자 사용")
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @DisplayName("커스텀 구분자 사용")
    @Test
    void 커스텀_구분자_공백_슬래쉬_포함_사용() {
        assertSimpleTest(() -> {
            run("///; 3ㅇ ㄹㄹ f  t\\n3/; 3ㅇ ㄹㄹ f  t\4,2:6");
            assertThat(output()).contains("결과 : 11");
        });
    }

    @DisplayName("커스텀 구분자로 끝나는 경우")
    @Test
    void 커스텀_구분자_공백_슬래쉬_다수_포함_사용() {
        assertSimpleTest(() -> {
            String customDelimiter = "/; 3ㅇ ㄹㄹ f  \\t\\ t\\ t\\ \\";
            run("//"+customDelimiter+"\\n"+"3"+customDelimiter+"2:6"+customDelimiter);
            assertThat(output()).contains("결과 : 11");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}