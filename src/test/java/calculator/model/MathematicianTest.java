package calculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MathematicianTest {
    @Test
    void 수학자_올바른_더하기() {
        // given
        Mathematician mathematician = new Mathematician();

        // when
        System.out.println("=====Logic Start=====");

        int sum = mathematician.sum(new int[]{1, 2, 3, 4, 5});

        System.out.println("=====Logic End=====");
        // then
        assertThat(sum).isEqualTo(15);

    }
}