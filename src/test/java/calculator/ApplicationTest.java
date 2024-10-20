package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.Console.*;

//Test Code를 작성하는 곳
class ApplicationTest extends NsTest {

    //Test Case를 실행하기 위해 호출하는 Main Method
    @Override
    public void runMain() {
        //Application.main(new String[]{}); //Application Main 호출해서 실행 시키는 코드

        System.out.println("ghe : ");
        System.out.println(" input msg: ");
        String input = readLine(); //조건사항 readLine()을 이용하여 사용자 입력을 받을것
        System.out.println(input);
        }

    // Test Code 작성
    @Test
    void testmain() {
        assertSimpleTest(() -> {
            runMain();

        });
    }



}
