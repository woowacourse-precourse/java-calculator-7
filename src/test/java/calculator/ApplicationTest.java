package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private Application application = new Application(); // Corrected class name

    @DisplayName("null 또는 빈문자")
    @Test
    void nullOrEmptyTest(){
        String numbers = "";
        assertThat(application.calculateSum(numbers)).isEqualTo(0); // Updated to use application

        numbers = null;
        assertThat(application.calculateSum(numbers)).isEqualTo(0); // Updated to use application
    }

    @DisplayName("기본 구분자1")
    @Test
    void standardTest1(){
        String numbers = "1,2";
        assertThat(application.calculateSum(numbers)).isEqualTo(3); // Updated to use application
    }

    @DisplayName("기본 구분자2")
    @Test
    void standardTest2(){
        String numbers = "1,2:3";
        assertThat(application.calculateSum(numbers)).isEqualTo(6); // Updated to use application
    }

    @DisplayName("커스텀 구분자1 ")
    @Test
    void customTest1(){
        String numbers = "//;\n1;2;3";
        assertThat(application.calculateSum(numbers)).isEqualTo(6); // Updated to use application
    }

    @DisplayName("커스텀 구분자2")
    @Test
    void customTest2(){
        String numbers = "//.\n1.2.3";
        assertThat(application.calculateSum(numbers)).isEqualTo(6); // Updated to use application
    }

    @DisplayName("음수 값")
    @Test
    void minusTest(){
        String numbers = "-1,2,3";
        assertThatThrownBy(()->{
            application.calculateSum(numbers); // Updated to use application
        }).isInstanceOf(IllegalArgumentException.class); // Adjusted to match exception thrown
    }

    @DisplayName("숫자 외 값")
    @Test
    void notNumberTest(){
        String input = "#,2,3";
        assertThatThrownBy(()->{
            application.calculateSum(input); // Updated to use application
        }).isInstanceOf(IllegalArgumentException.class); // Adjusted to match exception thrown
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}