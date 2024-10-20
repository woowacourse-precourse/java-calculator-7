package calculator.domain.machine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EngineTest {

    Engine engine = new Engine(new LineSplitter(new DelimiterExtractor()));


    @ParameterizedTest
    @ValueSource(strings = {"2:3:4", "2,3:4", "//;\\n2;3;4"})
    @DisplayName("올바른 연산 결과")
    void 올바른_연산_결과(String input) {
        // given
        // when
        Long operate = engine.operate(input);

        // then
        Assertions.assertEquals(9, operate);
    }

    @Test
    @DisplayName("blank값 입력 시 0 반환")
    void 공백_입력_결과() {
        // given
        // when
        Long operate = engine.operate("");

        // then
        Assertions.assertEquals(0, operate);
    }
}