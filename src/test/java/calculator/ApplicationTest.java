package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import calculator.TextNumber;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import java.util.Scanner;
import java.time.Duration;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

        Application test;
        TextNumber number;
        public static final Duration SIMPLE_TEST_TIMEOUT = Duration.ofSeconds(2);

     public ApplicationTest(){

     }

        @BeforeEach
        public void setTest() {
            this.test=new Application();
            this.number=new TextNumber();

        }

        @Test
        void 커스텀_구분자_사용() {
            assertSimpleTest(() -> {
                String input=Console.readLine();
                //            String input="123abc";
                run("//;\\n1");
                assertNotNull(input);
                String expectedResult=number.calculatingNumberPlus(input);
                String actualResult=test.changingNumber(input);
                //          assertThat(input.run()).contains("결과 : "+);
                assertThat(actualResult).isEqualTo(expectedResult);
            });
        }

        //던져주기
        public void runException(String input){
            if(!input.matches("//;\\n1+-&*#$")){
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }

        @Test
        public void 예외_테스트() {
            assertSimpleTest(() -> {

                String input=Console.readLine();

                //            String input = "123abc";
                IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->{

                    runException(input);
                });
                assertThat(exception).hasMessageContaining("잘못된 값을 입력하였습니다.");
            });

        }

        @Override
        public void runMain() {

            Application.main(new String[]{});
        }

}
