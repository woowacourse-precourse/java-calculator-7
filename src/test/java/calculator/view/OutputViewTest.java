package calculator.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class OutputViewTest {

    OutputView outputView = new OutputView();
    PrintStream originStream;

    @BeforeEach
    void setUp() {
        originStream = System.out;
    }

    @AfterEach
    void tearDown() {
        System.setOut(originStream);
    }

    @Test
    @DisplayName("문자열을 입력받기위한 안내문구를 출력한다")
    void printInputMessage() {
        //given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        outputView.printInputMessage();

        //then
        Assertions.assertThat(outputStream.toString().trim())
                .isEqualTo("덧셈할 문자열을 입력해 주세요.");

        System.setOut(originStream);
    }

    @Test
    @DisplayName("연산 결과를 출력한다")
    void printResultMessage() {
        //given
        String number = "15";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        outputView.printResultMessage(number);

        //then
        Assertions.assertThat(outputStream.toString().trim())
                .isEqualTo("결과 : " + number);
    }

}