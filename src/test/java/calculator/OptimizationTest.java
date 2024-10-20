package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OptimizationTest extends NsTest {

    @Test
    void 실행_시간_측정(){
        long startTime = System.nanoTime();
        assertSimpleTest(() -> {
            run("//;\\n1,2:3;4");
            assertThat(output()).contains("결과 : 10");
        });
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000.0;
        System.out.println(String.format("Execution time: %.2f ms", elapsedTime));
    }





    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
