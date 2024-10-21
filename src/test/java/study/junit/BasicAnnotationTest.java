package study.junit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JUnit 5 기본 Annotation")
class BasicAnnotationTest {

    private static int beforeCount = 0;
    private static int afterCount = 0;
    private static int methodCount = 0;

    @BeforeAll
    static void setUpAll() {
        System.out.println("@BeforeAll: life-cycle method, 테스트 클래스를 초기화할 때 한번 수행");
        System.out.println("beforeCount = " + beforeCount);
        System.out.println("afterCount = " + afterCount);
        System.out.println("methodCount = " + methodCount);
    }

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach: life-cycle method, 각각의 테스트 메서드 실행 전 수행");
        methodCount++;
        beforeCount++;
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll: life-cycle method, 모든 테스트 메서드 실행 이후 한번 수행");
        System.out.println("beforeCount = " + beforeCount);
        System.out.println("afterCount = " + afterCount);
        System.out.println("methodCount = " + methodCount);
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach: life-cycle method, 각각의 테스트 메서드 실행 이후 수행");
        afterCount++;
        methodCount++;
    }

    @Test
    @DisplayName("This is string type test")
    void stringTest() {
        methodCount++;
        assertThat("Hello" + " World").isEqualTo("Hello World");
    }

    @Test
    @DisplayName("This is integer type test")
    void integerTest() {
        methodCount++;
        assertThat(1 + 2).isEqualTo(3);
    }

    @Test
    @DisplayName("@Disabled: 테스트 비활성화")
    @Disabled
    void disabledTest() {
        methodCount++;
    }

}
