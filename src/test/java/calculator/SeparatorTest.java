package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class SeparatorTest extends NsTest {
    @Test
    void testSeparateComma() {
        assertSimpleTest(() -> {
            Separator obj = new Separator();
            run("1,2,3");

            String[] result = obj.separate("1,2,3", ",");
            assertThat(result)
                    .satisfiesExactly(item1 -> assertThat(item1).contains("1").contains("2").contains("3"));
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void testSeparateColon() {
        assertSimpleTest(() -> {
            Separator obj = new Separator();
            run("1:2:3");

            String[] result = obj.separate("1:2:3", ":");
            assertThat(result)
                    .satisfiesExactly(item1 -> assertThat(item1).contains("1").contains("2").contains("3"));
        });
    }

    @Test
    void testSeparateCommaOrColon() {
        assertSimpleTest(() -> {
            Separator obj = new Separator();
            run("1,2:3");

            String[] result = obj.separate("1,2:3", ",|:");
            assertThat(result)
                    .satisfiesExactly(item1 -> assertThat(item1).contains("1").contains("2").contains("3"));
        });
    }

    @Test
    void testSeparateCustom() {
        assertSimpleTest(() -> {
            Separator obj = new Separator();
            run("//;\\n1;2;3");

            String[] result = obj.separate("1;2;3", ";");
            assertThat(result)
                    .satisfiesExactly(item1 -> assertThat(item1).contains("1").contains("2").contains("3"));
        });
    }

    @Test
    void testSeparateCustomOrCommaOrColon() {
        assertSimpleTest(() -> {
            Separator obj = new Separator();
            run("//;\\n1;2,3:4");

            String[] result = obj.separate("1;2,3:4", ";|,|:");
            assertThat(result)
                    .satisfiesExactly(item1 -> assertThat(item1).contains("1").contains("2").contains("3"));
        });
    }

    @Override
    protected void runMain() {

    }
}
