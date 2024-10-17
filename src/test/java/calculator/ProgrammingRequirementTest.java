package calculator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProgrammingRequirementTest extends NsTest {

    private static final String JAVA_VERSION_PROPERTIY = "java.version";

    @DisplayName("프로그래밍 요구사항을 지키기 위한 버전 21 테스트")
    @Test
    public void testJavaVersion21() {
        String javaVersion = System.getProperty(JAVA_VERSION_PROPERTIY);
        Assertions.assertTrue(javaVersion.startsWith("21"));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
