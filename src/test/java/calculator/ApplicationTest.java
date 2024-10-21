package calculator;

import calculator.TextNumber;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    Application test;
    TextNumber number;
    public ApplicationTest(){

    }

    @BeforeEach
    public void setTest() {
        this.test=new Application();
        this.number=new TextNumber();

    }

    @Test
    @DisplayName("메인에 입력값넣기테스트하기")
    public void changingNumber() {

        String inputText=Console.readLine();
//        String insertText="123abc";
        assertNotNull(insertText);

    //    TextNumber plus = new TextNumber();
        String expectedResult=number.calculatingNumberPlus(insertText);
        String actualResult=test.changingNumber(insertText);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
