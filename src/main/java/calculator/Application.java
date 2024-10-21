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
            } else { // 예외 : //로 시작하되, 커스텀 구분자가 아닌 경우
                throw new IllegalArgumentException();
            }
        }
        String[] num = text.split("["+sep+"]");

        // 3. 숫자 합 반환
        int result = 0;
        for (String number:num){
            if(!number.isEmpty()){ // 비었을 경우, 0처럼 처리
                try{
                    int temp = Integer.parseInt(number);
                    // 예외 : 숫자에 음수가 있는 경우
                    if(temp<0){
                        throw new IllegalArgumentException();
                    }
                    result += temp;
                } catch (NumberFormatException e){ // 예외 : 구분자가 아닌 문자가 있는 경우 == 숫자 변환이 불가능할 경우
                    throw new IllegalArgumentException();
                }
            }
        }
        System.out.println(result);
    }
}
