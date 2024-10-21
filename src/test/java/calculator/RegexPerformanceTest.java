package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexPerformanceTest {

    private static Pattern staticPattern;

    //@BeforeAll
    public static void setup() {
        staticPattern = Pattern.compile("^[a-zA-Z0-9]+$");
    }

    //@Test
    public void 동적_컴파일() {
        String testString = "testString123";
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000000; i++) {
            boolean result = Pattern.compile("^[a-zA-Z0-9]+$").matcher(testString).matches();
            assertTrue(result);
        }

        long endTime = System.nanoTime();
        System.out.println("Dynamic : " + (endTime - startTime) + " ns");
    }

    //@Test
    public void 정적_컴파일() {
        String testString = "testString123";
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000000; i++) {
            boolean result = staticPattern.matcher(testString).matches();
            assertTrue(result);
        }

        long endTime = System.nanoTime();
        System.out.println("Static : " + (endTime - startTime) + " ns");
    }
   // @Test
    public void 일반문자열_비교() {
        String testString = "testString123";
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000000; i++) {
            boolean result = testString.matches("^[a-zA-Z0-9]+$");
            assertTrue(result);
        }

        long endTime = System.nanoTime();
        System.out.println("String : " + (endTime - startTime) + " ns");
    }
}
