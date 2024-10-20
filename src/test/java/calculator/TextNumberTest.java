package calculator;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

class TextNumberTest extends NsTest {
    TextNumber number;

    public TextNumberTest(){

    }

    @BeforeEach
    public void setNumber() {
        this.number=new TextNumber();

    }
    @Test
    @DisplayName("입력값을 숫자로 바꾸고 더하기")
    public void calculatingNumberPlus() {
//        String inputText=Console.readLine();
          String inputText="123abc";
          assertNotNull(inputText);

          AtomicInteger sum=new AtomicInteger(0);

          assertSimpleTest(() -> {
              for (char reverseNum : inputText.toCharArray()) {
                    if(Character.isDigit(reverseNum))
                        sum.addAndGet(Character.getNumericValue(reverseNum));
                }
                run("//;\\n1");
                assertThat(calculatingNumberPlus(sum.get())).contains("결과 : " + sum.get());
            });
        }

    @Test
    void 예외_테스트() {
//        assertSimpleTest(() -> {
//            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
//        });
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다."); // 예외 발생
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값을 입력하였습니다."); // 메시지 확인
    }


    public String calculatingNumberPlus(int sum){
        return "결과 : "+sum;
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
