package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.fixture.CustomDelimiterFixture;
import calculator.fixture.DefaultDelimiterFixture;
import calculator.fixture.ExceptionFixture;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class ApplicationTest extends NsTest {

    @ParameterizedTest
    @EnumSource(CustomDelimiterFixture.class)
    void 커스텀_구분자_사용(CustomDelimiterFixture fixture) {
        assertSimpleTest(() -> {
            run(fixture.getInput());
            assertThat(output()).contains(fixture.getResult());
        });
    }

    @ParameterizedTest
    @EnumSource(DefaultDelimiterFixture.class)
    void 기본_구분자_사용(DefaultDelimiterFixture fixture) {
        assertSimpleTest(() -> {
            run(fixture.getInput());
            assertThat(output()).contains(fixture.getResult());
        });
    }

    @ParameterizedTest
    @EnumSource(ExceptionFixture.class)
    void 예외_테스트(ExceptionFixture fixture) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(fixture.getInvalidInput()))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
