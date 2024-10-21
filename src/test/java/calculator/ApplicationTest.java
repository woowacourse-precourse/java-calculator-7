package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Separator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private List<String> separatorCollection;
    private Separator separator;

    @BeforeEach
    void setUp() {
        // 매 테스트마다 새로운 Separator 인스턴스 생성
        separator = new Separator(new ArrayList<>());
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("0 이하의 숫자는 입력할 수 없습니다");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
