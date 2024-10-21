package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
    void PositiveNumTest() {
        Random rand = new Random();
        int randomSize = rand.nextInt(1, 100);
        String result = "결과 : ";
        String input = "";
        double sum = 0.0;
        for (int i = 0; i < randomSize; ++i) {
            double randomNum;
            while (true) {
                randomNum = rand.nextDouble(0.0f, (double) randomSize);
                if (randomNum > 0.0) {
                    break;
                }
            }
            input += Double.toString(randomNum);
            sum += randomNum;

            randomNum = rand.nextInt(0, 2);
            if (randomNum % 2 == 0) {
                input += ':';
            } else {
                input += ',';
            }
        }
        result += Double.toString(sum);

        final String testInput = input;
        final String testResult = result;

        assertSimpleTest(() -> {
            run(testInput);
            assertThat(output()).contains(testResult);
        });
    }

    @Test
    void NegativeNumTest() {
        Random rand = new Random();
        int randomSize = rand.nextInt(1, 100);
        String result = "결과 : ";
        String input = "";
        double sum = 0.0;
        boolean bHasNegative = false;
        for (int i = 0; i < randomSize; ++i) {
            double randomNum = rand.nextDouble(-(double) randomSize, (double) randomSize);
            if (randomNum < 0.0) {
                bHasNegative = true;
            }
            input += Double.toString(randomNum);
            sum += randomNum;

            randomNum = rand.nextInt(0, 2);
            if (randomNum % 2 == 0) {
                input += ':';
            } else {
                input += ',';
            }
        }
        result += Double.toString(sum);

        final String testInput = input;
        final String testResult = result;

        if (!bHasNegative) {
            assertSimpleTest(() -> {
                run(testInput);
                assertThat(output()).contains(testResult);
            });
        } else {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(testInput))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    void CustomIdentifierTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1-2-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() -> {
            run("//|(-)\\n1|(-)2|(-)3");
            assertThat(output()).contains("결과 : 6");
        });
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//|(-)\\n1|-)2(-)3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
