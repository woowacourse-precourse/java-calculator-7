package calculator.domain;

import calculator.util.RandomSupport;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;

import static calculator.util.TestEnvironment.REPEATED_TEST_COUNT;

class PlusTest extends RandomSupport {
    private static final Plus PLUS = new Plus();

    private NumberList numberList;
    private long expectedResult = 0L;

    @BeforeEach
    void set() {
        final var list = new ArrayList<Number>();

        for (int i = 0; i < loopCount; i++) {
            final var positiveValue = createPositive();
            list.add(Number.of(positiveValue));
            expectedResult += positiveValue;
        }

        this.numberList = new NumberList(list);
    }

    @RepeatedTest(REPEATED_TEST_COUNT)
    void 더하기_계산에_성공할_것이다() {
        final var result = PLUS.execute(numberList);

        Assertions.assertThat(result.value()).isEqualTo(expectedResult);
    }
}