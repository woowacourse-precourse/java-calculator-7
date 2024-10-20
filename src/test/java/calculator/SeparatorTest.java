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
            assertThat(result).containsExactly("1", "2", "3");
        });
    }

    @Test
    void testSeparateColon() {
        assertSimpleTest(() -> {
            Separator obj = new Separator();
            run("1:2:3");

            String[] result = obj.separate("1:2:3", ":");
            assertThat(result).containsExactly("1", "2", "3");
        });
    }

    @Test
    void testSeparateCommaOrColon() {
        assertSimpleTest(() -> {
            Separator obj = new Separator();
            run("1,2:3");

            String[] result = obj.separate("1,2:3", ",|:");
            assertThat(result).containsExactly("1", "2", "3");
        });
    }

    @Test
    void testSeparateCustom() {
        assertSimpleTest(() -> {
            Separator obj = new Separator();
            run("//;\\n1;2;3");

            String[] result = obj.separate("1;2;3", ";");
            assertThat(result).containsExactly("1", "2", "3");
        });
    }

    @Test
    void testSeparateCustomOrCommaOrColon() {
        assertSimpleTest(() -> {
            Separator obj = new Separator();
            run("//;\\n1;2,3:4");

            String[] result = obj.separate("1;2,3:4", ";|,|:");
            assertThat(result).containsExactly("1", "2", "3", "4");
        });
    }

    @Test
    void testSeparateMethod() {

        assertSimpleTest(() -> {
            Separator obj = new Separator();
            String[] result = obj.separate("//;\\n1;2,3:4", ",|:|;");
            assertThat(result).containsExactly("1", "2", "3", "4");
        });

        assertSimpleTest(() -> {
            Separator obj = new Separator();
            String[] result = obj.separate("//;\\n//#\\n//!\\n1;2#3!4", ",|:|!|#|;");
            assertThat(result).containsExactly("1", "2", "3", "4");
        });

        assertSimpleTest(() -> {
            Separator obj = new Separator();
            String[] result = obj.separate("//;\\n//!\\n1;2,3!4", ",|:|;|!");
            assertThat(result).containsExactly("1", "2", "3", "4");
        });

        assertSimpleTest(() -> {
            Separator obj = new Separator();
            String[] result = obj.separate("1,2,3:4");
            assertThat(result).containsExactly("1", "2", "3", "4");
        });
    }

    @Test
    void testGetSeparator() {
        assertSimpleTest(() -> {
            Separator obj = new Separator();
            String result = obj.getSeparator("//;\\n1;2,3:4");
            assertThat(result).isEqualTo(",|:|;");
        });

        assertSimpleTest(() -> {
            Separator obj = new Separator();
            String result = obj.getSeparator("//;\\n//#\\n//!\\n1;2,3:4");
            assertThat(result).isEqualTo(",|:|;|#|!");
        });
    }

    @Override
    protected void runMain() {

    }
}
