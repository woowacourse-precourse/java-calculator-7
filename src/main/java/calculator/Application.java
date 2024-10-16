package calculator;

import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
import static calculator.CalculatorFunctions.*;

public class Application {

    public static void main(String[] args) {

        String str = Console.readLine();
        int result;

        // 커스텀 구분자가 있는지 확인
        if (str.startsWith("//")) {
            result = useCustomDelimiter(str);
        } else {
            // 각 숫자의 합을 구하기
            result = splitAndSum(str,"");
        }

        System.out.println("결과 : " + result);
    }



}
