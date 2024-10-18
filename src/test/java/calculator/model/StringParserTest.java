package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import calculator.fixture.CalculatorAppFixture;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParserTest {

    private final StringParser stringParser = CalculatorAppFixture.createStringParser();

    @DisplayName("커스텀 구분자 생성문자와 계산대상인 숫자와 구분자 문자열을 분리한다.")
    @Test
    void splitTarget() {

        assertSimpleTest(() -> {
            String splitedTarget = stringParser.splitTarget("//;\\n1//;\\n11.2.3");
            assertThat(splitedTarget).contains("1.2.3");
        });
    }

    @DisplayName("문자열에서 구분자를 제거하고 숫자만 파싱해 숫자 리스트를 반환한다.")
    @Test
    void parseToNumbers() {
        assertSimpleTest(() -> {
            List<Integer> numbers = stringParser.parseToNumbers("1,2:3");
            assertThat(numbers).contains(1,2,3);
        });
    }
}
