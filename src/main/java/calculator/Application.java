package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // camp.nextstep.edu.missionutils.Console의 readLine()을 사용해 문자열을 String으로 저장
        String input = readLine();

        //쉼표(,)와 콜론(:)을 구분자로 하여 각 숫자로 분리한다.
        String[] strArr = input.split("[,:]");

        // 테스트 결과 출력
        System.out.println("input = " + input);
        System.out.println("strArr = " + Arrays.toString(strArr));
    }
}
