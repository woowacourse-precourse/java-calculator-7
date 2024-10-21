package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 2. 숫자 추출
        // 기본 구분자
        String[] num = input.split("[,:]");
        // System.out.println(Arrays.toString(num));
    }
}
