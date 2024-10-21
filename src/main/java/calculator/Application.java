package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String delimiter = ",|:"; // 기본 구분자

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        /*
        * 커스텀 구분자가 있는지 확인한다. (5문자) //와 \n 사이에 문자
        * 커스텀 구분자가 있으면
        * 문자열 앞의 5글자가 "//" 와 "\\"로 이루어져 있는지 확인하고 사이에 문자가 있는지 확인한다.
        * 커스텀 구분자가 없으면
        * 기본 구분자를 사용한다.
        */
        if (input.startsWith("//")) { // 커스텀 구분자로 시작하는지 확인
            // "\n"으로 끝나는지 확인
            if (input.substring(3, 5).equals("\\n")) {
                delimiter = input.substring(2, 3);
                input = input.substring(5);
                // TODO: 비어있는지 체크
            }
            else {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
        }


    }


}
