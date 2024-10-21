package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String text = Console.readLine();

        // 2. 숫자 추출
        // 기본 구분자
        String sep = ",|:";

        // 커스텀 구분자
        if(text.startsWith("//")){
            int sepIdx = text.indexOf("\\n"); // 줄바꿈으로 인식하지 않기 위해
            if (sepIdx != -1) {
                sep = text.substring(2, sepIdx);  // 커스텀 구분자 추출
                text = text.substring(sepIdx + 2); // 문자열에서 구분자 부분 제거
                System.out.println("사용된 구분자: " + sep);
            } else {
                throw new IllegalArgumentException();
            }
        }
        String[] num = text.split("["+sep+"]");
        System.out.println(Arrays.toString(num));
    }
}
