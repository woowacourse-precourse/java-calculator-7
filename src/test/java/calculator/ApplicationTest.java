package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Set;
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
    void 문자열에서_숫자_추출하기_기본구분자_예외처리() {
        //given
        String input = "6;4,0";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 구분자입니다.");
    }

    @Test
    void 문자열에서_숫자_추출하기_커스텀구분자_예외처리() {
        //given
        String input = "//\n34";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 구분자입니다.");
    }

    @Test
    void 문자열에서_숫자_추출하기_기본생성자와_커스텀생성자가_동시에_존재() {
        //given
        String input = "//;\n3;4&5";
        Extractor extractor = new Extractor(input);

        //when & then
        assertThatThrownBy(extractor::extractNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 구분자입니다.");
    }


    @Test
    void 문자열에서_추출한_숫자_덧셈하기() {
        //given
        Set<Integer> numbers = Set.of(2, 3, 4);
        Addition addition = new Addition(numbers);

        //when
        int result = addition.addNumber();

        //then
        assertEquals(9, result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
