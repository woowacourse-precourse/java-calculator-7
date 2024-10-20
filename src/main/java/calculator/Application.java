package calculator;

import camp.nextstep.edu.missionutils.Console;
import static calculator.CalculatorFunctions.*;

public class Application {

    public static void main(String[] args) {
        String str = Console.readLine();
        int result;

        // 커스텀 구분자가 있는지 확인
        if (str.startsWith("/")) {
            if(checkStructure(str.substring(0,5))) {
                str = customDelimiter(str);
            } else {
                throw new IllegalArgumentException("잘못된 형식 : 커스텀 구분자 구조가 잘못 설정되었습니다.");
            }
        }

        // 각 숫자의 합을 구하기
        result = splitAndSum(str);
        System.out.println("결과 : " + result);
    }
}
